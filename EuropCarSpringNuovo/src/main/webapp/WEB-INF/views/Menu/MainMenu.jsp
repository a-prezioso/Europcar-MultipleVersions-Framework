<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Main Menu</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</head>
	<spring:url value="/SelezioneAnno/ListaAnni/" var="addURL" />
		<a href="${addURL}" role="button" class="btn btn-primary">Indietro</a>
<body>
<div class="container" align="center">
<br><br><br><br><br>
		<h3>EuropCar</h3>
		<br>
		<div class="btn-group-vertical">
			<a class="btn btn-primary" href="/Archivio/Lista" role="button">Archivio</a> 
		  	<a class="btn btn-secondary" href="/Impostazioni/Lista" role="button">Impostazioni</a> 
			<a class="btn btn-danger" href="/Venditore/ListaVenditori" role="button">Gestione Venditore</a>
		<c:if test="${oggettoUtentePermanente.isAdmin() == true}">		
			<a class="btn btn-dark" href="/Utente/ListaUtenti" role="button">Gestione Utenti</a> 
		</c:if> 	
		<a class="btn btn-success" href="/Preventivo/Cerca" role="button">Gestione Preventivi</a> 
		<a class="btn btn-info" href="/Budget/Lista" role="button">Budget</a> 
		<a class="btn btn-warning" href="/FatturaPassiva/Menu" role="button">Gestione Fatture</a> 
		<a class="btn btn-primary" href="/ImportaFatture/Importa" role="button">Importa Fatture</a> 
		<a class="btn btn-secondary" href="/OrdineAcquisto/Menu" role="button">Gestione Ordini D'acquisto</a>
		<a class="btn btn-secondary" href="/Previsionale/Cerca" role="button">Previsionale</a>
		</div>
	</div>

</body>
</html>