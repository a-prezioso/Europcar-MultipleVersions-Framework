<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Password</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</head>
<a class="btn btn-light" href="http://localhost:8086/menu/List"
	role="button">Home</a>
<a class="btn btn-light"
	href="http://localhost:8086/Impostazioni/Lista" role="button">Indietro</a>
<body>
	<div class="container">
		<spring:url value="/Impostazioni/SaveUtente/" var="saveURL" />
		<h2>Edit Password</h2>
		<form:form modelAttribute="oggettoUtente" method="post" action="${saveURL}" cssClass="form">
			<form:hidden path="idutente" />
		<div class="form-group">
				<label>Password</label>
				<form:password path="password" cssClass="form-control" id="password" />
				<form:errors path="password" cssClass="error" />
				
			</div>
			<div class="form-group">
				<label>Password Confirm</label>
				<form:password path="passwordConfirm" cssClass="form-control" id="password" />
				<form:errors path="passwordConfirm" cssClass="error" />
				
			</div>
			<form:hidden path="username"/>
			<form:hidden path="admin"/>
			<form:hidden path="ovenditore"/>
			<button type="submit" class="btn btn-primary">Salva</button>
		</form:form>
		<c:if test="${not empty message}">
		<c:out value="${message}"/>
		</c:if>
	</div>
</body>
</html>