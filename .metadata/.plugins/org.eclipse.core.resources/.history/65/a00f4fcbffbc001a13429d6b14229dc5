<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista Previsionali</title>
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

		if (confirm("Eliminare il previsionale selezionata?")) {
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
		<spring:url value="/Previsionale/ListaPrevisionali/" var="saveURL" />
		<br> <br>
		<h2>Scegli un Venditore</h2>
		<form:form modelAttribute="oggettoVenditoreSelezione" method="post"
			action="${saveURL}" cssClass="form">

			<div class="form-group">
				<br> <br> <label>Venditori</label>
				<form:select path="idvenditore" cssClass="form-control" id="area">
					<br>
					<br>
					<form:option value="0">Seleziona un Venditore:</form:option>
					<form:options items="${elencoVenditori}" itemValue="idvenditore"
						itemLabel="fullName" />
				</form:select>
				<br>
				<c:if test="${not empty message}">
					<c:out value="${message}" />
				</c:if>
			</div>
			<form:hidden path="nome" />
			<form:hidden path="cognome" />
			<form:hidden path="indirizzo" />
			<form:hidden path="otipovenditore" />
			<button type="submit" class="btn btn-primary">Cerca
				Previsionali</button>
		</form:form>

		<br> <br>

		<c:if test="${oggettoVenditorePrevisionale.getIdvenditore() != 0}">
			<c:if test="${elencoPrevisionali.size() == 0}">
				<table class="table table-striped">
					<thead>
						<th scope="row">Non ci sono Previsionali per questo Venditore</th>
					</thead>
				</table>
				<spring:url value="/Previsionale/AddPrevisionale/" var="addURL" />
				<a href="${addURL}" role="button" class="btn btn-primary">Nuovo Previsionale</a>
			</c:if>
			<c:if test="${elencoPrevisionali.size() != 0}">
				<div class="container">


					<h2>Lista Previsionali</h2>
					<table class="table table-striped">
						<thead>

							<th scope="row">Anno Di Riferimento</th>
							<th scope="row">Confidenza</th>
							<th scope="row">Data Registrazione</th>
							<th scope="row">Data Visita</th>
							<th scope="row">Potenziale Azienda</th>
							<th scope="row">Potenziale EuropCar</th>
							<th scope="row">Share Ante</th>
							<th scope="row">Share Post</th>
							<th scope="row">Share Avis</th>
							<th scope="row">Share Hertz</th>
							<th scope="row">Share Maggiore</th>
							<th scope="row">Share Sixt</th>
							<th scope="row">Area Geografica</th>
							<th scope="row">Azienda</th>
							<th scope="row">Venditore</th>
							<th scope="row">SottoCategoria</th>
							<th></th>
							<th></th>
						</thead>
						<tbody>
							<c:forEach items="${elencoPrevisionali}" var="elenco">
								<tr>
									<td>${elenco.annodiriferimento}</td>
									<td>${elenco.confidenza}</td>
									<td>${elenco.ofornitore.dataregistrazione}</td>
									<td>${elenco.datavisita}</td>
									<td>${elenco.potenzialeazienda}</td>
									<td>${elenco.potenzialeeuropcar}</td>
									<td>${elenco.shareante}</td>
									<td>${elenco.sharepost}</td>
									<td>${elenco.shareavis}</td>
									<td>${elenco.sharehertz}</td>
									<td>${elenco.sharemaggiore}</td>
									<td>${elenco.sharesixt}</td>
									<td>${elenco.oarea.area}</td>
									<td>${elenco.oazienda.ragionesociale}</td>
									<td>${elenco.ovenditore.fullName}</td>
									<td>${elenco.osottocategoria.sottocategoria}</td>
									<td><spring:url
											value="/Previsionale/EditPrevisionale/${elenco.idprevisionale}"
											var="editURL" /><a href="${editURL}" role="button"
										class="btn btn-primary">Modifica</a></td>
									<td><spring:url
											value="/Previsionale/DeletePrevisionale/${elenco.idprevisionale}"
											var="deleteURL" /> <a href="${deleteURL}" role="button"
										class="btn btn-primary" onclick="return deleteConfirm()">Elimina</a>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>

					<spring:url value="/Previsionale/AddPrevisionale/" var="addURL" />
					<a href="${addURL}" role="button" class="btn btn-primary">Nuovo
						Previsionale</a>
				</div>
			</c:if>
		</c:if>

	</div>
	<br>
	<br>
</body>
</html>