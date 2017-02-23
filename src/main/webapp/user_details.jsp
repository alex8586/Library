<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User details</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/user_details.css"/> ">
</head>
<body>
    <div class="wrapper">

        <p><a href="<c:url value="/userlist"/> ">To the User list</a></p>
        <div class="user">
            <p>User :</p>
            <c:if test="${not empty requestScope.user}">

                User id :${requestScope.user.id}<br>
                User name : ${requestScope.user.name}<br>
                User age : ${requestScope.user.age}<br>
                <p>User books :</p>

                <c:if test="${not empty requestScope.user.bookList}">
                    <c:forEach items="${requestScope.user.bookList}" var="book">
                        ${book.title}<br>
                    </c:forEach>
                </c:if>
                <c:if test="${empty requestScope.user.bookList}">
                    ${requestScope.user.name} has no books
                </c:if>

            </c:if>
        </div>

        <div class="change">
            <form action="<c:url value="/updateUserDetail"/> " method="post">
                <input type="hidden" name="id" value="${requestScope.user.id}">
                Name <input type="text" name="name"><br>
                Age <input type="text" name="age"><br>
                <button type="submit">Update user</button>
            </form>
        </div>

    </div>

</body>
</html>
