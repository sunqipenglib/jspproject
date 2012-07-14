<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="../common.jsp" %>
<script type="text/javascript">

    var simpleAppModule = angular.module('simpleApp', []);

    // configure the module.
    // in this example we will create a greeting filter
    simpleAppModule.filter('greet', function () {
        return function (name) {
            return 'Hello, ' + name + '!';
        };
    });

    var UserInforController = function ($scope, $http, $window) {
        $scope.usersajax =${ajaxUsers};

        $scope.currentDate;
        $scope.user;

        $scope.save = function () {

            //$window.alert($scope.form.name.$valid);
            if ($scope.form.name.$valid &&
                    $scope.form.email.$valid &&
                    $scope.form.address.$valid &&
                    $scope.form.dob.$valid
                    ) {
                $http({url:'${baseUrl}users/addAjax',
                            method:'POST',
                            params:$scope.user}
                ).success(
                        function (data) {
                            $scope.usersajax = data;
                            $scope.user = "";
                        }).error(function (data) {
                            //$scope.errorMessage = data;
                        });
            } else {
                $window.alert("there a some error");
            }
        };

        $scope.updateUser = function (user) {
            $scope.user = user;
        }

        $scope.deleteUser = function (id) {

            $http.get("${baseUrl}users/delete/" + id).success(function (data) {
                $scope.usersajax = data;
            })
        };


        $scope.getDate = function () {
            $http.get("date").success(function (data) {

                $scope.currentDate = data;
                $scope.user.dob = data;
            })
        };
        $scope.test = function (value) {
            $window.alert(value);
        }

        $("input[type=button]").button();
        $("save1").dialog();
        $("#dob").datepicker();
    }
</script>
<style type="text/css">
    input.ng-invalid.ng-dirty {
        background-color: #FA787E;
    }

    input.ng-valid.ng-dirty {
        background-color: #78FA89;
    }
</style>
<body ng-app ng-controller="UserInforController">
<div id="header">Header</div>
<div id="sidebar">
    <h1>
        <a href="#">新增用户</a>
    </h1>

</div>
<div id="container">
    <div id="content">

        <div class="panel">
        这里验证的关键是使用name属性input元素和验证的相关变量串联起来
        </div>

        <div class="panel" id="save1">
            <form name="form">
                <input type="hidden" ng-model="user.id">
                姓名:<input ng-model="user.name" name="name" required> {{name.$error}}{{form.name.$valid}}<br>
                电子邮箱：<input ng-model="user.email" type="email" name="email" required>
                {{form.email.$error}}{{form.email.$valid}}<br>
                地址：<input ng-model="user.address" name="address">{{form.address.$error}}{{form.address.$valid}}<br>
                出生日期：<input ng-model="user.dob" id="dob" name="dob"> {{form.dob.$error}}{{form.dob.$valid}}<br>

                <input type="button" ng-click="save()" value="保存" id="saveButton">
            </form>
            <br>

            <hr>
        </div>

        <div class="panel">
            Search:<input type="text" placeHolder="search" ng-model="query"/><br/>
            Sort:<select ng-model="sort">
            <option value="id">
                Id
            </option>
            <option value="name">
                name
            </option>
            <option value="email">
                email
            </option>
            <option value="dob">
                dob
            </option>
        </select>
            <input type="button" ng-click="getDate()" value="获取当前时间">当前时间:
            {{currentDate}}
            <table class="dataTable">
                <thead>
                <th>编号</th>
                <th>姓名</th>
                <th>地址</th>
                <th>电子邮件地址</th>
                <th>出生日期</th>
                <th>操作</th>
                </thead>
                <tbody>
                <tr ng-repeat="u in usersajax |  filter : query | orderBy:sort">
                    <td>
                        {{u.id}}
                    </td>
                    <td>
                        {{u.name}}
                    </td>
                    <td>
                        {{u.address}}
                    </td>
                    <td>
                        {{u.email}}
                    </td>
                    <td>
                        {{u.dob}}
                    </td>
                    <td>
                        <input type="button" ng-click="deleteUser(u.id)"
                               class="ui-button ui-widget ui-state-default ui-corner-all" value="删除">
                        <input type="button" ng-click="updateUser(u)"
                               class="ui-button ui-widget ui-state-default ui-corner-all" value="更新">
                    </td>

                </tr>
                </tbody>
            </table>
        </div>
    </div>

</div>

<div id="footer">copyright 2007-2012</div>
</body>
</html>