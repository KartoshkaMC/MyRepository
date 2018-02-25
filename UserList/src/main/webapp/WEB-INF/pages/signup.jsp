<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign Up</title>
</head>
<body>
<h1>Sign Up<h1>
    <h3>Add user</h3>
    <form method="post" action="/signup">
        <label for="name">User name:</label><br/>
        <input name="name" type="text" id="name" placeholder="Enter the name"><br/>

        <label for="surname">User surname:</label><br/>
        <input name="surname" type="text" id="surname" placeholder="Enter the surname"><br/>

        <label for="password">User password:</label><br/>
        <input name="password" type="text" id="password" placeholder="Enter the password"><br/>

        <label for="description">Description:</label><br/>
        <input name="description" type="text" id="description" placeholder="Enter the description"><br/>


        <input type="submit" value="send">
    </form>
    <a href="/">Go Back</a>
    <p>${message}</p>
</body>
</html>
