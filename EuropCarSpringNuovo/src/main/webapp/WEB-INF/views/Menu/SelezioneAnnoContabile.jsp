<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Selezione anno contabile</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</head>

<spring:url value="/Login/Login/" var="addURL" />

<body>
	<div class="container">
		<spring:url value="/SelezioneAnno/ProcessaAnno/" var="saveURL" />
		<br>
		<br>
		<h2>Selezione anno contabile</h2>
		<form:form modelAttribute="oggettoAnnoPermanente" method="post"
			action="${saveURL}" cssClass="form">

			<div class="form-group">
				<br>
				<br> <label>Anno Contabile</label>
				<form:select path="idannocontabile" cssClass="form-control"
					id="area">
					<br>
					<br>
					<form:option value="0">Seleziona un'anno:</form:option>
					<form:options items="${elencoAnni}" itemValue="idannocontabile"
						itemLabel="descrizione" />
				</form:select>
				<br>
				<c:if test="${not empty message}">
					<c:out value="${message}" />
				</c:if>
				<br>
			</div>
			<button type="submit" class="btn btn-primary">Salva</button>
		</form:form>
	</div>
</body>
</html>