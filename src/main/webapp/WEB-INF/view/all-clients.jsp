<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<body>
<jsp:include page="_menu.jsp"/>

<h2>All Clients</h2>
<br>
<table>

    <tr>
        <th>First name</th>
        <th>Second name</th>
        <th>Phone number</th>
    </tr>

    <c:forEach var="client" items="${clients}">

        <tr>
            <td><a href = "clients/${client.id}">${client.firstName}</a></td>
            <td><a href = "clients/${client.id}">${client.secondName}</a></td>
            <td>${client.phoneNumber}</td>
        </tr>
    </c:forEach>

</table>

</body>
</html>
