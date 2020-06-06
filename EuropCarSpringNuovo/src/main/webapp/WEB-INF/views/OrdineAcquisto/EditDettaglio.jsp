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
<a class="btn btn-light" href="http://localhost:8086/OrdineAcquisto/Cerca" role="button">Annulla</a>

<body>
	<div class="container">
	<spring:url value="/OrdineAcquisto/SaveDettagliModificati/" var="saveURL" />
		<form:form modelAttribute="oggettoDettaglioTemporaneo" method="post" action="${saveURL}" cssClass="form">
		
		<h2>Add Dettagli</h2>
			<form:hidden path="idordinediacquistodettaglio" />

			<div class="form-group">
				<label>Spesa Investimento</label>
				<form:select path="ospesainvestimento" cssClass="form-control" id="spesainvestimento">
					<form:option value="0">Seleziona una spesa d'investimento</form:option>
					<form:options items="${elencoSpese}" itemValue="idspesainvestimento" itemLabel="spesainvestimento" />
				</form:select>
							<form:errors path="ospesainvestimento" cssClass="error"/>
			</div>
			<div class="form-group">
				<label>Progetto</label>
				<form:select path="oprogetto" cssClass="form-control" id="progetto">
					<form:option value="0">Seleziona un progetto</form:option>
					<form:options items="${elencoProgetti}" itemValue="idprogetto" itemLabel="progetto" />
				</form:select>
							<form:errors path="oprogetto" cssClass="error"/>
			</div>
			<div class="form-group">
				<label>Importo</label>
				<form:input path="importo" cssClass="form-control" id="importo" />
				<form:errors path="importo" cssClass="error" />
			</div>
			<div class="form-group">
				<label>Quantit�</label>
				<form:input path="quantita" cssClass="form-control" id="quantita" />
				<form:errors path="quantita" cssClass="error" />
			</div>
			
			<form:hidden path="identifier"/>
			
			<button type="submit" class="btn btn-primary">Salva</button>
		</form:form>
	</div>
</body>
</html>