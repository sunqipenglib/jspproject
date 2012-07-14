<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:url value="/" var="baseUrl">
</c:url>
<html>
<head>
    <title>Angular Study</title>
    <link rel="stylesheet" type="text/css" href="${baseUrl}/resources/css/screen.css">
    <script type="text/javascript" src="${baseUrl}/resources/js/ajs.js"></script>
</head>
<body>
<a href="${baseUrl}/users/index">User Index</a>
</body>
</html>