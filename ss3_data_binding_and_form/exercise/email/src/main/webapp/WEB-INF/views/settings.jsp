<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>

  <h1>Settings</h1>

  <form:form action="/update" method="get" modelAttribute="email">

    <div>
      <form:label for="languages" path="languages"><b>Languages:</b></form:label>
      <form:select id="languages" path="languages" items="${languages}"></form:select>
    </div>
    <br>

    <div>
      <form:label for="pageSize" path="pageSize"><b>Page Size:</b></form:label>
      Show <form:select id="pageSize" path="pageSize" items="${sizePage}"></form:select> emails per page
    </div>
    <br>

    <div>
      <form:label for="spamsFilter" path="spamsFilter"><b>Spams Filter:</b></form:label>
      <form:checkbox id="spamsFilter" path="spamsFilter"></form:checkbox> Enable spams filter
    </div>
    <br>

    <div>
      <form:label for="signature" path="signature"><b>Signature:</b></form:label>
      <form:textarea id="signature" path="signature"></form:textarea>
    </div>
    <br>

    <div>
      <button type="submit">Update</button>
    </div>
  </form:form>
  </body>
</html>
