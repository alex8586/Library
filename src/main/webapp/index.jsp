<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Main page</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="css/index.css"/> ">
</head>
<body>
    <div class="wrapper">
        <div class="main">
            <h1>Welcome to test task</h1>
        </div>
        <div class="links">
            <a href="<c:url value="/userlist/0"/> ">To the User list</a>
        </div>
    </div>
</body>
</html>
