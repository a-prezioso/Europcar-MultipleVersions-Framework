<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PgsGestioneAvanzamentoRicerca.jsp</title>
<sx:head />
</head>
<body>
	<s:form action="AvanzamentoAction" theme="simple">

		<s:submit align="left" action="Main" value="Torna alla Home"></s:submit>
		<s:submit align="left" method="indietroCerca" value="Indietro"></s:submit>
		<s:set name="varElencoSottoCategorie" value="#session.listasottocategorie"></s:set>
		<br>
		<h2>Avanzamento</h2>
		<br>
		<br> Pagine totali:
			<s:property value="#session.pagine" />
			<br> Pagina corrente:
			<s:property value="#session.paginacorrente" />
				<br>	<br>	<br>	
		<s:if test="%{#varElencoSottoCategorie.size()==0}">
			<h1>Non ci sono Sottocategorie per quest'Area</h1>
			<s:select label="Area" name="idarea" list="#session.listaaree" value="%{#session.oggettoarea.idarea}" />
			<s:submit align="center" method="cerca" value="cerca" />
			<br>
			<br>
			<tr>
				<td><sx:datetimepicker label="DataInizio" name="datainizio" displayFormat="dd-MMM-yyyy" startDate="%{#session.datain}" endDate="%{#session.datafi}" value="%{#session.datain}" /></td>
			</tr>
			<tr>
				<td><sx:datetimepicker label="DataFine" name="datafine" displayFormat="dd-MMM-yyyy" startDate="%{#session.datain}" endDate="%{#session.datafi}" value="%{#session.datafi}" /></td>
			</tr>
		</s:if>

		<s:else>		
			<s:set name="varInizio" value="#session.inizio"></s:set>
			<s:set name="varIniziob" value="#session.iniziobudget"></s:set>
			<s:set name="varInizioa" value="#session.inizioavanzamento"></s:set>
			<s:set name="varFine" value="#session.fine"></s:set>	
			<s:set name="varFineb" value="#session.finebudget"></s:set>
			<s:set name="varFinea" value="#session.fineavanzamento"></s:set>
			
		<s:select label="Area" name="idarea" list="#session.listaaree" value="%{#session.oggettoarea.idarea}" />
			<s:submit align="center" method="cerca" value="cerca" />
			<br>
			<br>
			<tr>
				<td><sx:datetimepicker label="DataInizio" name="datainizio" displayFormat="dd-MMM-yyyy" startDate="%{#session.datain}" endDate="%{#session.datafi}" value="%{#session.datain}" /></td>
			</tr>
			<tr>
				<td><sx:datetimepicker label="DataFine" name="datafine" displayFormat="dd-MMM-yyyy" startDate="%{#session.datain}" endDate="%{#session.datafi}" value="%{#session.datafi}" /></td>
			</tr>
			<table>
				<tr>
					<td>
						<table border="1">
							<tr>
								<td>Codice</td>
								<td>SottoCategoria</td>
								<td>Budget</td>
							</tr>
							<s:iterator begin="#varInizio" end="#varFine" value="varElencoSottoCategorie">
								<tr>
									<td><s:property value="codice" /></td>
									<td><s:property value="sottocategoria" /></td>
									<td><s:property value="budget" /></td>
								</tr>
							</s:iterator>
						</table>
					</td>
					<td>
						<table border="1">
							<tr>
								<td>Budget Speso</td>
							</tr>
							<s:iterator begin="#varIniziob" end="#varFineb" value="#session.listabudgets">
								<tr>
									<td><s:property /></td>
								</tr>
							</s:iterator>
						</table>
					</td>
					<td>
						<table border="1">
							<tr>
								<td>Avanzamento</td>
							</tr>
							<s:iterator begin="#varInizioa" end="#varFinea" value="#session.listaavanzamenti">
								<tr>
									<td><s:property /></td>
								</tr>
							</s:iterator>
						</table>
					</td>
				</tr>
			</table> 
			<br><br>
			<s:set name="varControlloindietro"
					value="#session.controlloindietro"></s:set>
				<s:if test="%{#varControlloindietro}">
					<s:submit align="center" method="prima" value="Prima" />
					<s:submit align="center" method="indietro" value="Indietro" />
				</s:if>

				<s:set name="varControllofine" value="#session.controllofine"></s:set>
				<s:if test="%{#varControllofine}">
					<s:submit align="center" method="avanzamento" value="Avanti" />
					<s:submit align="center" method="ultima" value="Ultima" />
				</s:if>
				<br> <br>
		</s:else>
	</s:form>
	<s:if test="hasActionErrors()">
		<div class="errors">
			<s:actionerror />
		</div>
	</s:if>
</body>
</html>