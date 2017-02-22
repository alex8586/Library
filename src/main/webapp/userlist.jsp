<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User list</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="css/userlist.css"/> ">
</head>
<body>
    <div class="wrapper">
        <div class="users">
            <p>User list :</p>

            <c:if test="${not empty requestScope.userlist}">
                <c:forEach items="${requestScope.userlist}" var="user">
                    <a href="">${user.name}</a><br>
                </c:forEach>
            </c:if>
        </div>
        <div class="books">
            <p>Available books :</p>
            <c:if test="${not empty requestScope.booklist}">
                <c:forEach items="${requestScope.booklist}" var="book">
                    ${book.id} &nbsp ${book.title}<br>
                </c:forEach>
            </c:if>
        </div>
    </div>
</body>
</html>
