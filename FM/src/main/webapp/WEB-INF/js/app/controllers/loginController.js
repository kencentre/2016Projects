/**
 * Created by jack on 2015/10/14.
 */

/**
 * 用户登录，管理页面
 * @type {string}
 */

var UNAME_COOKIE_NAME = "lastLoginUserName";

$(function(){
    // 如果name 没有 value，将cookie 中存储过的name 值写入
    var eleName = $("input[name=name]");
    eleName.val(Cookie.get(UNAME_COOKIE_NAME));

    // 禁止复制粘贴
    $("input:password").bind("copy cut paste",function(e){
        return false;
    });

    // 加载验证码
    drawCaptcha();
});

function drawCaptcha(){
    //var formParam = $("#form1").serialize();//序列化表格内容为字符串
    $.ajax({
        type: "GET",
        url:baseURL+"preLogin",
        success: function(data,textStatus){
            console.log(data);
            console.log(textStatus);
            $("#captchaImg").attr("src",data.imgData);
        },
        error:function(error){
            alert("验证码加载失败");
            console.log(error);
        }
    });
}

function doMD5(param1,param2){
    return ($.md5($.md5(param1)+ param2));
}


'use strict';

var app= angular.module('app',
    [ 'app.appService','rmbFilter']);

app.controller('LoginCtrl', ['$scope', 'UserLoader',
    function($scope, UserLoader) {

        $scope.$watch('username',function(newVal,oldVal,scope){
            if(newVal == oldVal){

            }else{
                console.log('username is :' + $scope.username);
            }
        });
        $scope.username = Cookie.get(UNAME_COOKIE_NAME);
        $scope.login = function(){
             console.log($scope.username);
             if($scope.captcha!=null){
                 // 写cookie
                 Cookie.set(UNAME_COOKIE_NAME, $scope.username,null,7*24*60);
                 {
                     //console.log("原来的密码是" + $scope.password);

                     var username = doMD5($scope.username,$scope.captcha);
                     var password=doMD5($scope.password,$scope.captcha);
                     //console.log("加密后的密码" + password);
                     var loginInfo = {
                         'name':username,
                         'password':password,
                         'captcha':$scope.captcha,
                         'rememberMe':false
                     };
                     UserLoader.result(loginInfo)
                         .success(function(data,status,header,config){
                             console.log("success:"+ data.result);
                             if(data.result == true){
                                 $scope.error = false;
                                 gotoCardManage();
                             }else{
                                 //alert(data.info);
                                 console.log("error 123:"+ data.info);
                                 $scope.error = true;
                                 $scope.errorInfo = data.info;
                                 $scope.username = Cookie.get(UNAME_COOKIE_NAME);
                                 $scope.password = null;
                                 $scope.captcha = null;
                                 drawCaptcha();

                             }

                         }).error(function(data,status,header,config){
                             console.log("error:"+ data);
                             //alert(data.info);
                             $scope.error = true;
                             $scope.errorInfo = data;
                             drawCaptcha();
                         })
                 }
             }
        };

    }]);

