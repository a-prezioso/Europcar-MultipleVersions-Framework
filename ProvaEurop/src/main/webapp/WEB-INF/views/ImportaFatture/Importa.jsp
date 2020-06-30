<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Importa Fatture</title>
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
<body>
	<div class="container">
		<form id="importa" action="/ImportaFatture/Salva" method="post" enctype="multipart/form-data">
			<label>Data inizio: </label> 
			<input type="date" name="datainizio">
			<br> 
			<label>Data fine: </label> 
			<input type="date" name="datafine">
			<br>
			<label>File:</label>
			<input type="file" name="multifile"/>
			<button>Submit</button>
		</form>
	<c:if test="${not empty message}">
		<c:out value="${message}"/>
		</c:if>
	</div>

</body>
</html>