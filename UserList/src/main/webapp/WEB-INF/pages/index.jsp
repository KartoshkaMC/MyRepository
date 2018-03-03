<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign In</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

</head>
<body style="background: #f6f6f6">

    <div class="container pt-3">
        <h1 class="text-center">Sign In</h1>
        <div class="row">

            <div class="col-lg-4 m-auto">
                <form method="post" action="/signin" class="form-group">
                    <label for="name">Name:</label><br/>
                    <input class="form-control" name="name" type="text" id="name" placeholder="Enter the name"><br/>

                    <label for="password">Password:</label><br/>
                    <input class="form-control" name="password" type="password" id="password" placeholder="Enter the password"><br/>
                    <input type="submit" class="btn btn-primary m-auto" value="Send">
                </form>
                <a href="/signup" class="">Sign Up</a>
                <div style="color: red">
                    ${message}
                </div>
            </div>
        </div>


    </div>

</body>
</html>
