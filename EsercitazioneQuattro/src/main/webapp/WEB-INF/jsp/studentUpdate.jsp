<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Student</title>
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
		<spring:url value="/students/update" var="addURL" />
		<h2>Add Student</h2>
		<!--ModelAttribute=n collegamento tra model e view     -->
		<form:form modelAttribute="studentToUpdate" method="post" action="${addURL}"
			cssClass="form">
						<div class="form-group">
				<label>Id</label>
				<form:input path="id" cssClass="form-control" id="id" readonly="true"/>
			</div>
			<div class="form-group">
				<label>AcadenyCode</label>
				<form:input path="academy" cssClass="form-control" id="academy" readonly="true"/>
			</div>
			<div class="form-group">
				<label>FirstName</label>
				<form:input path="firstName" cssClass="form-control" id="firstName" />
			</div>
			<div class="form-group">
				<label>LastName</label>
				<form:input path="lastName" cssClass="form-control" id="lastName" />
			</div>
			<div class="form-group">
				<label>Age</label>
				<form:input path="age" cssClass="form-control" id="age" />
			</div>
			
			<button type="submit" class="btn btn-success">Update Student</button>
		</form:form>

	</div>
</body>
</html>