<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration Page</title>
</head>
<body>
<%--@elvariable id="registerUserDto" type="task.company.dto.RegisterUserDto"--%>
<form:form action="${pageContext.request.contextPath}api/v1/auth/save"
           modelAttribute="registerUserDto" method="post">
    <li class="span1_of_1 left">
        <h5>Login</h5>
        <div class="book_date">
            <form:input path="username" type="text" placeholder="username"/>
        </div>
    </li>
    <li class="span1_of_1 left">
        <h5>Login</h5>
        <div class="book_date">
            <form:input path="firstName" type="text" placeholder="firstName"/>
        </div>
    </li>
    <li class="span1_of_1 left">
        <h5>Login</h5>
        <div class="book_date">
            <form:input path="lastName" type="text" placeholder="lastName"/>
        </div>
    </li>
    <li class="span1_of_1 left">
        <h5>Login</h5>
        <div class="book_date">
            <form:input path="email" type="text" placeholder="email"/>
        </div>
    </li>
    <li class="span1_of_1 left">
        <h5>Password</h5>
        <div class="book_date">
            <form:input path="password" type="text" placeholder="password"/>
        </div>
    </li>
    <li class="span1_of_3">
        <div class="date_btn">
            <form>
                <input type="submit" name="user" value="Save"/>
            </form>
        </div>
    </li>
</form:form>
</body>
</html>
