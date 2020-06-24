<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>EditOrdine Con Dettagli</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</head>
<a class="btn btn-light" href="http://localhost:8086/menu/List" role="button">Home</a>
<a class="btn btn-light"
	href="http://localhost:8086/OrdineAcquisto/AnnullaModifica" role="button">Annulla</a>
<body>
	<div class="container">
	<spring:url value="/OrdineAcquisto/SaveEditOrdine/" var="saveURL" />
		<form:form modelAttribute="oggettoOrdineTemporaneo" method="post" action="${saveURL}" cssClass="form">
		
		<h2>Add Ordine di acquisto</h2>
			<form:hidden path="idordineacquisto" />

			<div class="form-group">
				<label>Data</label>
				<form:input type = "date" path="data" cssClass="form-control" id="data" />
				<form:errors path="data" cssClass="error" />
			</div>
			<div class="form-group">
				<label>Importo</label>
				<form:input path="importo" cssClass="form-control" id="importo" />
				<form:errors path="importo" cssClass="error" />
			</div>
			<div class="form-group">
				<label>Ordine d'acquisto</label>
				<form:input path="ordineacquisto" cssClass="form-control" id="ordineacquisto" />
				<form:errors path="ordineacquisto" cssClass="error" />
			</div>
			
		
			<form:hidden path="dettagli"/>
			<button type="submit" class="btn btn-primary">Salva</button>
		</form:form>
	</div>
	
	<br><br>	
		<div class="container">
			
			
				<h2>Lista Dettagli</h2>
				<table class="table table-striped">
					<thead>

						<th scope="row">Progetto</th>
						<th scope="row">Spesa investimento</th>
						<th scope="row">Importo</th>
						<th scope="row">Quantità</th>
						<th></th>
						<th></th>
					</thead>
					<tbody>
						<c:forEach items="${elencoDettagli}" var="elenco">
							<tr>
								<td>${elenco.oprogetto.progetto}</td>
								<td>${elenco.ospesainvestimento.spesainvestimento}</td>
								<td>${elenco.importo}</td>
								<td>${elenco.quantita}</td>
								<td>
								<spring:url
										value="/OrdineAcquisto/EditDettaglio/${elenco.idordinediacquistodettaglio}"
										var="editURL" /> <a href="${editURL}" role="button"
									class="btn btn-primary">Modifica</a>
								</td>
								<td><spring:url value="/OrdineAcquisto/RimuoviDettagli/${elenco.idordinediacquistodettaglio}/${elenco.identifier}" var="deleteURL" /> 
								<a href="${deleteURL}" role="button" class="btn btn-primary">Rimuovi Dettaglio</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<br>
				
				<br>
				<spring:url value="/OrdineAcquisto/AddDettagliModifica/" var="addURL" /> 
				<a href="${addURL}" role="button" class="btn btn-primary">Aggiungi Dettaglio</a>
				<br>
				
				${messaggio}
			</div>
			
</body>
</html>