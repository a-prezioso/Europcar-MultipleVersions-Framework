<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PgsGestionePagamento.jsp</title>
</head>
<body>
<s:form action="PagamentoAction">
<table>
	<tr>
	<s:textfield label="Descrizione" disabled="true" name="descrizionevar" value="%{#session.oggettofattura.ofatturapassiva.descrizione}"/>
	</tr>
	<tr>
	<s:textfield disabled="true" label="Importo" name="importovar" value="%{#session.oggettofattura.importo}"/>
	</tr>
	<tr>
	<s:textfield label="Importo pagato" disabled="true" name="importopagatovar" value="%{#session.oggettofattura.importoPagato}"/>
	</tr>
	<tr>
	<s:textfield label="Importo da pagare" name="importopagatovar" value="%{#session.oggettofattura.importopagato}"/>
	</tr>
	</table>
	<s:submit align="center" method="registra" value="Salva"></s:submit>
	<s:submit align="center" method="annulla" value="Annulla"></s:submit>
</s:form>
	<s:if test="hasActionErrors()">
		<div class="errors">
			<s:actionerror />
		</div>
	</s:if>
</body>
</html>