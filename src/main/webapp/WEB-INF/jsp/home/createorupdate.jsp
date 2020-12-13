<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean id="now" class="java.util.Date"/>
<fmt:formatDate var="currentDate" value="${now}" pattern="yyyy-MM-dd"/>

<c:choose>
    <c:when test="${empty record}">
        <c:set var="title" value="Insert"/>
    </c:when>
    <c:otherwise>
        <c:set var="title" value="Update"/>
    </c:otherwise>
</c:choose>

<t:layoutpage>
    <jsp:attribute name="title">${title}</jsp:attribute>

    <jsp:body>

        <div class="container mt-5">

            <form id="customerForm">
                <input type="text" id="id" value="${record.studentNumber}" hidden>

                <div class="form-group row">
                    <label class="col-lg-3 col-form-label form-control-label" for="snumber">Student Number</label>
                    <div class="col-lg-9">
                        <input class="form-control" type="text" id="snumber" name="snumber"
                               required value="${record.studentNumber}">
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-lg-3 col-form-label form-control-label" for="sname">Student Name</label>
                    <div class="col-lg-9">
                        <input class="form-control" type="text" id="sname" name="sname"
                               required value="${record.studentName}">
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-lg-3 col-form-label form-control-label" for="gpa">GPA</label>
                    <div class="col-lg-9">
                        <input class="form-control" type="number" id="gpa" name="gpa"
                               required value="${record.gpa}">
                    </div>
                </div>

                <div class="d-flex justify-content-between">
                    <button type="submit" class="btn btn-primary">${title}</button>
                    <a href="${pageContext.request.contextPath}/" class="btn btn-warning">Home Page</a>
                </div>

            </form>

        </div>
        <script>

            $(function () {
                $("#customerForm").submit(function (e) {
                    e.preventDefault(e);

                    $.ajax({
                        type: "post",
                        url: "${pageContext.request.contextPath}/createorupdate",
                        data: {
                            "studentNumber": $('#snumber').val(),
                            "studentName": $('#sname').val(),
                            "gpa": $('#gpa').val()
                        },
                        success: function (res) {
                            res = JSON.parse(res);
                            if (res.msg === "OK") {
                                alert("The operation was performed successfully.");
                                if (res.method === "CREATE")
                                    resetData();
                            } else
                                alert("An error occurred during the operation.");
                        },
                        error: function (err) {
                            alert("Error! :\n" + err.message);
                        }
                    });
                });
            });

            function resetData() {
                $('#snumber').val('');
                $('#sname').val('');
                $('#gpa').val('');
            }
        </script>

    </jsp:body>

</t:layoutpage>