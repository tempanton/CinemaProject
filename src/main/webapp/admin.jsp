<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<style>

    .container {
        background: rgba(250,250,250,0.7);
        -webkit-text-fill-color: black;
        margin-left: 600px;
        padding: 60px 10px 10px 10px;
        width: 500px;
        height: 400px;
        text-align: center;
        border-radius: 4px;
    }

</style>
<head>
    <title>Admin Page</title>
</head>
<body>


<jsp:include page="fragments/navigation-bar.jsp" />

<div class="container">

        <div>
            <h3>Create Movie</h3>
            <input type="text" id="title" name="Title" required placeholder="Title"/>
            <input type="text" name="Duration" required placeholder="Duration"/>
            <input type="number" name="Price" required placeholder="Price"/>
            <spring:url value="/admin/addMovie" var="add"/>
            <button class="button" onclick="location.href='${add}'">Add Movie</button>
        </div>
        <br>
        <div>
            <h3>Create Room</h3>
            <input type="text" name="Room" placeholder="Room"/>
            <input type="button" class="button" value="Add Room"/>
        </div>
        <div>
            <h3>Create Seance</h3>
        </div>

</div>

</body>
</html>
