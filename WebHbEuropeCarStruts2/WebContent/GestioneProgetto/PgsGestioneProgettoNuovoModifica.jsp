<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
	
	<head>
	<meta charset="ISO-8859-1">
		<title>
			PgsProgettoNuovoModifica.jsp
		</title>
	</head>
	
	
	
		<h1>Modifica Progetto</h1>
	
	<body>
	
	<s:form action="ProgettoAct">
	
	<table>
	<tr>
	<s:textfield label="codice" name="codice" value="%{#session.oggetto.codice}"/>
	</tr>
	<tr>
	<s:textfield label="progetto" name="progetto" value="%{#session.oggetto.progetto}"/>
	</tr>
	</table>
	<br><br><br><br>
	<s:submit align="left" method="registra" value="registra"/>
	<s:submit align="left" method="annulla" value="annulla"/>
	</s:form>
	<s:if test="hasActionErrors()">
        <div class="errors">
            <s:actionerror />
        </div>
    </s:if>
	</body>
	
		
	
		
</html>
