<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista Utenti</title>
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

		if (confirm("Eliminare l'utente selezionato?")) {
			return true;
		} else {
			return false;
		}
	}
</script>

</head>

<a class="btn btn-light" href="http://localhost:8086/menu/List"
	role="button">Home</a>

</head>
<body>
	<div class="container">
		<h2>Lista Utenti</h2>
		<table class="table table-striped">
			<thead>
		
				<th scope="row">Username</th>
				<th scope="row">Admin</th>
				<th scope="row">Venditore</th>
				<th></th>
				<th></th>
			</thead>
			<tbody>
				<c:forEach items="${elencoUtenti}" var="elenco">
					<tr>
						<td>${elenco.username}</td>
						<td>${elenco.admin}</td>
						<td>${elenco.ovenditore.nome}&nbsp;${elenco.ovenditore.cognome}</td>
						<td><spring:url
								value="/Utente/EditUtente/${elenco.idutente}"
								var="editURL" /><a href="${editURL}" role="button"
							class="btn btn-primary">Modifica</a></td>
						<td><spring:url
								value="/Utente/DeleteUtente/${elenco.idutente}"
								var="deleteURL" /> <a href="${deleteURL}" role="button"
							class="btn btn-primary"
							onclick="return deleteConfirm()">Elimina</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<spring:url value="/Utente/AddUtente/" var="addURL" />
		<a href="${addURL}" role="button" class="btn btn-primary">Nuovo Utente</a>
	</div>
</body>

</html>