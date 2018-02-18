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
            Del
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
                    <a href="<c:url value="/del/${user.id}"/>">Del</a>
                </td>
            </tr>
        </c:forEach>
    </table>

    <h2>Add user</h2>
    <form method="post" action="users/add/">
        <label for="name">User name:</label>
        <input name="name" type="text" id="name" placeholder="Enter the name"><br/><br/>
        <label for="surname">User surname:</label>
        <input name="surname" type="text" id="surname" placeholder="Enter the surname"><br/><br/>
        <label for="password">User password:</label>
        <input name="password" type="text" id="password" placeholder="Enter the password"><br/><br/>
        <input type="submit" value="send">
    </form>

</body>