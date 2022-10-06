<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Academy List</title>
<link href="../../webjars/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" />
<script src="../../webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="../../webjars/jquery/3.0.0/js/jquery.min.js"></script>
</head>
<body>
<div class="navbar navbar-inverse">
      <div class="container-fluid">
        <div class="navbar-header">
          <a class="navbar-brand" href="#">WebSiteName</a>
        </div>
        <div class="navbar-header">
          <a class="navbar-brand" href="#">WebSiteName</a>
        </div>
      </div>
    </div>
	<div class="container">
		<table class="table table-striped">
			<tbody>
				<c:forEach items="${academies}" var="academy">
					<tr>
						<td>${academy.code}</td>
						<td>${academy.title}</td>
						<td>${academy.location}</td>
                        <td><spring:url value="/academy/students/show/${academy.code}"
								var="showURL" /> <a class="btn btn-info" href="${showURL}" role="button">
                                                <button style="background-color:blue; border-color:red; color:white">Show All Students</button></a></td>
						<td><spring:url value="/academies/update/${academy.code}"
								var="editURL" /> <a class="btn btn-info" href="${editURL}" role="button">Update</a></td>
						<td><spring:url value="/academies/remove/${academy.code}"
								var="deleteURL" /> <a class="btn btn-danger" href="${deleteURL}" role="button">Delete</a></td>
								<td><spring:url value="/academy/students/add/${academy.code}" var="addStudentURL" />
		<a class="btn btn-success" href="${addStudentURL}" role="button">Add New
			Student</a></td>
							
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<spring:url value="/addStudent" var="addURL" />
		
		<a class="btn btn-success" href="${addURL}" role="button">Add New
			Academy</a>
		
	</div>
</body>
</html>