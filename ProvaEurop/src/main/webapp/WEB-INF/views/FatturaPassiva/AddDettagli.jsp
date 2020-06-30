<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Aggiungi Dettagli</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</head>
<a class="btn btn-light" href="http://localhost:8086/FatturaPassiva/Cerca" role="button">Annulla</a>

<body>
	<div class="container">
	<spring:url value="/FatturaPassiva/SaveDettagliListaNuova/" var="saveURL" />
		<form:form modelAttribute="oggettoDettagliTemporanei" method="post" action="${saveURL}" cssClass="form">
		
		<h2>Add Dettagli</h2>
			<form:hidden path="idfatturapassivadettaglio" />
			<div class="form-group">
				<label>Aliquota Iva</label>
				<form:select path="oaliquota" cssClass="form-control" id="aliquota">
					<form:option value="0">Seleziona un'Aliquota</form:option>
					<form:options items="${elencoAliquote}" itemValue="idaliquotaiva" itemLabel="aliquota" />
				</form:select>
							<form:errors path="oaliquota" cssClass="error"/>
			</div>
			<div class="form-group">
				<label>Spesa Investimento</label>
				<form:select path="ospesainvestimento" cssClass="form-control" id="spesainvestimento">
					<form:option value="0">Seleziona una spesa d'investimento</form:option>
					<form:options items="${elencoSpese}" itemValue="idspesainvestimento" itemLabel="spesainvestimento" />
				</form:select>
							<form:errors path="ospesainvestimento" cssClass="error"/>
			</div>
			<div class="form-group">
				<label>Preventivo</label>
				<form:select path="opreventivo" cssClass="form-control" id="preventivo">
					<form:option value="0">Seleziona un preventivo</form:option>
					<form:options items="${elencoPreventivi}" itemValue="idpreventivo" itemLabel="preventivo" />
				</form:select>
							<form:errors path="opreventivo" cssClass="error"/>
			</div>
			<div class="form-group">
				<label>Dettaglio Fattura</label>
				<form:input path="dettagliofattura" cssClass="form-control" id="dettagliofattura" />
				<form:errors path="dettagliofattura" cssClass="error" />
			</div>
			<div class="form-group">
				<label>Importo</label>
				<form:input path="importo" cssClass="form-control" id="importo" />
				<form:errors path="importo" cssClass="error" />
			</div>
			<div class="form-group">
				<label>Importo Pagato</label>
				<form:input path="importoPagato" cssClass="form-control" id="importoPagato" />
				<form:errors path="importoPagato" cssClass="error" />
			</div>
			<form:hidden path="identifier"/>
			
			<button type="submit" class="btn btn-primary">Aggiungi dettaglio</button>
		</form:form>
	</div>
</body>
</html>