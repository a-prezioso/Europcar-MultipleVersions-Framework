<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Edit Venditore</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</head>
<a class="btn btn-light" href="http://localhost:8086/menu/List"
	role="button">Home</a>
<a class="btn btn-light"
	href="http://localhost:8086/Venditore/ListaVenditori" role="button">Indietro</a>
<script type="text/javascript">
	
	function deleteConfirmNuovo() {

		if (confirm("Sicuro di voler creare un'altro tipo di venditore?")) {
			return true;
		} else {
			return false;
		}
}
</script>

<body>
	<div class="container">
		<spring:url value="/Venditore/SaveVenditore/" var="saveURL" />
		<h2>Add Edit Venditore</h2>
		<form:form modelAttribute="oggettoVenditore" method="post"
			action="${saveURL}" cssClass="form">
			<form:hidden path="idvenditore" />
			<div class="form-group">
				<label>Nome</label>
				<form:input path="nome" cssClass="form-control" id="nome" />
				<form:errors path="nome" cssClass="error" />
			</div>
			<div class="form-group">
				<label>Cognome</label>
				<form:input path="cognome" cssClass="form-control" id="cognome" />
				<form:errors path="cognome" cssClass="error" />
			</div>
			<div class="form-group">
				<label>Indirizzo</label>
				<form:input path="indirizzo" cssClass="form-control" id="indirizzo" />
				<form:errors path="indirizzo" cssClass="error" />
			</div>
			<div class="form-group">
				<label>Numero di telefono</label>
				<form:input path="numerotelefono" cssClass="form-control"
					id="numerotelefono" />
				<form:errors path="numerotelefono" cssClass="error" />
			</div>
			<div class="form-group">
				<label>Tipo Venditore</label>
				<form:select path="otipovenditore" cssClass="form-control"
					id="venditore">
					<form:option value="0" name="otip">Seleziona una tipologia di venditore:</form:option>
					<form:option value="0" name="otip">NUOVO VENDITORE</form:option>
					<form:options items="${elencoTipiVenditore}"
						itemValue="idtipovenditore" itemLabel="tipovenditore" name="oti"
						id="ot" />
				</form:select>
				<br> <br>
				<button type="submit" class="btn btn-primary" onclick="return deleteConfirmNuovo()">Nuovo Tipo Venditore</button>
				<form:errors path="otipovenditore" cssClass="error" />
			</div>
			<button type="submit" class="btn btn-primary">Salva</button>
		</form:form>
	</div>
</body>
</html>



