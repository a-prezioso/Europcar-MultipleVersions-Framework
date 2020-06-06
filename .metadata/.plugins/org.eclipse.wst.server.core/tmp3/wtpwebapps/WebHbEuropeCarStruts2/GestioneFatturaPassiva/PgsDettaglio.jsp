<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PgsDettaglio.jsp</title>
</head>
<body>

	<s:form action = "GestioneFatAct" theme = "simple">
		<h1 align=center>Inserisci Fattura Passiva</h1>
		<br/>
		<div align="center">
		<table>
		<table><tr><td>	Dettaglio Fattura: <s:textfield label="dettaglio fattura" name="dettaglioFatturaDettaglio" value="%{#session.oggettoDettaglioFattura.dettagliofattura}"/> </td></tr></table>
		<table><tr><td>	Imponibile : <s:textfield label="Importo" name="importoDettaglio" value="%{#session.oggettoDettaglioFattura.importo}"/> </td></tr></table>
		<table><tr><td>	Importo Iva : <s:select label="Aliquota Iva" name="aliquotaDettaglio" list="#session.elencoAliquota" value="%{#session.oggettoDettaglioFattura.oaliquota.idaliquotaiva}"></s:select> </td></tr></table>
		<table><tr><td>	Preventivo : <s:select label="Preventivo" name="preventivoDettaglio" list="#session.elencoPreventivo" value="%{#session.oggettoDettaglioFattura.opreventivo.idpreventivo}"></s:select> </td></tr></table>
		<table><tr><td>	Spesa d'investimento : <s:select label="Spesa investimento" name="spesaDettaglio" list="#session.elencoSpesa" value="%{#session.oggettoDettaglioFattura.ospesainvestimento.idspesainvestimento}"></s:select></td></tr></table>
			</table>
			<br/><br/>
			<s:submit align="center" method="memoriaDettaglio" value="Aggiungi"/>
			<s:submit align="center" method="annullaDettaglioModifica" value="annulla"/>
		</div>
	</s:form>
	<s:if test="hasActionErrors()">
        <div class="errors">
            <s:actionerror />
        </div>
    </s:if>
</body>
</html>