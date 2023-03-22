<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Order Detail</title>
</head>
<body>
<jsp:include page="_menu.jsp"/>

<h2>Order Detail</h2>
<br>

Create Date:  ${task.createDate}
<br>
Delivery Time: ${task.deliveryTime}
<br>
Address:  ${task.address}
<br>
Firstname:  ${task.firstName}
<br>
Second name:  ${task.secondName}
<br>
Phone Number:  ${task.phoneNumber}
<br>
<br>

<table>
    <tr>
        <th>Coffee Name</th>
        <th>Coffee Price</th>
        <th>Quantity</th>
        <th>Amount</th>
    </tr>
    <c:forEach var="detail" items="${details}">

        <tr>
            <td>${detail.coffeeName}</td>
            <td>${detail.coffeePrice}</td>
            <td>${detail.quantity}</td>
            <td>${detail.amount}</td>
        </tr>

    </c:forEach>
</table>
<br>
Amount ${task.amount}

</body>
</html>
