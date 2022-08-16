<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1">
    <caption>Customer List</caption>
    <thead>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Email</th>
            <th>Address</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="customer" items="${customerList}">
            <tr>
                <td>${customer.id}</td>
                <td><a href="/customerInfo?id=${customer.id}">${customer.name}</a></td>
                <td>${customer.email}</td>
                <td>${customer.address}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>
</body>
</html>
