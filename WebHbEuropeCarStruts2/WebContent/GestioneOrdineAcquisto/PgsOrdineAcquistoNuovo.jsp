<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> <%@ taglib prefix="s" uri="/struts-tags" %> <%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PgsOrdineAcquistoNuovo.jsp</title>
</head>
<sx:head/>
<body>

	<s:form action = "GestioneOrdAct" theme = "simple">
		<h1 align=center>Inserisci Ordine D'Acquisto</h1>
		<br/>
		<div align="center">
		<table>
		<tr><td>
			<table><tr><td>Ordine d'Acquisto : <s:textfield label="ordineacquisto" name="ordineAcquistoPar" value="%{#session.oggetto.ordineacquisto}"/></td></tr></table>
			<table><tr><td>	<sx:datetimepicker label="Data" name="dataPar" displayFormat="dd-MM-yyyy" startDate="#session.datain" endDate="#session.datafi" value="#session.datain"/></td></tr></table>
			<table><tr><td><s:set var="idforn" value="%{#session.oggetto.ofornitore.idfornitore}"/>
            Fornitore : <s:select label="fornitore" name="fornitorePar" list="#session.elencoFornitori" value="#idforn"/></td></tr></table>
			<table><tr><td>Importo : <s:textfield label="importo" name="importoPar" value="%{#session.oggetto.importo}"/></td></tr></table>
           </td></tr> 
		</table>
			<s:submit align="center" method="nuovaSpesa" value="nuovo Dettaglio"/>
<br/><br/>
			<s:submit align="center" method="registra" value="registra"/>
			<s:submit align="center" method="annulla" value="annulla"/>
		</div>
	</s:form>
<s:if test="hasActionErrors()">
        <div class="errors">
            <s:actionerror />
        </div>
    </s:if>
</body>
</html>