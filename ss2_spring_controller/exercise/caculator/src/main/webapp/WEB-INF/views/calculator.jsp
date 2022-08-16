<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>

    <h1>Calculator</h1>

    <p style="color: red">${message}</p>

    <form action="/count" method="post">

      <input type="number" name="number1" value="${number1}">
      <input type="number" name="number2" value="${number2}"> <br> <br>
      <input type="submit" name="operator" value="Addition(+)">
      <input type="submit" name="operator" value="Subtraction(-)">
      <input type="submit" name="operator" value="Multiplication(X)">
      <input type="submit" name="operator" value="Division(/)">

    </form>

    <div>
      result: ${result};
    </div>

  </body>
</html>
