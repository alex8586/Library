<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User list</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/user_list.css"/> ">
</head>
<body>
    <div class="wrapper">
        <div class="users">
            <p>User list :</p>

            <c:if test="${not empty requestScope.userList}">
                <c:forEach items="${requestScope.userList}" var="user">
                    <a href="<c:url value="/userDetail/${user.id}"/> ">${user.name}</a><br>
                </c:forEach>

                <br>
                Pages :
                <c:if test="${requestScope.currentPage > 0}">
                    <a href="<c:url value="/userlist/${requestScope.currentPage - 1}"/> ">previous</a>
                </c:if>

                ${requestScope.currentPage}

                <c:if test="${requestScope.maxPage > requestScope.currentPage + 1}">
                    <a href="<c:url value="/userlist/${requestScope.currentPage + 1}" /> ">next</a>
                </c:if>
            </c:if>
            <br>
            <c:if test="${empty requestScope.userList}">
                There are no users in list
            </c:if>
            <br>
            <p>Add new user :</p>
            <form action="<c:url value="/createUser"/> " method="post">
                <input type="hidden" name="id" value="0">
                Name <input type="text" name="name"> &nbsp;<span class="error">${sessionScope.nameCreatingUserError}</span> <br>
                Age &nbsp;&nbsp;&nbsp;<input type="text" name="age" > &nbsp;<span class="error">${sessionScope.ageCreatingUserError}</span><br>
                <button type="submit">Create user</button>
            </form>
        </div>
        <div class="books">
            <p>Available books :</p>
            <c:if test="${not empty requestScope.bookList}">
                <c:forEach items="${requestScope.bookList}" var="book">
                    ${book.title}<br>
                </c:forEach>
            </c:if>
        </div>
    </div>
</body>
</html>
