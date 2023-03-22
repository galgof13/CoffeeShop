<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<body>
<jsp:include page="_menu.jsp"/>

<h2>All Coffee</h2>
<br>
<table>

    <tr>
        <th>Name</th>
        <th>price for 200g</th>
    </tr>

    <c:forEach var="coffee" items="${allCoffee}">

        <tr>
            <td><a href = "${coffee.id}">${coffee.name}</a></td>
            <td>${coffee.price}</td>
        </tr>
    </c:forEach>


</table>
<input type="button" value="Order"
       onclick="window.location.href = 'order'"/>

</body>
</html>
