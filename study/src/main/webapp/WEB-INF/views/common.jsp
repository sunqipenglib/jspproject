<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:url value="/" var="baseUrl">
</c:url>
<html xmlns:ng="http://angularjs.org">
<head>
    <title>Angular Study</title>
    <link rel="stylesheet" type="text/css" href="${baseUrl}/resources/css/screen.css">
    <link rel="stylesheet" type="text/css" href="${baseUrl}/resources/css/smoothness/jquery-ui-1.8.21.custom.css">
    <script type="text/javascript" src="${baseUrl}/resources/js/ajs.js"></script>
    <script type="text/javascript" src="${baseUrl}/resources/js/jquery.js"></script>
    <script type="text/javascript" src="${baseUrl}/resources/js/jqueryui.js"></script>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!--[if lte IE 8]>
    <script>
        document.createElement('ng-include');
        document.createElement('ng-pluralize');
        document.createElement('ng-view');

        // Optionally these for CSS
        document.createElement('ng:include');
        document.createElement('ng:pluralize');
        document.createElement('ng:view');
    </script>
    <![endif]-->
</head>