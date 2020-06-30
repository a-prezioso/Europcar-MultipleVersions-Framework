<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista Preventivi</title>
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

		if (confirm("Eliminare il preventivo selezionata?")) {
			return true;
		} else {
			return false;
		}
	}
</script>
</head>
<a class="btn btn-light" href="http://localhost:8086/menu/List"
	role="button">Home</a>
<body>
	<div class="container">
		<spring:url value="/Preventivo/ListaPreventivi/" var="saveURL" />
		<br> <br>
		<h2>Scegli un Fornitore</h2>
		<form:form modelAttribute="oggettoFornitoreSelezione" method="post" action="${saveURL}" cssClass="form">

			<div class="form-group">
				<br> <br> <label>Fornitori</label>
				<form:select path="idfornitore" cssClass="form-control" id="area">
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
			<button type="submit" class="btn btn-primary">Cerca Preventivi</button>
		</form:form>

<br> <br>

		<c:if test="${oggettoFornitorePreventivo.getIdfornitore() != 0}">
			<div class="container">
			
			
				<h2>Lista Preventivi</h2>
				<table class="table table-striped">
					<thead>

						<th scope="row">codice</th>
						<th scope="row">Preventivo</th>
						<th scope="row">Fornitore</th>
						<th></th>
						<th></th>
					</thead>
					<tbody>
						<c:forEach items="${elencoPreventivi}" var="elenco">
							<tr>
								<td>${elenco.codice}</td>
								<td>${elenco.preventivo}</td>
								<td>${elenco.ofornitore.ragionesociale}</td>
								<td><spring:url
										value="/Preventivo/EditPreventivo/${elenco.idpreventivo}"
										var="editURL" /><a href="${editURL}" role="button"
									class="btn btn-primary">Modifica</a></td>
								<td><spring:url
										value="/Preventivo/DeletePreventivo/${elenco.idpreventivo}"
										var="deleteURL" /> <a href="${deleteURL}" role="button"
									class="btn btn-primary" onclick="return deleteConfirm()">Elimina</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>

				<spring:url value="/Preventivo/AddPreventivo/" var="addURL" />
				<a href="${addURL}" role="button" class="btn btn-primary">Nuovo Preventivo</a>
			</div>
		</c:if>

	</div>
	<br><br>
</body>
</html>