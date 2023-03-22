
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>All Orders</title>
</head>
<body>
<jsp:include page="_menu.jsp"/>

<h2>Orders</h2>
<br><br>

<table>
    <tr>

        <th>createDate</th>
        <th>amount</th>
        <th>deliveryTime</th>
        <th>address</th>
        <th>firstName</th>
        <th>secondName</th>
        <th>phoneNumber</th>

    </tr>
    <c:forEach var="task" items="${allTask}">

        <tr>
            <td>${task.createDate}</td>
            <td>${task.amount}</td>
            <td>${task.deliveryTime}</td>
            <td>${task.address}</td>
            <td>${task.firstName}</td>
            <td>${task.secondName}</td>
            <td>${task.phoneNumber}</td>
            <td><input type="button" value="Detail"
                   onclick="window.location.href = 'allOrders/${task.id}'"/><td>
        </tr>

    </c:forEach>
</table>

</body>
</html>
