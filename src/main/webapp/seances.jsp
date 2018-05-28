
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
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

<jsp:include page="fragments/navigation-bar.jsp" />

<c:forEach items="${seances}" var="s" varStatus="status" step="1" begin="0">

<div class="box${status.index % 3 + 1}" >
        <div>/${s.getDate()}</div>
        <div>
                <td>${s.getMovie().getTitle()}</td>
                <td>${s.getDate()}</td>
                <td>${s.getMovie().getPrice()}</td>
        </div>
        <spring:url value="/seances/${s.getId()}" var="seance" />
        <button onclick="location.href='${seance}'">Order</button>

</div>
</c:forEach>
</html>

