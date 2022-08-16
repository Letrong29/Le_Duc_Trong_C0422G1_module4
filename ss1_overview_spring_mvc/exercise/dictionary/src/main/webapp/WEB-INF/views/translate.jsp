<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>Google Translate</h1>

<form action="/trans" method="post">

    <label for="english">Tiếng Anh</label>
    <input type="text" id="english" name="keySearch" value="${keySearch}">

    <label for="vietnames">Tiếng Việt</label>
    <input type="text" id="vietnames" name="vietnames" value="${result}">

    <button type="submit">Dịch</button>

</form>

</body>
</html>
