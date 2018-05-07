<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration Page</title>
</head>

<body onload="document.userForm.login.focus();">

<div>
    <h3>Register an account</h3>

    <form name="userForm" action="/registration" method="post">

        <div>
            <Label>Login:</Label>
            <input type="text" name="login" required/>
        </div>
        <br>
        <div>
            <Label>Password:</Label>
            <input type="password" name="password"/>
        </div>
        <br>
        <div>
            <button type="submit">Submit</button>
        </div>

    </form>

</div>

</body>
</html>