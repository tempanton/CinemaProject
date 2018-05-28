<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: user3
  Date: 5/15/2018
  Time: 11:13 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<style>

    .box1 {
        background-color: rgb(230,230,230);
        height: 300px;
        width: 250px;
        padding-top: 18px;
        padding-bottom: 18px;
        overflow: hidden;
        border: 1px solid #e5e5e5;
        border-radius: 5px;
        margin-top: 40px;
        margin-left: 500px;
        float: left;
        -webkit-text-fill-color: rgb(60,70,75);
    }

    .box2 {
        background-color: rgb(230,230,230);
        height: 300px;
        width: 250px;
        padding-top: 18px;
        padding-bottom: 18px;
        overflow: hidden;
        border: 1px solid #e5e5e5;
        border-radius: 5px;
        margin-top: 40px;
        float: left;
        margin-left: 100px;
        -webkit-text-fill-color: rgb(60,70,75);
    }
    .box3 {
        margin-left: 100px;
        background-color: rgb(230,230,230);
        height: 300px;
        width: 250px;
        padding-top: 18px;
        padding-bottom: 18px;
        overflow: hidden;
        border: 1px solid #e5e5e5;
        border-radius: 5px;
        margin-top: 40px;
        float: left;
        -webkit-text-fill-color: rgb(60,70,75);
    }


</style>
<head>
    <title>Movie Page</title>
</head>
<body>

<jsp:include page="fragments/navigation-bar.jsp" />



<c:forEach var="movie" varStatus="status" items="${movies}" step="1" begin="0">
    <div class="box${status.index % 3 + 1}">
            <spring:url value="/movies/${movie.getId()}" var="m" />
            <a href="${m}">imgref</a>
            <div>
                <td>Title: </td><td>${movie.getTitle()}</td>
            </div>
            <div>
                <td>Duration: </td><td>${movie.getDuration()}</td>
            </div>
            <div>
                <td>Ticket price: </td><td>${movie.getPrice()}</td>
            </div>
    </div>
</c:forEach>


</body>
</html>
