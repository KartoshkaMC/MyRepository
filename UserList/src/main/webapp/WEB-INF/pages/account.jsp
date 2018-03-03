<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Account</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

</head>
<body style="background: #f6f6f6">
<div class="container pt-3">
    <div class="row">
        <div class="col-sm">
            <h3 class="text-center">Available cars</h3>
            <table border="1px" class="table table-bordered table-hover table-sm ">
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

                            <a  class="btn btn-dark"
                                href="<c:url value="signin/add/${acar.id}"/>">

                                Add
                            </a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <div class="col-sm">
            <h3 class="text-center">Your cars</h3>
            <table border="1px" class="table table-bordered table-hover table-sm ">
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
                            <a class="btn btn-dark"
                               href="<c:url value="signin/del/${car.id}"/>">
                                Del
                            </a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <div class="col-sm">
            <a href="${link}" class="btn btn-primary">Users</a>
        </div>
    </div>
</div>
</body>
</html>
