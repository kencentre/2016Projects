/**
 * Created by jack on 2015/12/2.
 */

//var baseURL = "http://121.42.217.4/FinancialManagement/";
//var baseURL = "http://127.0.0.1:8080/financial/";
var baseURL = "/financial/";


var appService = angular.module('app.appService',
    []);


appService.factory('UserLoader', ['$http',
    function($http) {
        var runLoginRequest = function(loginInfo){
            return $http({
                method:'POST',
                url:baseURL+'login',
                data:loginInfo
            });
        };
        return {
            result: function(loginInfo){
                return runLoginRequest(loginInfo);
            }
        }
    }]);

appService.factory('UserExit', ['$http',
    function($http) {
        var runLogoutRequest = function(){
            return $http({
                method:'GET',
                url:baseURL+'logout'
            });
        };
        return {
            result: function(){
                return runLogoutRequest();
            }
        }
    }]);
