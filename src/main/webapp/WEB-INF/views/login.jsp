<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: mj
  Date: 7/21/2019
  Time: 10:34 PM
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <style>
        form, h3 {
            text-align: center;
        }

    </style>
</head>
<body>


<form:form action="/ValidateCustomer" method="get" modelAttribute="customer">
    <h1>Welcome user! Please Login to continue</h1>
    Username: <form:input type="text" path="username"/> <br><br>
    Password: <form:input type="password" path="password"/> <br><br>
    <input type="submit" value="Login"> <br><br>
    <input type="button" onclick="myFunc()" value="Register"> <br><br>
</form:form>


<h3 id="log-msg">${loginMessage}</h3>

<script language="JavaScript">
    function myFunc() {
        location.href = "/registerPage";
    }

    msg = "${loginMessage}";
    if(msg.charAt(0) == 'R') document.getElementById("log-msg").style.color = "green";
    else document.getElementById("log-msg").style.color = "red";

</script>

</body>
</html>
