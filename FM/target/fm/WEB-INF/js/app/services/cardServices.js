/**
 * Created by jack on 2015/10/4.
 */
'use strict';
//var baseUrl = "http://121.42.217.4/FinancialManagement/";
//var baseUrl = "http://127.0.0.1\\:8080/financial/";
var baseUrl = "/financial/";

var cardServices = angular.module('appManage.cardServices',
    ['ngResource','ngRoute']);

cardServices.factory('Card', ['$resource',
    function($resource) {
        return $resource(baseUrl+'cards/:id', {id: '@cardId'});
    }]);

cardServices.factory('MultiCardLoader', ['Card', '$q',
    function(Card, $q) {
        return {getAllCards: function() {
            var delay = $q.defer();
            Card.query(function(cards) {
                delay.resolve(cards);
            }, function() {
                delay.reject('Unable to fetch cards');
            });
            return delay.promise;
        } };
    }]);

cardServices.factory('CardLoader', ['Card', '$route', '$q',
    function(Card, $route, $q) {
        return {getCardById: function() {
            var delay = $q.defer();
            Card.get({id: $route.current.params.cardId}, function(card) {
                delay.resolve(card);
            }, function() {
                delay.reject('Unable to fetch card '  + $route.current.params.cardId);
            });
            return delay.promise;
        } };
    }]);


cardServices.factory('Current', ['$resource',
    function($resource) {
        return $resource(baseUrl+'current');
    }]);

cardServices.factory('CurrentCard', ['Current', '$route', '$q',
    function(Current, $route, $q) {
        return {getCurrentCard: function() {
            var delay = $q.defer();
            Current.get({}, function(card) {
                delay.resolve(card);
            }, function() {
                delay.reject('Unable to fetch current card ');
            });
            return delay.promise;
        } };
    }]);

//cardServices.factory('SetCurrent', ['Current', '$route', '$q',
//    function(Current, $route, $q) {
//        return {setCurrentCard: function(currentCard) {
//            var delay = $q.defer();
//            Current.save({}, {
//               Card: currentCard
//            },function(card) {
//                delay.resolve(card);
//            }, function() {
//                delay.reject('Unable to fetch current card ');
//            });
//            return delay.promise;
//        } };
//    }]);

cardServices.factory('SetCurrent', ['$http',
    function($http) {
        var setCurrentCard = function(currentCard){
            return $http({
                method:'POST',
                url:baseURL+'current',
                data:currentCard
            });
        };
        return {
            updateResult: function(currentCard){
                return setCurrentCard(currentCard);
            }
        }
    }]);

cardServices.factory('GetCurrent', ['$http',
    function($http) {
        var getCurrentCard = function(){
            return $http({
                method:'GET',
                url:baseURL+'current'
            });
        };
        return {
            getResult: function(){
                return getCurrentCard();
            }
        }
    }]);
//cardServices.factory('fileReader', ["$q", "$log", function($q, $log){
//    var onLoad = function(reader, deferred, scope) {
//        return function () {
//            scope.$apply(function () {
//                deferred.resolve(reader.result);
//            });
//        };
//    };
//    var onError = function (reader, deferred, scope) {
//        return function () {
//            scope.$apply(function () {
//                deferred.reject(reader.result);
//            });
//        };
//    };
//    var getReader = function(deferred, scope) {
//        var reader = new FileReader();
//        reader.onload = onLoad(reader, deferred, scope);
//        reader.onerror = onError(reader, deferred, scope);
//        return reader;
//    };
//    var readAsDataURL = function (file, scope) {
//        var deferred = $q.defer();
//        var reader = getReader(deferred, scope);
//        reader.readAsDataURL(file);
//        return deferred.promise;
//    };
//    return {
//        readAsDataUrl: readAsDataURL
//    };
//}]);