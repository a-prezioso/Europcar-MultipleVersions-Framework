<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gestione Fattura Passiva</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
	<script type="text/javascript">
	function deleteConfirm() {

		if (confirm("Eliminare la fattura selezionata?")) {
			return true;
		} else {
			return false;
		}
	}
</script>
</head>
<a class="btn btn-light" href="http://localhost:8086/menu/List"	role="button">Home</a>
<body>
	<div class="container">
		<spring:url value="/FatturaPassiva/ListaFatture/" var="saveURL" />
		<br> <br>
		<h2>Scegli un Fornitore</h2>
		<form:form modelAttribute="oggettoFornitoreFattura" method="post" action="${saveURL}" cssClass="form">

			<div class="form-group">
				<br> <br> <label>Fornitori</label>
				<form:select path="idfornitore" cssClass="form-control" id="partitaiva">
					<br>
					<br>
					<form:option value="0">Seleziona un Fornitore:</form:option>
					<form:options items="${elencoFornitori}" itemValue="idfornitore"
						itemLabel="ragionesociale" />
				</form:select>
				<br>
				<c:if test="${not empty message}">
					<c:out value="${message}" />
				</c:if>
			</div>
			<form:hidden path="ragionesociale" />
			<form:hidden path="indirizzo" />
			<form:hidden path="citta" />
			<form:hidden path="cap" />
			<form:hidden path="provincia" />
			<form:hidden path="partitaiva" />
			<button type="submit" class="btn btn-primary">Cerca Fatture</button>
		</form:form><br><br>
		
		<c:if test="${oggettoFornitoreFattura.getIdfornitore() != 0}">
		<c:if test="${elencoFatture.size() == 0}">
				<table class="table table-striped">
				<thead>
					<th scope="row">Non ci sono Fatture</th>
				</thead>
			</table>
			<spring:url value="/FatturaPassiva/AddFattura/" var="addURL" />
				<a href="${addURL}" role="button" class="btn btn-primary">Nuova Fattura</a>
				</c:if>
				<c:if test="${elencoFatture.size() != 0 }">
			<div class="container">
			
			
				<h2>Lista Fatture</h2>
				<table class="table table-striped">
					<thead>

						<th scope="row">data</th>
						<th scope="row">numero</th>
						<th scope="row">descrizione</th>
						<th></th>
						<th></th>
					</thead>
					<tbody>
						<c:forEach items="${elencoFatture}" var="elenco">
							<tr>
								<td>${elenco.data.toString().substring(0, 10)}</td>
								<td>${elenco.numero}</td>
								<td>${elenco.descrizione}</td>
								<td><spring:url
										value="/FatturaPassiva/EditFattura/${elenco.idfatturapassiva}"
										var="editURL" /><a href="${editURL}" role="button"
									class="btn btn-primary">Modifica</a></td>
								<td><spring:url
										value="/FatturaPassiva/DeleteFattura/${elenco.idfatturapassiva}"
										var="deleteURL" /> <a href="${deleteURL}" role="button"
									class="btn btn-primary" onclick="return deleteConfirm()">Elimina</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>

				<spring:url value="/FatturaPassiva/AddFattura/" var="addURL" />
				<a href="${addURL}" role="button" class="btn btn-primary">Nuova Fattura</a>
			</div>
		</c:if>
		</c:if>
		
</div>
</body>
</html>