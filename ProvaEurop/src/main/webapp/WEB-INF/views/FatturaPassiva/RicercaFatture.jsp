<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ricerca</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</head>
<spring:url value="/FatturaPassiva/Menu/" var="addURL" />
		<a href="${addURL}" role="button" class="btn btn-primary">Indietro</a>
<body>
<div class="container" align="center">
<br><br><br><br><br>
		<h3>Ricerca Fatture per:</h3>
		<br>
		<div class="btn-group-vertical">
			<a class="btn btn-primary" href="http://localhost:8086/FatturaPassiva/Fornitore" role="button">Fornitore</a> 
		  	<a class="btn btn-secondary" href="http://localhost:8086/FatturaPassiva/Preventivo" role="button">Preventivo</a> 
			<a class="btn btn-warning" href="http://localhost:8086/FatturaPassiva/SottoCategoria" role="button">SottoCategoria</a>
		</div>
	</div>
</body>
</html>