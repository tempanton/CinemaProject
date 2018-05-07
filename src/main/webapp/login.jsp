<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Login Page</title>
</head>

<body onload="document.loginForm.login.focus();">

<div>

    <h3>Authentication</h3>

    <form name="loginForm" action="/login" method='POST'>

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

        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

    </form>
</div>

</body>
</html>