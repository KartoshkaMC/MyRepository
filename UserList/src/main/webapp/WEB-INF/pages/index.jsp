<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign In</title>
</head>
<body>
    <h1>Sign In</h1>

    <form method="post" action="/signin">
        <label for="name">Name:</label><br/>
        <input name="name" type="text" id="name" placeholder="Enter the name"><br/>

        <label for="password">Password:</label><br/>
        <input name="password" type="text" id="password" placeholder="Enter the password"><br/>
        <input type="submit" value="send">
    </form>
    <a href="/signup">Sign Up</a>
</body>
</html>
