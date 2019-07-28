<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: mj
  Date: 7/25/2019
  Time: 10:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Checkout</title>
    <style>
        h2 {
            color: green;
        }
        body {
            text-align: center;
        }
        table {
            margin: 0 auto 0 auto;
        }
    </style>
</head>
<body>
    <h2>${Success}</h2>
    <table cellpadding="10" border="2">
        <th>Item Id</th>
        <th>Item Name</th>
        <th>Quantity</th>
        <th>Price</th>
        <c:forEach var="cart" items="${cartList}">
            <tr>
                <td>${cart.itemId}</td>
                <td>${cart.itemName}</td>
                <td>${cart.quantity}</td>
                <td>${cart.price}</td>
            </tr>
        </c:forEach>
    </table><br><br>

    <input type="button" value="Continue Shopping" onclick="myFunc()" />
</body>
<script language="JavaScript">
    function myFunc() {
        location.href = "/Welcome";
    }
</script>
</html>
