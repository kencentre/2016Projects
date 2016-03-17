/**
 * Created by jack on 2015/11/16.
 */
/**
 * Created by jack on 2015/10/4.
 */
'use strict';
var recordService = angular.module('appManage.recordService',
    ['ngResource','ngRoute']);
recordService.factory('Record', ['$resource',
    function($resource) {
        return $resource(baseUrl+'record/:id', {id: '@recordId'});
    }]);

recordService.factory('RecordPage', ['$resource',
    function($resource) {
        return $resource(baseUrl+'record/page/:id', {id: '@pageNumber'});
    }]);


recordService.factory('MultiRecordLoader', ['RecordPage', '$q', '$route',
    function(RecordPage, $q,$route) {
        return {getAllRecords: function() {
            console.log("路径中的参数有"+$route.current.params.pageNumber +"  "
            + $route.current.params.startTime + " " +$route.current.params.startTime +" "+
            $route.current.params.itemIndex);
            var delay = $q.defer();
            if($route.current.params.itemIndex == null){
                RecordPage.get({
                    id:$route.current.params.pageNumber,
                    type:0 // 必须加一个参数后台才能识别
                },function(records) {
                    delay.resolve(records);
                }, function() {
                    delay.reject('Unable to fetch cards');
                });
            }else{
                RecordPage.get({
                    id:$route.current.params.pageNumber,
                    type:1,
                    itemIndex: $route.current.params.itemIndex,
                    startTime: $route.current.params.startTime,
                    endTime:$route.current.params.endTime

                },function(records) {
                    delay.resolve(records);
                }, function() {
                    delay.reject('Unable to fetch cards');
                });
            }

            return delay.promise;
        }};
    }]);

//recordService.factory('MultiRecordLoaderByCondition', ['RecordPage', '$q', '$route',
//    function(RecordPage, $q,$route) {
//        return {getAllRecords: function() {
//            var delay = $q.defer();
//            RecordPage.save({id:$route.current.params.pageNumber
//            },{
//
//            }, function(records) {
//                delay.resolve(records);
//            }, function() {
//                delay.reject('Unable to fetch cards');
//            });
//            return delay.promise;
//        }};
//    }]);

recordService.factory('RecordLoaderByCondition', ['$http','$route',
    function($http,$route) {
        var runConditionSearchRequest = function(condition){
            return $http({
                method:'POST',
                url:baseURL+'record/page/'+$route.current.params.pageNumber,
                data:condition
            });
        };
        return {
            result: function(condition){
                return runConditionSearchRequest(condition);
            }
        }
    }]);

recordService.factory('RecordLoader', ['Record', '$route', '$q',
    function(Record, $route, $q) {
        return {getRecordById: function() {
            var delay = $q.defer();
            Record.get({id: $route.current.params.recordId}, function(record) {
                delay.resolve(record);
            }, function() {
                delay.reject('Unable to fetch record '  + $route.current.params.recordId);
            });
            return delay.promise;
        } };
    }]);
