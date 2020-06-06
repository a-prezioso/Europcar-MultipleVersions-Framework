<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PgsOrdineAcquistoNuovaSpesa.jsp</title>
</head>
<body>

	<s:form action = "GestioneOrdAct" theme = "simple">
		<h1 align=center>Inserisci Ordine D'Acquisto</h1>
		<br/>
		<div align="center">
		<table>
		<tr><td>
		<table><tr><td>	Spesa Investimento : <s:select label="spesaInvestimento" name="spesaDettaglio" list="#session.elencoSpesa" value="%{#session.oggettoDettaglio.ospesaivestimento.idspesainvestimento}"></s:select></td></tr></table>
		<table><tr><td>	Progetto : <s:select label="progetto" name="progettoDettaglio" list="#session.elencoProgetti" value="%{session.oggettoDettaglio.oprogetto.idprogetto}"></s:select></td></tr></table>
		<table><tr><td>	Quantita <s:textfield label="quantita" name="quantitaDettaglio" value="%{#session.oggettoDettaglio.quantita}"/></td></tr></table>
		<table><tr><td>	Importo <s:textfield label="importo" name="importoDettaglio" value="%{#session.oggettoDettaglio.importo}"/></td></tr></table>
		</td></tr>
		</table>
			<br/><br/>
			<s:submit align="center" method="memoriaDettaglio" value="Aggiungi Dettagli"/>
			<s:submit align="center" method="salvaDettagli" value="Salva Dettagli Aggiunti"/>
			<s:submit align="center" method="annullaDettaglio" value="annulla"/>
		</div>
	</s:form>
		<s:if test="hasActionErrors()">
		        <div class="errors">
		            <s:actionerror />
		        </div>
  			</s:if>
</body>
</html>