<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>BREAKING NEWS</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/news.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/font-awesome.min.css" />">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/ng-table.min.css" />">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/bootstrap.min.css"/>">
    <script type="text/javascript" src="<c:url value="/resources/js/angular.min.js" /> "></script>
    <script type="text/javascript" src="<c:url value="/resources/js/angular-resource.js" />"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/ng-table.min.js" /> "></script>
    <script type="text/javascript" src="<c:url value="/resources/js/bootstrap.min.js" /> "></script>
    <script type="text/javascript" src="<c:url value="/resources/js/ui-bootstrap-tpls-0.12.0.min.js" /> "></script>


<body ng-app="main">

    <h1 class="mainHead"><spring:message code="news.list" /></h1>
    <form action="add" method="post">
        <div id="addBtn">
            <button type="submit" id="newBtn"><spring:message code="button.new" /></button>
        </div>
    </form>

    <div ng-controller="MyCtrl">
        <table ng-table="tableParams" class="table table-striped">
            <tr ng-repeat="itm in data">
                <td data-title="'Date'">
                    <div class="newsDate">{{itm.date}}</div>
                </td>
                <td data-title="'News'">
                    <div class="head">{{itm.head}}</div>
                    <div class="body">{{itm.body}}</div>
                    <div class="readMore">
                        <button ng-click="readMoreClick(itm.id)" id="readMoreButton" class="btn btn-primary"><spring:message code="button.read.more" /></button>
                    </div>
                </td>
            </tr>
        </table>

    </div>

<script>

    var app = angular.module('main', ["ngTable"]);

    app.controller('MyCtrl', function ($scope, $http, $filter, ngTableParams) {
        var urlBase = <spring:message code="server.url" />;
       $scope.tableParams = new ngTableParams({
            page: 1,
            count: 10
        }, {
            total: 1,
            getData: function ($defer, params) {
                $http.get(urlBase +'/list').then(function(response) {
                    $scope.data = response.data.slice((params.page() - 1) * params.count(), params.page() * params.count());
                    $defer.resolve($scope.data);
                     });
            }
        });
        
        $scope.readMoreClick = function (newsId) {
            $http.get(urlBase + '/' + newsId);
        }
    });


</script>

</body>
</html>
