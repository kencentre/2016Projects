/**
 * Created by jack on 2015/12/5.
 */

/**
 *  全局控制器，控制退出（注销），回到主界面，当前卡号
 */
appManage.controller('ExitCtrl', ['$scope', 'UserExit',
    function($scope,UserExit) {
        $scope.logout = function(){
            UserExit.result()
                .success(function(data,status,header,config){
                    //console.log(data);
                    if(data == 'true'){
                        gotoLogin();
                    }
                })
        };

    }]);

appManage.controller('HomeCtrl', ['$scope', '$location',
    function($scope) {

        $scope.gotoCardList = function(){
            gotoCardManage();
        };
    }]);


appManage.controller('CurrentCardCtrl', ['$scope', 'GetCurrent',
    function($scope,GetCurrent) {
        if($scope.CURRENT_CARD == null){
            GetCurrent.getResult()
                .success(function(data,status,header,config){
                    console.log("success:"+ data.cardNumber);
                    $scope.CURRENT_CARD = data;
                }).error(function(data,status,header,config){
                    console.log("error:"+ data);
                });
        }
    }]);