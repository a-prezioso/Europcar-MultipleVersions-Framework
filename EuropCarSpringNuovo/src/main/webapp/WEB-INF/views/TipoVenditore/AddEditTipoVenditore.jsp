<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Edit Tipo Venditore</title>
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
	href="http://localhost:8086/Venditore/AddVenditore" role="button">Indietro</a>
<body>
	<div class="container">
		<spring:url value="/TipoVenditore/SaveTipoVenditore/" var="saveURL" />
		<h2>Add Edit TipoVenditore</h2>
		<form:form modelAttribute="oggettoTipoVenditore" method="post" action="${saveURL}" cssClass="form">
			<form:hidden path="idtipovenditore" />
			<div class="form-group">
				<label>Tipo Venditore</label>
				<form:input path="tipovenditore" cssClass="form-control" id="tipovenditore" />
				<form:errors path="tipovenditore" cssClass="error" />
			</div>
			<button type="submit" class="btn btn-primary">Salva</button>
		</form:form>
	</div>
</body>
</html>