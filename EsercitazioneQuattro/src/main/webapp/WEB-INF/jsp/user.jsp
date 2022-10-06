<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add User</title>
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
		<spring:url value="/users" var="addURL" />
		<h2>Add User</h2>
		<!--ModelAttribute=n collegamento tra model e view     -->
		<form:form modelAttribute="user" method="post" action="${addURL}"
			cssClass="form">
                        <div class="form-group">
				<label>FiscalCode</label>
				<form:input path="fiscalCode" cssClass="form-control" id="fiscalCode" />
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
				<label>Email</label>
				<form:input path="email" cssClass="form-control" id="email" />
			</div>
			
			<button type="submit" class="btn btn-success">Add User</button>
		</form:form>

	</div>
</body>
</html>