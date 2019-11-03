<%--
  Created by IntelliJ IDEA.
  User: maminspapin
  Date: 11/2/19
  Time: 9:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>AllSubscribers</title>
</head>
<body>

<h2>My Subscribers</h2>
<table>
    <tr>
        <th>id</th>
        <th>msisdn</th>
        <th>name</th>
        <th>lastname</th>
        <th>balance</th>
        <th>status</th>
        <th>action</th>
    </tr>
    <c:forEach var="subscriber" items="${subscribersList}">
        <tr>
            <td>${subscriber.id}</td>
            <td>${subscriber.msisdn}</td>
            <td>${subscriber.name}</td>
            <td>${subscriber.lastname}</td>
            <td>${subscriber.balance}</td>
            <td>${subscriber.status}</td>
            <td>
                <a href="/maminspapin/edit/${subscriber.id}">edit</a>
                <a href="/maminspapin/delete/${subscriber.id}">delete</a>
            </td>
        </tr>
    </c:forEach>
</table>

<h2>Add</h2>
<c:url value="/add" var="add"/>
<a href="${add}">Add new subscriber</a>
</body>
</html>
