<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<body>
<jsp:include page="_menu.jsp"/>

<h2>${coffee.name}</h2>
<br>
<table>

    <tr>
        <th>Name</th>
        <th>evaluation by SCA</th>
        <th>description</th>
        <th>price per 200g</th>
    </tr>
    <c:url var="placeAnOrder" value="add-to-order">

        <c:param name="coffeeId" value="${coffee.id}"/>

    </c:url>

    <c:url var="EditCoffee" value="/admin/product">

        <c:param name="id" value="${coffee.id}"/>

    </c:url>
    <tr>
        <td>${coffee.name}</td>
        <td>${coffee.evaluationBySCA}</td>
        <td>${coffee.description}</td>
        <td>${coffee.price}</td>
        <td>
            <input type="button" value="Place an order"
                   onclick="window.location.href = '${placeAnOrder}'"/>
        </td>
        <td>
            <input type="button" value="Edit Coffee"
                   onclick="window.location.href = '${EditCoffee}'"/>
        </td>
    </tr>


</table>

</body>
</html>
