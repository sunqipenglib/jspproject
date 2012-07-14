<%@ include file="../common.jsp" %>

<script type="text/javascript">

    var UserInforController = function ($scope, $http, $window) {
        $scope.usersajax =${ajaxUsers};

        $scope.currentDate;

        $scope.save = function () {
            $http({url:'${baseUrl}users/addAjax',
                        method:'POST',
                        params:$scope.user}
            ).success(
                    function (data) {
                        $scope.usersajax = data;
                        $scope.user = "";
                    }).error(function () {
                    });
        };

        $scope.deleteUser = function (id) {

//            $window.alert(id);
            $http.get("${baseUrl}users/delete/" + id).success(function (data) {
                $scope.usersajax = data;
            })
        };


        $scope.getDate = function () {
            $http.get("date").success(function (data) {

                $scope.currentDate = data;
            })
        };
        $scope.test = function (value) {
            $window.alert(value);
        }
    }
</script>
<body ng-app ng-controller="UserInforController">
<div id="header">Header</div>
<div id="sidebar">
    <h1>
        <a href="index">User Index</a>
    </h1>

    <h1>
        <a href="add">Add User</a>
    </h1>

</div>
<div id="container">
    <div id="content">

        <div class="panel">
            <input type="hidden" ng-model="user.id">
            <input ng-model="user.name">
            <input ng-model="user.email">
            <input ng-model="user.address">
            <input type="button" ng-click="save()">

            <hr>

            {{user.name}};{{user.email}};{{user.address}};
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
            <input type="button" ng-click="getDate()" value="Get Date">时间
            {{query}} & {{sort}} &{{currentDate}}
            <table class="dataTable">
                <thead>
                <th>id</th>
                <th>name</th>
                <th>address</th>
                <th>email</th>
                <th>dob</th>
                <th>删除</th>
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
                        <input type="button" ng-click="deleteUser(u.id)" value=" Delete">
                    </td>

                </tr>
                </tbody>
            </table>
        </div>
        <div class="panel">
            {{'yet'+'!'}}
        </div>

    </div>

</div>

<div id="footer">copyright 2007-2012</div>
</body>
</html>