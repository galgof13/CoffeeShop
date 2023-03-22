<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<body>
<jsp:include page="_menu.jsp"/>

<h2>Order</h2>
<br>

<h3>Shopping cart</h3>
<table>
<tr>
    <th>Name</th>
    <th>Quantity</th>
</tr>
<c:forEach var="coffee" items="${myCart.cartLines}">

    <tr>
        <td>${coffee.coffeeInfo.name}</td>
        <td>${coffee.quantity}</td>
    </tr>

</c:forEach>
</table>
<br>

<h3>Client information</h3>

<br>
<form:form action="saveTaskClient" modelAttribute="myCart">

    Name<form:input path="clientInfo.firstName"/>
    <br><br>
    Surname<form:input path="clientInfo.secondName"/>
    <br><br>
    Address<form:input path="clientInfo.address"/>
    <br><br>
    Phone number<form:input path="clientInfo.phoneNumber"/>
    <br><br>    <br><br><br>


    <H2>when to deliver?</H2>
    <br>
    from 7 am to 11 am<form:radiobutton path="clientInfo.deliveryTime" value="from 7 am to 11 am"/>
    <br><br>
    from 11 am to 2 pm<form:radiobutton path="clientInfo.deliveryTime" value="from 11 am to 2 pm"/>
    <br><br>
    from 2 pm to 7 pm<form:radiobutton path="clientInfo.deliveryTime" value="from 2 pm to 7 pm"/>
    <br><br>
    <input type="submit" value="OK">

</form:form>


<h1>Amount total = ${myCart.amountTotal}</h1>

</body>
</html>