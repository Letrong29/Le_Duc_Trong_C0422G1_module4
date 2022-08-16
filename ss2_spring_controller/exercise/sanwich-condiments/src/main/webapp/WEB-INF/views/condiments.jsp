<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Title</title>
    </head>
    <body>

        <h1>Sandwich Condiments</h1>

        <h4>condiments of your</h4>

        <ol>
            <c:forEach var="conduments" items="${yourCondimentList}">
                <li>${conduments}</li>
            </c:forEach>
        </ol><hr>

        <button type="submit" onclick="location.href='/'">
            Back to menu
        </button>

    </body>
</html>
