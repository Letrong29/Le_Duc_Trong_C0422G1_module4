<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>

<div class="row">
    <div class="col-lg-12 text-center mb-3">
        <h1>Danh sách tờ khai</h1>
    </div>
</div>

<div class="row">
    <div class="col-lg-12 text-center text-success">
        ${msg}
    </div>
</div>

<table class="table">
    <thead>
    <tr>
        <th scope="col">#</th>
        <th scope="col">Họ Tên</th>
        <th scope="col">Năm sinh</th>
        <th scope="col">Giới tính</th>
        <th scope="col">Quốc tịch</th>
        <th scope="col">Số CMND</th>
        <th scope="col">Ngày khởi hành</th>
        <th scope="col">Ngày kết thúc</th>
        <th scope="col">Những nơi đã đi qua</th>
        <th scope="col">
            <button onclick="location.href='/showFormAdd'" type="button" class="btn btn-primary">Thêm mới</button>
        </th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="medicalDeclaration" items="${medicalDeclarationList}" varStatus="status">
        <tr>
            <th scope="row">${status.count}</th>
            <td>${medicalDeclaration.name}</td>
            <td>${medicalDeclaration.yearOfBirth}</td>
            <td>${medicalDeclaration.gender}</td>
            <td>${medicalDeclaration.nationality}</td>
            <td>${medicalDeclaration.idCard}</td>
            <td>${medicalDeclaration.startDays}/${medicalDeclaration.startMonths}/${medicalDeclaration.startYears}</td>
            <td>${medicalDeclaration.endDays}/${medicalDeclaration.endMonths}/${medicalDeclaration.endYears}</td>
            <td>${medicalDeclaration.thePastFourteenDays}</td>
            <td>
                <button onclick="location.href='/edit/${medicalDeclaration.id}'" type="submit" class="btn btn-primary">
                    Chỉnh sửa
                </button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>
