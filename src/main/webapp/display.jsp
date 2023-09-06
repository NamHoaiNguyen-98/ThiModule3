<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 8/26/2023
  Time: 3:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Trang chủ</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

</head>
<body>
<div class="container">
    <div class="body">
        <div class="container-fluid">
            <form action="students?action=search" method="post">
                <div class="row">
                    <div class="col-md-4">
                        <input class="form-control mr-sm-2" name="search" value="${search}" type="search"
                               placeholder="Search" aria-label="Search">
                    </div>
                    <div class="col-md-3">
                        <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                    </div>
                </div>
            </form>
            <a class="btn btn-info" href="students?action=create">Create</a>
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>STT</th>
                    <th>Name</th>
                    <th>Date of Birth</th>
                    <th>Email</th>
                    <th>Address</th>
                    <th style="width: 15%" colspan="2">Action</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${students}" var="s" varStatus="index">

                    <tr>
                        <div style="text-align: center">
                            <td>${index.count}</td>
                            <td><c:out value="${s.name}"/></td>
                            <td><c:out value="${s.dob}"/></td>
                            <td><c:out value="${s.email}"/></td>
                            <td><c:out value="${s.address}"/></td>
                            <td><c:out value="${s.classroom.nameClassroom}"/></td>
                            <td><a class="btn btn-warning" href="students?action=update&&idStudent=${s.getIdStudent()}">Update</a>
                            </td>
                            <td><a class="btn btn-danger" href="students?action=delete&&idStudent=${s.getIdStudent()}">Delete</a></td>
                        </div>
                    </tr>

                </c:forEach>
                </tbody>
            </table>

        </div>

    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
        integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
        integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
        crossorigin="anonymous"></script>
<script>
    function deleteProduct(id) {
        if (confirm("Are you sure?")) {
            window.location.href = "products?action=delete&&id=" + id
        }
    }
</script>
</body>
</html>
