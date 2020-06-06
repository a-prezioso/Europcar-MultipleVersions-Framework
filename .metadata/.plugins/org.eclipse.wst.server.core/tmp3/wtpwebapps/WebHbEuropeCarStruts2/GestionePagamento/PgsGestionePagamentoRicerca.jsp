<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>

<head>
<meta charset="ISO-8859-1">
<title>PgsGestionePagamentoRicerca</title>
</head>
<body>
	<s:form action="PagamentoAction" theme="simple">
		<s:submit align="left" action="Main" value="Torna ad Home"></s:submit>
		<br><div align="center">
		<s:set name="varElencoFatture" value="#session.listafatture"></s:set>
		<s:if test="%{#varElencoFatture==null}">
	<br>
				<s:select label="Fornitore" name="idfornitorevar"
							list="#session.listafornitori"
							value="%{#session.oggettofattura.ofatturapassiva.ofornitore.idfornitore}"></s:select>
						<br>
					<br>
					<br>


				<s:submit align="center" method="cerca" value="Cerca"></s:submit>
		<s:submit align="center" method="indietro" value="Chiudi"></s:submit>
	
		
	
		</s:if>
		</div>
		<s:else>
		<div align="center">
		<br><br><br>
			<s:select label="Fornitore" name="idfornitorevar"
				list="#session.listafornitori"
				value="%{#session.oggettofattura.ofatturapassiva.ofornitore.idfornitore}"></s:select>
				<br><br>
			<s:submit align="center" method="cerca" value="Cerca"></s:submit>
			<br><br>
			<table border="1">
				<tr>
					<td></td>
					<td>Descrizione</td>
					<td>Importo</td>
					<td>Importo pagato</td>
				</tr>
				<s:iterator value="#varElencoFatture">
					<tr>
						<td><input type="radio" name="chiave"
							value="'<s:property value="idfatturapassivadettaglio"/>'" /></td>
						<td><s:property value="ofatturapassiva.descrizione" /></td>
						<td><s:property value="importo" /></td>
						<td><s:property value="importoPagato" /></td>
					</tr>
				</s:iterator>
			</table>
			<br><br>
			<s:submit align="center" method="pagamento" value="Paga Fattura"></s:submit>
			<s:submit align="center" method="indietro" value="Chiudi"></s:submit>
			</div>
		</s:else>
	</s:form>
	<s:if test="hasActionErrors()">
        <div class="errors">
            <s:actionerror />
        </div>
    </s:if>
</body>
</html>