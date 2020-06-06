<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Edit Previsionale</title>
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
	href="http://localhost:8086/Previsionale/Cerca" role="button">Annulla</a>
<body>
	<div class="container">
	<spring:url value="/Previsionale/SavePrevisionale/" var="saveURL" />
		<form:form modelAttribute="oggettoPrevisionale" method="post" action="${saveURL}" cssClass="form">
		
		<h2>Add Edit Previsionale</h2>
			<form:hidden path="idprevisionale" />
			
			<div class="form-group">
				<label>Confidenza</label>
				<form:input path="confidenza" cssClass="form-control" id="confidenza" />
				<form:errors path="confidenza" cssClass="error" />
			</div>
			<div class="form-group">
				<label>Data Registrazione</label>
				<form:input path="dataregistrazione" cssClass="form-control" id="dataregistrazione" />
				<form:errors path="dataregistrazione" cssClass="error" />
			</div>
			<div class="form-group">
				<label>Data Visita</label>
				<form:input path="datavisita" cssClass="form-control" id="datavisita" />
				<form:errors path="datavisita" cssClass="error" />
			</div>
			<div class="form-group">
				<label>Potenziale azienda</label>
				<form:input path="potenzialeazienda" cssClass="form-control" id="potenzialeazienda" />
				<form:errors path="potenzialeazienda" cssClass="error" />
			</div>
			<div class="form-group">
				<label>Potenziale EuropCar</label>
				<form:input path="potenzialeeuropcar" cssClass="form-control" id="potenzialeeuropcar" />
				<form:errors path="potenzialeeuropcar" cssClass="error" />
			</div>
			<div class="form-group">
				<label>Share Ante</label>
				<form:input path="shareante" cssClass="form-control" id="shareante" />
				<form:errors path="shareante" cssClass="error" />
			</div>
			<div class="form-group">
				<label>Share Post</label>
				<form:input path="sharepost" cssClass="form-control" id="sharepost" />
				<form:errors path="sharepost" cssClass="error" />
			</div>
			<div class="form-group">
				<label>Share Avis</label>
				<form:input path="shareavis" cssClass="form-control" id="shareavis" />
				<form:errors path="shareavis" cssClass="error" />
			</div>
			<div class="form-group">
				<label>Share Hertz</label>
				<form:input path="sharehertz" cssClass="form-control" id="sharehertz" />
				<form:errors path="sharehertz" cssClass="error" />
			</div>
			<div class="form-group">
				<label>Share Maggiore</label>
				<form:input path="sharemaggiore" cssClass="form-control" id="sharemaggiore" />
				<form:errors path="sharemaggiore" cssClass="error" />
			</div>
			<div class="form-group">
				<label>Share Sixt</label>
				<form:input path="sharesixt" cssClass="form-control" id="sharesixt" />
				<form:errors path="sharesixt" cssClass="error" />
			</div>
			<div class="form-group">
				<label>Area Geografica</label>
				<form:select path="oarea" cssClass="form-control" id="area">
					<form:option value="0">Seleziona un'area</form:option>
					<form:options items="${elencoAree}" itemValue="idarea" itemLabel="area" />
				</form:select>
				<form:errors path="oarea" cssClass="error"/>
			</div>
			<div class="form-group">
				<label>Area Geografica</label>
				<form:select path="oarea" cssClass="form-control" id="area">
					<form:option value="0">Seleziona un'area</form:option>
					<form:options items="${elencoAree}" itemValue="idarea" itemLabel="area" />
				</form:select>
				<form:errors path="oarea" cssClass="error"/>
			</div>
			<div class="form-group">
				<label>Azienda</label>
				<form:select path="ozienda" cssClass="form-control" id="azienda">
					<form:option value="0">Seleziona un'azienda</form:option>
					<form:options items="${elencoAziende}" itemValue="idazienda" itemLabel="azienda" />
				</form:select>
				<form:errors path="oazienda" cssClass="error"/>
			</div>
			<div class="form-group">
				<label>Venditore</label>
				<form:select path="ovenditore" cssClass="form-control" id="fullName">
					<form:option value="0">Seleziona un venditore</form:option>
					<form:options items="${elencoVenditori}" itemValue="idvenditore" itemLabel="fullName" />
				</form:select>
				<form:errors path="ovenditore" cssClass="error"/>
			</div>
			<div class="form-group">
				<label>SottoCategoria</label>
				<form:select path="osottocategoria" cssClass="form-control" id="sottocategoria">
					<form:option value="0">Seleziona una sottocategoria</form:option>
					<form:options items="${elencoSottoCategorie}" itemValue="idsottocategoria" itemLabel="fullName" />
				</form:select>
				<form:errors path="osottocategoria" cssClass="error"/>
			</div>
			<button type="submit" class="btn btn-primary">Salva</button>
		</form:form>
	</div>
</body>
</html>