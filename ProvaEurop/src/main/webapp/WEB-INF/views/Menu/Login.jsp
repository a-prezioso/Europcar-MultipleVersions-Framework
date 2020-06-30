<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Selezione Login</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<spring:url value="/Login/Utente/" var="saveURL" />
		<br><br>
		<h2>Inserisci username e password</h2>
		<form:form modelAttribute="oggettoUtentePermanente" method="post" action="${saveURL}" cssClass="form">
			
		<div class="form-group">
				<label>Username</label>
				<form:input path="username" cssClass="form-control" id="username" />
				<form:errors path="username" cssClass="error" />
		</div>
		<div class="form-group">
				<label>Password</label>
				<form:password path="password" cssClass="form-control" id="password" />
				<form:errors path="password" cssClass="error" />
		</div>
		<form:hidden path="passwordConfirm"/>
		<form:hidden path="admin"/>
		<form:hidden path="ovenditore"/>
			<button type="submit" class="btn btn-primary">Entra</button>
		</form:form>
		<c:if test="${not empty message}">
		<c:out value="${message}"/>
		</c:if>
	</div>
</body>
</html>