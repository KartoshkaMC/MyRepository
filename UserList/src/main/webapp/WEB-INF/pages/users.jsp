<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <title>User manager</title>
</head>
<body style="background: #f6f6f6">
    <div class="container-fluid">
        <h2>User manager</h2>
        <table border="1px" class="table table-bordered table-hover table-sm ">
            <thead>
            <td>
                Id
            </td>
            <td>
                Name
            </td>
            <td>
                Surname
            </td>
            <td>
                Password
            </td>
            <td>
                Description
            </td>
            <td>
                Delete
            </td>
            </thead>

            <c:forEach var="user" items="${users}">
                <tr>
                    <td>
                            ${user.id}
                    </td>
                    <td>
                            ${user.name}
                    </td>
                    <td>
                            ${user.surname}
                    </td>
                    <td>
                            ${user.password}
                    </td>

                    <td>
                            ${user.description}
                    </td>
                    <td>
                        <a  class="btn btn-dark"
                            href="<c:url value="users/del/${user.id}"/>">
                            Delete
                        </a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>