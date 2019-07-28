<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: mj
  Date: 7/21/2019
  Time: 10:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome</title>
    <style>
        h2 {
            color: green;
        }
        form {
            text-align: center;
            width: 80%;
            margin: 0 auto 0 auto;
        }
        input {
            border: 0;
            text-align: center;
        }
    </style>
</head>
<body>
    <h1>Welcome ${userName}</h1>
    <h2>${availabilityMsg}</h2>
    <form:form id="form1" action="/AddToCart" method="get" modelAttribute="itemForm">
        <table cellpadding="10" border="2">
            <th>Item id</th>
            <th>Item Name</th>
            <th>Quantity Available</th>
            <th>Price</th>
            <th>Enter Quantity</th>
            <th>Total</th>
            <c:forEach var="item" items="${itemForm.items}" varStatus="status">
                <tr>
                    <td><form:input path="items[${status.index}].id" readonly="true"/></td>
                    <td><form:input path="items[${status.index}].name" readonly="true"/></td>
                    <td><form:input path="items[${status.index}].quantity" readonly="true"/></td>
                    <td><form:input path="items[${status.index}].price" readonly="true"/></td>
                    <td><form:input type="number" id="ip1_${status.index}" path="items[${status.index}].quantityEntered" onchange="myFunc(this.value, ${item.quantity}, ${item.price}, ${status.index})" onkeyup="myFunc(this.value, ${item.quantity}, ${item.price}, ${status.index})" /></td>
                    <td><form:input id="ip2_${status.index}" path="items[${status.index}].priceIncurred" readonly="true"/></td>
                </tr>
            </c:forEach>
        </table><br><br>

            <input id="update-cart" type="submit" value="Update Cart"> <br><br>
            <input type="submit" value="View Cart" onclick="cartBtn2()"> <br><br>
        <h2>${Success}</h2>

    </form:form>

<script language="JavaScript">
    function myFunc(quantityEntered, quantityAvailable, price, val) {
        if(quantityEntered == "") { quantityEntered = 0; document.getElementById("ip1_" + val).value = 0; }
        if(quantityEntered > quantityAvailable) { quantityEntered = quantityAvailable; document.getElementById("ip1_" + val).value = quantityAvailable; }
        if(quantityEntered < 0) { quantityEntered = 0; document.getElementById("ip1_" + val).value = 0; }
        document.getElementById("ip2_" + val).value = Math.round(Math.trunc(quantityEntered) * price * 100) / 100;
    }
    function cartBtn2() {
        document.getElementById("form1").action = "/cartPage";
    }
</script>
</body>
</html>
