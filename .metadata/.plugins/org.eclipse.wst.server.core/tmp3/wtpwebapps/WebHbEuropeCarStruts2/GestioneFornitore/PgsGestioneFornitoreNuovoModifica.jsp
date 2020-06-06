<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
	
	<head>
		<title>
			PgsFornitoreNuovoModifica.jsp
		</title>
	</head>
	
	
	
		<h1>Modifica Fornitore</h1>
	
	<body>
	
	<s:form action="FornitoreAct">
	
	<table>
	<tr>
	<s:textfield label="ragionesociale" name="ragionesociale" value="%{#session.oggetto.ragionesociale}"/>
	</tr>
	<tr>
	<s:textfield label="indirizzo" name="indirizzo" value="%{#session.oggetto.indirizzo}"/>
	</tr>
	<tr>
	<s:textfield label="citta" name="citta" value="%{#session.oggetto.citta}"/>
	</tr>
	<tr>
	<s:textfield label="cap" name="cap" value="%{#session.oggetto.cap}"/>
	</tr>
	<tr>
	<s:textfield label="provincia" name="provincia" value="%{#session.oggetto.provincia}"/>
	</tr>
	<tr>
	<s:textfield label="partitaiva" name="partitaiva" value="%{#session.oggetto.partitaiva}"/>
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
