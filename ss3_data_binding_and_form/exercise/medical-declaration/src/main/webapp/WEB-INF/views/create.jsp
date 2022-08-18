<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
  </head>
  <body>

  <div class="container bg-light shadow-lg mt-5 mb-5">
    <div class="row">
      <div class="col-lg-12 text-center fw-bold">
        <h3>TỜ KHAI Y TẾ</h3>
      </div>
    </div>

    <div class="row">
      <div class="col-lg-12 text-center fw-bold">
        <h6>ĐÂY LÀ TÀI LIỆU QUAN TRỌNG, THÔNG TIN CỦA ANH/CHỊ SẼ GIÚP CƠ QUAN Y TẾ LIÊN LẠC KHI CẦN THIẾT
          ĐỀ PHÒNG DỊCH BỆNH TRUYỀN NHIỄM</h6>
      </div>
    </div>

    <div class="row">
      <div class="col-lg-12 text-center text-danger fw-bold">
        <h6>khuyến cáo:  khai báo thông tin sai vi phạm pháp luật Việt Nam có thể sử lý hình sự</h6>
      </div>
    </div>

    <div class="row ">
      <div class="col-lg-12">

        <form:form action="/create" method="post" modelAttribute="MedicalDeclaration">

          <div class="row">
            <div class="col-lg-12">
              <div class="mb-3">
                <label for="name" class="form-label fw-bold">Họ Tên (ghi chữ IN HOA)</label>
                <form:input type="text" class="form-control" id="name" aria-describedby="emailHelp" path="name"/>
              </div>
            </div>
          </div>

          <div class="row mb-3">
            <div class="col-lg-4">
              <label for="yearOfBirth" class="form-label fw-bold">Năm sinh</label>
              <form:select class="form-control" id="yearOfBirth" aria-describedby="emailHelp" path="yearOfBirth" items="${yearOfBirthList}"/>
            </div>

            <div class="col-lg-4">
              <label for="yearOfBirth" class="form-label fw-bold">Giới tính</label>
              <form:select class="form-control" id="yearOfBirth" aria-describedby="emailHelp" path="gender" items="${genderList}" />
            </div>

            <div class="col-lg-4">
              <label for="nationality" class="form-label fw-bold">Quốc tịch</label>
              <form:input class="form-control" id="nationality" aria-describedby="emailHelp" path="nationality" />
            </div>
          </div>

          <div class="row">
            <div class="col-lg-12">
              <div class="mb-3">
                <label for="idCard" class="form-label fw-bold">Số hộ chiếu hoặc số CMND hoặc giấy thông hành hợp pháp khác</label>
                <form:input class="form-control" id="idCard" aria-describedby="emailHelp" path="idCard"/>
              </div>
            </div>
          </div>

          <div class="row">
            <div class="col-lg-12 mb-3">
              <div>
                <label for="vehicles" class="form-label fw-bold">Thông tin đi lại</label>
              </div>
              <div>
                <form:radiobuttons class="form-check-input ms-3 me-1" id="vehicles" aria-describedby="emailHelp" path="vehicles" items="${vehiclesList}"/>
              </div>
            </div>
          </div>

          <div class="row mb-3">
            <div class="col-lg-6">
              <label for="licensePlates" class="form-label fw-bold">Số hiệu phương tiện</label>
              <form:input class="form-control" id="licensePlates" aria-describedby="emailHelp" path="licensePlates"/>
            </div>
            <div class="col-lg-6">
              <label for="seats" class="form-label fw-bold">Số ghế</label>
              <form:input class="form-control" id="seats" aria-describedby="emailHelp" path="seats"/>
            </div>
          </div>

          <div class="row">
            <div class="col-lg-6">
              <label for="startDate" class="form-label fw-bold">Ngày khởi hành</label>

            </div>
            <div class="col-lg-6">
              <label for="endDate" class="form-label fw-bold">Ngày kết thúc</label>
            </div>
          </div>

          <div class="row mb-3">
            <div class="col-lg-2">
              <form:select class="form-control" id="startDate" aria-describedby="emailHelp" path="startDays" items="${dayList}"/>
            </div>
            <div class="col-lg-2">
              <form:select class="form-control" id="startDate" aria-describedby="emailHelp" path="startMonths" items="${monthList}" />
            </div>
            <div class="col-lg-2">
              <form:select class="form-control" id="startDate" aria-describedby="emailHelp" path="startYears" items="${yearList}" />
            </div>
            <div class="col-lg-2">
              <form:select class="form-control" id="endDate" aria-describedby="emailHelp" path="endDays" items="${dayList}" />
            </div>
            <div class="col-lg-2">
              <form:select class="form-control" id="endDate" aria-describedby="emailHelp" path="endMonths" items="${monthList}" />
            </div>
            <div class="col-lg-2">
              <form:select class="form-control" id="endDate" aria-describedby="emailHelp" path="endYears" items="${yearList}" />
            </div>
          </div>

          <div class="row">
            <div class="col-lg-12">
              <div class="mb-3">
                <label for="thePastFourteenDays" class="form-label fw-bold">Trong vòng 14 ngày qua, Anh/Chị có đến tỉnh/thành phố nào ?</label>
                <form:textarea class="form-control" id="thePastFourteenDays" aria-describedby="emailHelp" path="thePastFourteenDays"/>
              </div>
            </div>
          </div>

          <button type="submit" class="btn btn-primary">Thêm mới</button>
        </form:form>
      </div>
    </div>
  </div>

  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
  </body>
</html>
