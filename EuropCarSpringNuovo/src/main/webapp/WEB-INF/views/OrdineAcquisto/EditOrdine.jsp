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
	href="http://localhost:8086/OrdineAcquisto/Cerca" role="button">Annulla</a>
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
			
			<div class="form-group">
				<label>Fornitore</label>
				<form:select path="ofornitore" cssClass="form-control" id="ragionesociale">
					<form:option value="0">Seleziona un fornitore</form:option>
					<form:options items="${elencoFornitori}" itemValue="idfornitore" itemLabel="ragionesociale" />
				</form:select>
				<form:errors path="ofornitore" cssClass="error"/>
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
						<th scope="row">Quantit�</th>
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
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			
</body>
</html>