<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<style>
    body {
        font-family: 'Open Sans Condensed', sans-serif;
        padding: 10px;
        margin: 0 auto;
        background: rgb(255, 255, 255) no-repeat;
    }

    .header {
        position: relative;
        background-color: rgb(230,90,20);
        -webkit-text-fill-color: ghostwhite;
        font-size: 50px;
        text-align: center;
        margin: auto;
        padding: 60px 10px 10px 10px;
        width: 500px;
        height: 100px;
    }

    .authentication-text {
        text-align: right;
        font-size: 10px;
        margin-right: 125px;
    }

    .container {
        background: rgba(250,250,250,0.7);
        -webkit-text-fill-color: black;
        margin: auto;
        padding: 60px 10px 10px 10px;
        width: 500px;
        height: 400px;
        text-align: center;
        border-radius: 4px;
    }


    input[type=text],
    input[type=password] {
        width: 275px;
        height: 45px;
        font-size: 18px;
        background-color:  rgb(255, 255, 255);
        padding-left: 20px;
    }

    input[type="text"]::placeholder,
    input[type="password"]::placeholder {
        -webkit-text-fill-color: rgb(200,200,200);
    }

    .btn-submit {
        padding: 10px 15px;
        color: rgb(230,90,20);
        background-color: rgb(230,90,20);
        -webkit-text-fill-color: ghostwhite;
        border: none;
    }

    button:active {
        outline: none;
        border: none;
    }

    button:focus {
        outline: 0;
    }
    .error {
        font-size: 12px;
        -webkit-text-fill-color: red;
    }
</style>
<head>
    <title>Login Page</title>
</head>

<body onload="document.loginForm.login.focus();">

    <div class="header">
        Cinema
        <div class="authentication-text">
            Authentication
        </div>
    </div>

    <div class="container">
        <c:if test="${not empty error}">
            <div class="error">${error}</div>
            <br>
        </c:if>

        <form name="loginForm" action="/login" method='POST'>

            <div>
                <input type="text" name="login" required placeholder="Login"/>
            </div>
            <br>
            <div>
                <input type="password" name="password" placeholder="Password"/>
            </div>
            <br>
            <div>
                <input name="submit" type="submit" class="btn-submit" value="submit" />
            </div>

            <input type="hidden" name="${_csrf.parameterName}"
                   value="${_csrf.token}" />

        </form>
        <!--
                <form name="loginForm" action="/login" method='post'>
                    <div>
                        <input type="text" name="login" required placeholder="Login"/>
                    </div>
                    <br>
                    <div>
                        <input type="password" name="password" placeholder="Password"/>
                    </div>
                    <br>

                    <div>
                        <button type="submit" class="btn-submit">Submit</button>
                    </div>


                </form>
                -->
    </div>

</body>
</html>