<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>

  <h1>Sandwich Condiments</h1>

  <form action="/saveCondiments" method="post">

    <div>
      <c:forEach var="condiments" items="${condimentsList}">
        <input type="checkbox" name="condiments", value="${condiments}"> ${condiments};
      </c:forEach>
    </div><hr>

    <div><button type="submit">Save</button></div>

  </form>

  </body>
</html>
