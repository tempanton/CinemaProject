<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<head>
    <title>Cinema Project</title>
    <style>
        body {
            font-family: 'Open Sans Condensed', sans-serif;
            background: rgb(255, 255, 255) no-repeat;
        }

        .sidebar {
            padding: 10px;
            height: 100%;
            position: fixed;
            background-color: rgb(230,90,20);
            width: 250px;
            top: 0;
            left: 0;
            -webkit-text-fill-color: ghostwhite;
            font-size: 50px;

        }

        .sidenav {
            height: 100%;
            width: 250px;
            position: fixed;
            z-index: 1;
            top: 0;
            left: 0;
            padding-top: 180px;
            padding-left: 30px;
            -webkit-text-fill-color: white;
            font-size: 20px;
        }

        .sidenav a {
            padding: 8px 8px 8px 32px;
            -webkit-text-fill-color: ghostwhite;
            text-decoration: none;
            font-size: 25px;
        }

        .sidenav:hover .row:hover a {
            -webkit-text-fill-color: rgb(230,90,20);
        }

        .sidenav:hover {
            -webkit-text-fill-color: ghostwhite;
        }

        .column {
            width: 96%;
            height: 60px;
            -webkit-text-fill-color: rgb(230,90,20);
            left: 0;
        }

        .row:hover {
            z-index: 1;
            left: 0;
            background-color: ghostwhite;
            -webkit-text-fill-color: rgb(230,90,20);
            width: 96%;
        }
    </style>

</head>
<div class="sidebar">
    Cinema


    <br><br><br>
    <div class="sidenav">
        <div class="row">
            <div class="column">
                <a href="#">Order</a>
            </div>
        </div>
        <div class="row">
            <div class="column">
                <a href="#">Account</a>
            </div>
        </div>
        <div class="row">
            <div class="column">
                <a href="#">Logout</a>
            </div>
        </div>
    </div>

</div>