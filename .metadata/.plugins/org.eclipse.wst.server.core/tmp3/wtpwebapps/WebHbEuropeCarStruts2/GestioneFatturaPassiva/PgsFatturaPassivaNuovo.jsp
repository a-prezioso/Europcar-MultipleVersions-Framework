<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PgsFatturaPassivaNuovo.jsp</title>
</head>
<sx:head />
<body>

<s:form action="GestioneFatAct" theme="simple">
<h1 align=center>Inserisci Fattura Passiva</h1>
<br>
<div align="center">
	Numero : <s:textfield label="Numero" name="numeroPar" value="%{#session.oggetto.numero}"/>
	<br><br>
	<sx:datetimepicker label="Data" name="dataPar" displayFormat="dd-MMM-yyyy" startDate="%{#session.datain}" endDate="%{#session.datafi}" value="%{#session.datain}" />
	<br><br>
	Fornitore : <s:set var="idforn" value="%{#session.oggetto.ofornitore.idfornitore}"></s:set>
	<s:select label="fornitore" name="fornitorePar" list="#session.elencoFornitori" value="#idforn" />
	<br><br>
	Descrizione : <s:textfield label="Descrizione" name="descrizionePar" value="%{#session.oggetto.descrizione}" />
			<br> <br> <br> <br>
			<s:submit align="center" method="nuovoDettaglioNuovo" value="nuovo Dettaglio" />
			<br> <br>
			<s:submit align="center" method="registra" value="registra" />
			<s:submit align="center" method="annulla" value="annulla" />
		</div>
	</s:form>
	<s:if test="hasActionErrors()">
		<div class="errors">
			<s:actionerror />
		</div>
	</s:if>
</body>
</html>