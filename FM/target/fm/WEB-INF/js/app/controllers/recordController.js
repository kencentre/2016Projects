/**
* Created by jack on 2015/11/16.
*/

/**
 * 记录业务路由管理，及控制器
 */

'use strict';

appManage.config(['$routeProvider', function($routeProvider) {
    $routeProvider.
        when('/card/records/:pageNumber', {
            controller: 'InListCtrl',
            resolve: {
                records: ["MultiRecordLoader", function(MultiRecordLoader) {
                    return MultiRecordLoader.getAllRecords();
                }]
            },
            templateUrl:'records.html'
        }).when('/card/record/edit/:recordId', {
            controller: 'InEditCtrl',
            resolve: {
                record: ["RecordLoader", function(RecordLoader) {
                    return RecordLoader.getRecordById();
                }]
            },
            templateUrl:'recordEdit.html'
        }).when('/card/record/view/:recordId', {
            controller: 'InViewCtrl',
            resolve: {
                record: ["RecordLoader", function(RecordLoader) {
                    return RecordLoader.getRecordById();
                }]
            },
            templateUrl:'viewRecord.html'
        }).when('/card/record/new/', {
            controller: 'InNewCtrl',
            templateUrl:'recordForm.html',
            resolve:{
                currentCard: ["CurrentCard", function(CurrentCard) {
                    return CurrentCard.getCurrentCard();
                }]
            }
        }).otherwise({redirectTo:'/card/records/1'});
}]);

appManage.controller('InListCtrl', ['$scope', 'records','$location','RecordLoaderByCondition', '$route',
    function($scope, records,$location,RecordLoaderByCondition,$route) {


        /**
         * 分页查询信息
         */
        $scope.pageNext= records.pageNo;
        $scope.currentPage= records.currentPage;
        $scope.pageSize= records.pageSize;
        $scope.totalCount= records.totalCount;
        $scope.pageCount= records.pageCount;
        // 查询结果
        $scope.records = records.results;
        console.log($scope.records);

        /**
         * 当前下载excel url
         */
        $scope.excelUrl = baseURL + "download_excel";

        /**
         * 条件查询初始值
         * @type {{itemIndex: number, startTime: string, endTime: string}}
         */
        $scope.condition = {
            itemIndex:$route.current.params.itemIndex,
            //startTime:"1995-04-04 00:57:04",
            startTime:$route.current.params.startTime,
            endTime:$route.current.params.endTime
            //endTime:"2095-04-04 00:57:04"
        };
        // 条件查询是否点击
        $scope.selectElement =$route.current.params.itemIndex != null;
        $scope.doFilter = function(){
            $scope.selectElement= true;
        };
        $scope.hideFilter = function(){
            $scope.selectElement= false;
        };

        // 查询下一页
        $scope.next = function(){
                    var pageNumber = $scope.currentPage+1;
            if($route.current.params.itemIndex == null){
                $location.path('/card/records/'+ pageNumber);
            }else{
                $location.path('/card/records/'+ pageNumber)
                    .search({itemIndex: 1,startTime:$route.current.params.startTime,endTime:$route.current.params.endTime});
                //.search({itemIndex:$scope.condition.itemIndex,startTime:$scope.condition.startTime,endTime:$scope.condition.endTime});
            }

        };

        // 查询上一页
        $scope.previous = function(){
            var pageNumber = $scope.currentPage-1;

            if($scope.currentPage > 1) {
                if ($route.current.params.itemIndex == null) {
                    $location.path('/card/records/' + pageNumber);
                } else {
                $location.path('/card/records/' + pageNumber)
                    .search({
                        itemIndex: 1,
                        //itemIndex: $route.current.params.itemIndex,
                        startTime: $route.current.params.startTime,
                        endTime: $route.current.params.endTime
                    });
                //.search({itemIndex:$scope.condition.itemIndex,startTime:$scope.condition.startTime,endTime:$scope.condition.endTime});
                }
            }
        };


        $scope.conditionSearch = function(){
            if($scope.condition.startTime==null && $scope.condition.endTime == null){
                $location.path('/card/records/'+ 1).search();
            }else if($scope.condition.startTime==null){
                $location.path('/card/records/'+ 1)
                    .search({itemIndex:1,endTime:$scope.condition.endTime});
            }else if($scope.condition.endTime==null){
                $location.path('/card/records/'+ 1)
                    .search({itemIndex:1,startTime:$scope.condition.startTime});
            }else{
                $location.path('/card/records/'+ 1)
                    .search({itemIndex:1,startTime:$scope.condition.startTime,endTime:$scope.condition.endTime});
            }

            //$scope.condition.itemIndex = 0;
            //console.log($scope.condition);
            //
            //RecordLoaderByCondition.result($scope.condition)
            //    .success(function(data,status,header,config){
            //        console.log("success:"+ data);
            //        $scope.pageNext= data.pageNo;
            //        $scope.currentPage= data.currentPage;
            //        $scope.pageSize= data.pageSize;
            //        $scope.totalCount= data.totalCount;
            //        $scope.pageCount= data.pageCount;
            //
            //        $scope.records = data.results;
            //    }).error(function(data,status,header,config){
            //        console.log("error:"+ data);
            //        //alert(data.info);
            //    });
        }

    }]);

appManage.controller('InViewCtrl', ['$scope', '$location', 'record',
    function($scope, $location, record) {

        $scope.record = record;
        console.log(record);
        //var money = $scope.record.money;
        ////console.log("123" | RMB);
        //$scope.record.money = "" + money;
        $scope.edit = function() {
            $location.path('/card/record/edit/' + record.recordId);
        };

        $scope.remove = function() {
            $scope.record.$remove(function(record) {
                $location.path('/card/records/:recordId');
            });
        };

    }]);

appManage.controller('InEditCtrl', ['$scope', '$location', 'record',
    function($scope, $location, record) {
        $scope.isNew = false;
        $scope.record = record;
        console.log($scope.record);
        // 调用后台 post 更新，如果想用put，可以自定义$ resource  put 与 $ put 服务
        $scope.save = function() {
            $scope.record.$save(function(record) {
                $location.path('/card/view/' + record.recordId);
            });
        };

        $scope.back = function(){
            $location.path('/card/records/');
        }

    }]);

appManage.controller('InNewCtrl', ['$scope', '$location', 'Record','currentCard',
    function($scope, $location, Record,currentCard) {
        $scope.isNew = true;

        $scope.record = new Record({
        });
        if(currentCard != null)
        $scope.record.card = currentCard;

        console.log(currentCard);
        $scope.$watch('record.itemIndex',function(newVal,oldVal,scope){
            if(newVal == oldVal){

            }else{
                console.log('index is :' + $scope.record.itemIndex);
            }
        });

        $scope.save = function() {
            console.log("金额："+ $scope.record.count);
            console.log("index is"+ $scope.record.itemIndex);

            $scope.record.$save(function(result) {
                if(result != false ){
                    $location.path('/card/records/');
                }else{
                    alert("系统错误！");
                }
            });
        };

        //$scope.getFile = function () {
        //    fileReader.readAsDataUrl($scope.file, $scope)
        //        .then(function(result) {
        //            $scope.imageSrc = result;
        //        });
        //};
    }]);

