<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: mj
  Date: 7/21/2019
  Time: 10:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
    <style>
        form, p {
            text-align: center;
        }
        p {
            color: red;
        }
    </style>
</head>
<body>
<form:form action="/RegisterCustomer" method="post" modelAttribute="customer">
    <h1>Please Register to create a new Account</h1>
    Username: <form:input type="text" path="username" /> <br><br>
    Password: <form:input type="password" path="password"/> <br><br>

    <input type="submit" value="Register"><br><br>
</form:form>

<p id="log-msg">${regMsg}</p>

</body>
</html>
