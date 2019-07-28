<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: mj
  Date: 7/23/2019
  Time: 8:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cart</title>
    <style>
        body {
            text-align: center;
        }
        table {
            margin: 0 auto 0 auto;
        }
    </style>
</head>
<body>
<h1 id="h1_1">${emptyCartMsg}</h1>

        <table id="tab1" cellpadding="10" border="2">
            <th>Item id</th>
            <th>Item Name</th>
            <th>Quantity</th>
            <th>Price</th>
            <c:forEach var="cart" items="${cartItems}">
                <tr>
                    <td>${cart.itemId}</td>
                    <td>${cart.itemName}</td>
                    <td>${cart.quantity}</td>
                    <td>${cart.price}</td>
                </tr>
            </c:forEach>
        </table><br><br>

    <input id="btn1" type="button" value="CheckOut" onclick="checkout()">
    <input type="button" value="Go Back" onclick="myFunc()">
</body>
<script language="JavaScript">
    msg = "${emptyCartMsg}";
    if(msg.charAt(msg.length-1) != ':') {
        document.getElementById("tab1").style.visibility = "hidden";
        document.getElementById("btn1").style.visibility = "hidden";
    }
    function myFunc() {
        location.href = "/Welcome";
    }
    function checkout() {
        location.href = "/Checkout";
    }
</script>
</html>
