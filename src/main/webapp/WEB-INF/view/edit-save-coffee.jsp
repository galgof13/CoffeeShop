<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
    <title>Edit Save Coffee</title>
</head>
<body>
<jsp:include page="_menu.jsp"/>

<form:form action="saveProduct" modelAttribute="coffeeForm">
    <form:hidden path="newCoffee"/>

    <form:hidden path="id"/>
    <br><br>
    Name<form:input path="name"/>

    <br><br>
    Price<form:input path="price"/>
    <br><br>
    Description<form:input path="description"/>
    <br><br>
    EvaluationBySCA<form:input path="evaluationBySCA"/>
    <br><br><br>

    <input type="submit" value="OK">

</form:form>

</body>
</html>
