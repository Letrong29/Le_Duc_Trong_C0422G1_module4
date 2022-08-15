<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>Úng dụng chuyển đổi tiền tệ</h1>

<form action="/convert" method="get">

    <label for="usd">Bạn muốn chuyển:</label>
    <input type="text" name="usd" value="${usd}" id="usd">
    <span>USD</span>
    <span style="color: red">${errUSD}</span>

    <p>kết quả: ${result} VND</p>
    <p>Tỷ giá hiện tại: 23.000 VND</p> <br>
    <button type="submit"> Chuyển đổi</button>

</form>
</body>
</html>
