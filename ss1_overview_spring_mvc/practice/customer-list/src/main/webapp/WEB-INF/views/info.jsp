<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<table border="1">
    <thead>
        <tr>
            <th colspan="2">Customer Information</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>Id</td>
            <td>${customer.id}</td>
        </tr>
        <tr>
            <td>Name</td>
            <td>${customer.name}</td>
        </tr>
        <tr>
            <td>Email</td>
            <td>${customer.email}</td>
        </tr>
        <tr>
            <td>Address</td>
            <td>${customer.address}</td>
        </tr>
        <tr>
            <th colspan="2">
                <a href="/customer">Back To List</a>
            </th>
        </tr>
    </tbody>
</table>

</body>
</html>
