/**
 * Created by jack on 2015/10/4.
 */
'use strict';
var appManage= angular.module('appManage',
    [ 'appManage.directives', 'appManage.cardServices','appManage.recordService','rmbFilter','app.appService']);

/**
 *  请求拦截器，拦截前端所有请求，判断用户是否授权
 */
appManage.factory('MyInterceptor',['$q',function($q){
    var intercepter= {
        'request':function(config){
            console.log("request success: \n" + config);
            // 成功请求方法
            return config;  // 或者 $q.when(config);
        },
        'response':function(response){
            console.log("response success : \n"+ response);
            // 响应成功
            return response;  // 或者  $q.when(config);
        },
        'requestError':function(rejection){
            console.log("request Error: \n"+rejection);
            // 请求发生了错误，如果能从错误中恢复，可以返回一个新的请求或 promise
            return rejection;  // 或者新的 promise
            // 或者，可以通过返回一个rejection来阻止下一步
            // return $q.reject(rejection);
        },
        'responseError':function(response){
            console.log("response Error: \n"+response);
            // 请求发生了错误，如果能从错误中恢复，可以返回一个新的响应或 promise
            //return response;  // 或者新的 promise
            // 或者，可以通过返回一个rejection来阻止下一步
            // return $q.reject(rejection);
            // Session has expired
            if (response.status == 401){
                gotoLogin();
            }
            return $q.reject(response);
        }
    };
    return intercepter;
}]);

// 将拦截器注入
appManage.config(function($httpProvider){
        $httpProvider.interceptors.push('MyInterceptor');
    });

/**
 *  对卡业务操作，跳转逻辑
 */
appManage.config(['$routeProvider', function($routeProvider) {
    $routeProvider.
        when('/card/', {
            controller: 'ListCtrl',
            resolve: {
                cards: ["MultiCardLoader", function(MultiCardLoader) {
                    return MultiCardLoader.getAllCards();
                }]
            },
            templateUrl:'cards.html'
        }).when('/card/edit/:cardId', {
            controller: 'EditCtrl',
            resolve: {
                card: ["CardLoader", function(CardLoader) {
                    return CardLoader.getCardById();
                }]
            },
            templateUrl:'cardEdit.html'
        }).when('/card/view/:cardId', {
            controller: 'ViewCtrl',
            resolve: {
                card: ["CardLoader", function(CardLoader) {
                    return CardLoader.getCardById();
                }]
            },
            templateUrl:'viewCards.html'
        }).when('/card/new', {
            controller: 'NewCtrl',
            templateUrl:'cardForm.html'
        }).otherwise({redirectTo:'/card/'});
}]);

/**
 *  控制器部分
 */
appManage.controller('ListCtrl', ['$scope', 'cards','SetCurrent',
    function($scope, cards,SetCurrent) {
        $scope.cards = cards;

        $scope.gotoManageMoney = function(card){
            SetCurrent.updateResult(card)
                .success(function(data,status,header,config){
                console.log("success:"+ data);
                if(data == 'true'){
                    gotoManagement();
                }else{
                    console.log("error:"+ data);
                }
            }).error(function(data,status,header,config){
                console.log("error:"+ data);
            });

        }
    }]);

appManage.controller('ViewCtrl', ['$scope', '$location', 'card',
    function($scope, $location, card,rmb) {

        $scope.card = card;
        var money = $scope.card.money;
        $scope.card.money = "" + money;
        $scope.edit = function() {
            $location.path('/card/edit/' + card.cardId);
        };

        $scope.remove = function(button) {
            $scope.card.$remove(function(card) {
                button.dataDismiss = "modal";
                $location.path('/card/');
            });
        };

    }]);

appManage.controller('EditCtrl', ['$scope', '$location', 'card',
    function($scope, $location, card) {
        $scope.card = card;
        console.log($scope.card);
        $scope.save = function() {
            $scope.card.$save(function(card) {
                $location.path('/view/' + card.cardId);
            });
        };
    }]);

appManage.controller('NewCtrl', ['$scope', '$location', 'Card',
    function($scope, $location, Card) {
        $scope.card = new Card({
            items: [{}]
        });
        console.log($scope.card);

        $scope.save = function() {
            $scope.card.money = 0;
            $scope.card.$save(function(card) {
                $location.path('/');
            });
            console.log($scope.card);
        };

    }]);


appManage.controller('ItemsCtrl', ['$scope',
    function($scope) {
        $scope.addItem = function() {
            var items = $scope.card.items;
            items[items.length] = {};
        };
        $scope.removeItem = function(index) {
            if($scope.card.items[index].itemCount > 0){
                alert("无法删除，该项目存在未使用金额："+ $scope.card.items[index].itemCount);
            }else{
                $scope.card.items.splice(index, 1);

            }
        };

}]);



