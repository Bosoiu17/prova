<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="../../webjars/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" />
<script src="../../webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="../../webjars/jquery/3.0.0/js/jquery.min.js"></script>
<meta charset="utf-8">
<title>Worldemy Website</title>
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
    <div style="text-align: center">
        <h1>Admin Login</h1>
        <spring:url value="/academiesList" var="academiesList"/>
        <form:form modelAttribute="email" action="${academiesList}" method="post">
            <label for="email">Email:</label>
            <input name="email" size="30" />
            <br><br>          
            <button class="btn btn-success" type="submit">Login</button>
        
        </form:form>
        <br>
        <spring:url value="/user" var="user"/>
        <form action="${user}" method="get">
        <button class="btn btn-success" type="submit">Sing In</button>
        <%--<p>o </p><a href="user">registrati</a><p> se non hai un account.</p>--%>
    </div>
</body>
</html>