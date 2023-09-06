<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Update</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
            integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
            integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
            crossorigin="anonymous"></script>


</head>
<body>
<div class="container">
    <div class="container mt-5" style="margin-left: 320px">
        <form class="row g-3" action="students?action=update&&idStudent=${student.getIdStudent()}" method="post">
            <div class="row">
                <div class="col-md-6">
                    <label class="form-label">Name</label>
                    <input type="text" class="form-control" name="name" >
                </div>
            </div>
            <div class="row">
                <div class="col-md-6">
                    <label class="form-label">Email address</label>
                    <input type="text" class="form-control" name="email" >
                </div>
            </div>
            <div class="row">
                <div class="col-md-6">
                    <label class="form-label">Date of Birth</label>
                    <input type="date" class="form-control" name="dob" >
                </div>
            </div>
            <div class="row">
                <div class="col-md-6">
                    <label class="form-label">Address</label>
                    <input type="text" class="form-control" name="address" placeholder="Enter address">
                </div>
            </div>
            <div class="row">
                <div class="col-md-6">
                    <label class="form-label">Phone Number</label>
                    <input type="text" class="form-control" name="phoneNumber" placeholder="Enter phone number">
                </div>
            </div>
            <div class="row">
                <div class="col-md-6">
                    <label class="form-label">Class room</label>
                    <select name="idClassroom" class="form-select" aria-label="Default select example">
                        <c:forEach items="${classrooms}" var="c">
                            <option value="<c:out value="${c.idClassroom}"/>">
                                <c:out value="${c.nameClassroom}"/>
                            </option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div>
                <button class="btn btn-info" type="submit">Update</button>
            </div>
        </form>
    </div>
</div>
</body>

</html>

