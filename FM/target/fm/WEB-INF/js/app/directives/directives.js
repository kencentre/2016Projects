/**
 * Created by jack on 2015/10/4.
 */
'use strict';

var directives = angular.module('appManage.directives', []);

directives.directive('butterbar', ['$rootScope',
    function($rootScope) {
        return {
            link: function(scope, element, attrs) {
                element.addClass('hide');

                $rootScope.$on('$routeChangeStart', function() {
                    element.removeClass('hide');
                });

                $rootScope.$on('$routeChangeSuccess', function() {
                    element.addClass('hide');
                });
            }
        };
    }]);
directives.directive('infoState', ['$rootScope',
    function($rootScope) {
        return {
            link: function(scope, element, attrs) {
                element.addClass('hide');

                $rootScope.$on('$routeChangeStart', function() {
                    element.addClass('hide');
                });

                $rootScope.$on('$routeChangeSuccess', function() {
                    element.removeClass('hide');
                });
            }
        };
    }]);
var filters = angular.module('rmbFilter', []);

filters.filter('rmb',['$rootScope',function($rootScope){
    return function(input){
        if(input){
            var length = input.length;
            if(length > 2){
                console.log(length);
                var jiaofen = input[length-1]+input[length-2];
                return input.substring(0,length-2) + '.'+jiaofen;
            }else{
                return (length==1? "0.0":"0.") + input;
            }

        }
    }
}]);
//directives.directive('focus',
//    function() {
//        return {
//            link: function(scope, element, attrs) {
//                element[0].focus();
//            }
//        };
//    });
//directives.directive('fileModel', ['$parse', function ($parse) {
//    return {
//        restrict: 'A',
//        link: function(scope, element, attrs, ngModel) {
//            var model = $parse(attrs.fileModel);
//            var modelSetter = model.assign;
//            element.bind('change', function(event){
//                scope.$apply(function(){
//                    modelSetter(scope, element[0].files[0]);
//                });
//                //附件预览
//                scope.file = (event.srcElement || event.target).files[0];
//                scope.getFile();
//            });
//        }
//    };
//}]);