<%--
  Created by IntelliJ IDEA.
  User: maminspapin
  Date: 11/2/19
  Time: 9:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <c:if test="${empty subscriber.msisdn}">
        <title>Add</title>
    </c:if>
    <c:if test="${!empty subscriber.msisdn}">
        <title>Edit</title>
    </c:if>
</head>
<body>
<c:if test="${empty subscriber.msisdn}">
    <c:url value="/add" var="var"/>
</c:if>
<c:if test="${!empty subscriber.msisdn}">
    <c:url value="/edit" var="var"/>
</c:if>
<form action="${var}" method="POST">
    <c:if test="${!empty subscriber.msisdn}">
        <input type="hidden" name="id" value="${subscriber.id}">
    </c:if>
    <label for="msisdn">msisdn</label>
    <input type="text" name="msisdn" id="msisdn">
    <label for="name">name</label>
    <input type="text" name="name" id="name">
    <label for="lastname">lastname</label>
    <input type="text" name="lastname" id="lastname">
    <label for="balance">balance</label>
    <input type="text" name="balance" id="balance">
    <label for="status">status</label>
    <input type="text" name="status" id="status">
    <c:if test="${empty subscriber.msisdn}">
        <input type="submit" value="Add new subscriber">
    </c:if>
    <c:if test="${!empty subscriber.msisdn}">
        <input type="submit" value="Edit subscriber">
    </c:if>
</form>
</body>
</html>
