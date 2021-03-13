<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Come in Page</title>
</head>
<body>

<%--@elvariable id="authenticationRequestDto" type="task.company.dto.AuthenticationRequestDto"--%>
<form:form action="${pageContext.request.contextPath}api/v1/auth/login"
           modelAttribute="authenticationRequestDto" method="post">
    <li class="span1_of_1 left">
        <h5>Login</h5>
        <div class="book_date">
            <form:input path="username" type="text" placeholder="username"/>
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
                <input type="submit" name="user" value="Come In"/>
            </form>
        </div>
    </li>
</form:form>
</body>
</html>
