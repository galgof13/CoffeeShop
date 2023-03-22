<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Client Detail</title>
</head>
<body>
<jsp:include page="_menu.jsp"/>

<h2>Client Detail</h2>
<br>

Address:  ${client.address}
<br>
Firstname:  ${client.firstName}
<br>
Second name:  ${client.secondName}
<br>
Phone Number:  ${client.phoneNumber}
<br>
<br>

<table>
    <tr>
        <th>createDate</th>
        <th>amount</th>
        <th>deliveryTime</th>
    </tr>
    <c:forEach var="task" items="${allTask}">

        <tr>
            <td>${task.createDate}</td>
            <td>${task.amount}</td>
            <td>${task.deliveryTime}</td>
            <td><input type="button" value="Detail"
                       onclick="window.location.href = '/coffeeshop1/admin/allOrders/${task.id}'"/><td>
        </tr>

    </c:forEach>
</table>

</body>
</html>
