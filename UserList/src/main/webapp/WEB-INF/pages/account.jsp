<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Account</title>
</head>
<body>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<a href="users">Users</a>

<h3>Available cars</h3>
<table border="1px">
    <thead>
        <td>
            All Cars
        </td>
        <td>
            Logo
        </td>
        <td>
            Add a car
        </td>
    </thead>

    <c:forEach var="acar" items="${allcars}">
        <tr>
            <td>
                ${acar.name}
            </td>
            <td>
                <img src="${acar.url}" width="75" height="75">
            </td>
            <td>
                <a href="<c:url value="signin/add/${acar.id}"/>">Add</a>
            </td>
        </tr>
    </c:forEach>
</table>

<h3>Your cars</h3>
<table border="1px">
    <thead>
    <td>
        Car
    </td>
    <td>
        Logo
    </td>
    <td>
        Delete car
    </td>
    </thead>

    <c:forEach var="car" items="${cars}">
        <tr>
            <td>
                ${car.name}
            </td>
            <td>
                <img src="${car.url}" width="75" height="75">
            </td>
            <td>
                <a href="<c:url value="signin/del/${car.id}"/>">Del</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
