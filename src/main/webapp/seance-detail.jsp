<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: user3
  Date: 5/23/2018
  Time: 5:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<style>
    .seance-box {
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
</style>
<head>
    <title>Seance Detail Page</title>
</head>
<body>

<jsp:include page="fragments/navigation-bar.jsp" />

<form name="orderForm" action="/seance-detail" method='POST'>
    <div class="seance-box">
        <td>${seance.getDate()}</td>
        <td>${seance.getMovie().getTitle()}</td>
        <td>${seance.getMovie().getPrice()}</td>
        <c:forEach items="${seance.getRoom().getSeats()}" var="seat">
            <div>
                <td>
                    <input type=radio value="${seat.getSeat()}"
                           onclick="document.getElementById().checked = false"/></td>
                <td>${seat.getSeat()}</td>
                <td>${seat.getSeatType()}</td>
            </div>
        </c:forEach>

        <button type="submit">Order</button>
    </div>
</form>


</body>
</html>
