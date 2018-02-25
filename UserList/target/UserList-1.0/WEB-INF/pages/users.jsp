<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>User manager</title>
</head>

<body>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <h2>User manager</h2>

    <table border="1px">
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
                    <a href="<c:url value="users/del/${user.id}"/>">Del</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>