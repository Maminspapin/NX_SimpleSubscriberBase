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
    <title>Edit</title>
</head>
<body>
<c:url value="/edit" var="var"/>
<form action="${var}" method="POST">
    <input type="hidden" name="id" value="${subscriber.id}">
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
    <input type="submit" value="Edit subscriber">
</form>
</body>
</html>
