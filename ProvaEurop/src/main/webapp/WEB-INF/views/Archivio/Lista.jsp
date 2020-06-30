<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Archivio</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</head>
	<a class="btn btn-light" href="http://localhost:8086/menu/List" role="button">Indietro</a> 
<body>
<div class="container" align="center">
<br><br>
		<h3>EuropCar</h3>
		<br>
		<div class="btn-group-vertical">
			<a class="btn btn-primary" href="http://localhost:8086/AliquotaIva/ListaAliquoteIva" role="button">Gestione Aliquote Iva</a> 
		  	<a class="btn btn-secondary" href="http://localhost:8086/SottoCategoria/ListaSottoCategorie" role="button">Gestione SottoCategorie</a> 
		 	<a class="btn btn-danger" href="http://localhost:8086/AreaInvestimento/ListaAreeInvestimento" role="button">Gestione Aree d'investimento</a> 
		 	<a class="btn btn-info" href="http://localhost:8086/Area/ListaAree" role="button">Gestione Aree Geografiche</a> 
			<a class="btn btn-dark" href="http://localhost:8086/Azienda/ListaAziende" role="button">Gestione Aziende</a> 
			<a class="btn btn-success" href="http://localhost:8086/Gruppo/ListaGruppi" role="button">Gestione Gruppi</a> 
			<a class="btn btn-warning" href="http://localhost:8086/Progetto/ListaProgetti" role="button">Gestione Progetti</a> 
			<a class="btn btn-secondary" href="http://localhost:8086/Fornitore/ListaFornitori" role="button">Gestione Fornitori</a> 
			
		</div>
	</div>

</body>
</html>