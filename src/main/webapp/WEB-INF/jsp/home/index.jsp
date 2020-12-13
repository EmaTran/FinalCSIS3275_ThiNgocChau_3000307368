<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:layoutpage>
    <jsp:attribute name="title">Index</jsp:attribute>

    <jsp:body>
        <div class="container mt-5">

            <div class="card">
                <div class="card-header bg-white font-weight-bold">
                    <div class="d-flex justify-content-between">
                        Student Records
                        <a href="home/create" class="btn btn-sm btn-success">Insert</a>
                    </div>
                </div>

                <div class="card-body">

                    <table class="table table-hover table-responsive-md">
                        <thead>
                        <tr>
                            <th scope="col">Student ID</th>
                            <th scope="col">Student Name</th>
                            <th scope="col">GPA</th>
                            <th scope="col"></th>
                        </tr>
                        </thead>
                        <tbody>

                        <c:forEach var="record" items="${records}">
                            <tr id="${record.studentNumber}">
                                <td>${record.studentNumber}</td>
                                <td>${record.studentName}</td>
                                <td>${record.gpa}</td>
                                <td class="d-flex justify-content-between align-items-center">
                                    <span>
                                        <button onclick="ajaxpost(${record.studentNumber})"
                                                class="btn btn-danger">Delete</button>
                                        <a href="home/update?studentNumber=${record.studentNumber}"
                                           class="btn btn-primary">Edit</a>
                                    </span>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>

        <script>
            function ajaxpost(id) {
                $.ajax({
                    type: "post",
                    url: "${pageContext.request.contextPath}/delete",
                    data: {"studentNumber": id},
                    success: function (res) {
                        res = JSON.parse(res);
                        if (res.msg === "OK") {
                            $('#' + id).remove();
                        } else
                            alert("An error occurred during the operation.");
                    },
                    error: function (err) {
                        alert("Error! :\n" + err.message);
                    }
                });
            }
        </script>

    </jsp:body>

</t:layoutpage>