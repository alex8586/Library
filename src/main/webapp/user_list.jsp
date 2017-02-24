<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User list</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="css/user_list.css"/> ">
</head>
<body>
    <div class="wrapper">
        <div class="users">
            <p>User list :</p>

            <c:if test="${not empty requestScope.userlist}">
                <c:forEach items="${requestScope.userlist}" var="user">
                    <a href="<c:url value="/userDetail/${user.id}"/> ">${user.name}</a><br>
                </c:forEach>
            </c:if>
            <c:if test="${empty requestScope.userlist}">
                There are no users in list
            </c:if>
            <br>
            <p>Add new user :</p>
            <form action="<c:url value="/createUser"/> " method="post">
                <input type="hidden" name="id" value="0">
                Name <input type="text" name="name"><span class="error">${sessionScope.nameCreatingUserError}</span> <br>
                Age <input type="text" name="age"><span class="error">${sessionScope.ageCreatingUserError}</span><br>
                <button type="submit">Create user</button>
            </form>
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
