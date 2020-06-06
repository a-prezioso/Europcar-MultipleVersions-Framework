<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Utente</title>
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
	href="http://localhost:8086/Utente/ListaUtenti" role="button">Indietro</a>
<body>
	<div class="container">
		<spring:url value="/Utente/SaveUtenteAdd/" var="saveURL" />
		<h2>Add Utente</h2>
		<form:form modelAttribute="oggettoUtente" method="post" action="${saveURL}" cssClass="form">
			<form:hidden path="idutente" />
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
			<div class="form-group">
				<label>Password Confirm</label>
				<form:password path="passwordConfirm" cssClass="form-control" id="password" />
				<form:errors path="passwordConfirm" cssClass="error" />
			</div>
			<div class="form-group">
				<label>Admin</label>
				<form:checkbox path="admin" cssClass="form-control" id="admin" />
				<form:errors path="admin" cssClass="error" />
			</div>
			<div class="form-group">
				<label>Venditore</label>
				<form:select path="ovenditore" cssClass="form-control" id="fullName">
					<form:option value="0">Seleziona un venditore:</form:option>
					<form:options items="${elencoVenditori}" itemValue="idvenditore" itemLabel="fullName" />
				</form:select>
			</div>
			<button type="submit" class="btn btn-primary">Salva</button>
		</form:form>
		<c:if test="${not empty message}">
		<c:out value="${message}"/>
		</c:if>
	</div>
</body>
</html>