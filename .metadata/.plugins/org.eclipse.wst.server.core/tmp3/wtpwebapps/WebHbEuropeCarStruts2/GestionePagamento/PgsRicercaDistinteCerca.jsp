<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<html>
<head>
<sx:head />
</head>
<meta charset="ISO-8859-1">
<title>PgsRicercaDistinteCerca</title>

<body>
	<s:form action="RicercaAction" theme="simple">
	<div align="center">
		<s:submit align="left" action="Main" value="Torna ad Home"></s:submit>
		<br><br>
		<s:submit align="left" action="RicercaAction" value="indietro"></s:submit>
			<br>
		<br>
		<br>
		<br> Pagine totali:
			<s:property value="#session.pagine" />
			<br> Pagina corrente:
			<s:property value="#session.paginacorrente" />
		</div>
		<div align="center">
			<s:set name="varElencoDistinte" value="#session.listadistinte"></s:set>
			<s:label>Gestione Distinte</s:label>
			<s:if test="%{#varElencoDistinte.size()==0}">
				<h1>Non ci sono Distinte </h1>
			</s:if>
			<s:else>
				<table>
						<tr> <td><s:select label="Fornitore" name="idfornitore" list="#session.listafornitori" value="%{#session.oggetto.ofatturapassiva.ofornitore.idfornitore}"/> </td></tr>
						<tr> <td><s:select label="Stato Fattura" name="stato" list="#session.stato" value="%{#session.oggetto}"/></td></tr>
						<tr><td><sx:datetimepicker label="Data Inizio" name="datainizio" displayFormat="dd-MM-yyyy" startDate="%{#session.datain}" endDate="%{#session.datafi}" value="%{#session.datain}" /> </td> </tr>
						<tr><td><sx:datetimepicker label="Data Fine" name="datafine" displayFormat="dd-MM-yyyy" startDate="%{#session.datain}" endDate="%{#session.datafi}" value="%{#session.datafi}" /></td></tr>
					</table>
					<s:submit align="center" method="ricercaDettagliata" value="cerca"></s:submit>
					<table  border="1">
					<tr>
						<td></td>
						<td>Dettaglio Fattura</td>
						<td>Fornitore</td>
						<td>Importo</td>
						<td>Importo Pagato</td>
					</tr>
					<s:set name="varInizio" value="#session.inizio"></s:set>
					<s:set name="varFine" value="#session.fine"></s:set>
					<s:iterator  begin="#varInizio" end="#varFine" value="varElencoDistinte">
						<tr>
							<td><input type="radio" name="chiave" value="'<s:property value="iddistinta"/>'" /></td>
							<td><s:property value="ofatturapassivadettaglio.dettagliofattura" /></td>
							<td><s:property value="ofatturapassivadettaglio.ofatturapassiva.ofornitore.ragionesociale"/></td>
							<td><s:property value="ofatturapassivadettaglio.importo"/></td>
							<td><s:property value="ofatturapassivadettaglio.importoPagato"/></td>
						</tr>
					</s:iterator>
				</table>
				<br>
				<s:set name="varControlloindietro"
					value="#session.controlloindietro"></s:set>
				<s:if test="%{#varControlloindietro}">
					<s:submit align="center" method="prima" value="Prima" />
					<s:submit align="center" method="indietro" value="Indietro" />
				</s:if>

				<s:set name="varControllofine" value="#session.controllofine"></s:set>
				<s:if test="%{#varControllofine}">
					<s:submit align="center" method="avanti" value="Avanti" />
					<s:submit align="center" method="ultima" value="Ultima" />
				</s:if>
				<br> <br>
			</s:else>
		</div>
	</s:form>
	<s:if test="hasActionErrors()">
        <div class="errors">
            <s:actionerror />
        </div>
    </s:if>
</body>
</html>