<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<head>

</head>
<meta charset="ISO-8859-1">
<title>PgsDefinizioneBudgetRicerca.jsp</title>

<body>
	<s:form action="DefinizioneAction" theme="simple">
		<br>
		<s:submit align="left" action="Main" value="Torna ad Home"></s:submit>
		<s:submit align="left" action="DefinizioneAction" value="Indietro"></s:submit>
		<br>
		<br>
		<div align="center">
			<s:set name="varElencoSottoCategorie"
				value="#session.listasottocategorie"></s:set>
			<H2>Definizione Budget</H2>
			<s:if test="%{#varElencoSottoCategorie.size()==0}">
				<h1>Non ci sono SottoCategorie</h1>
				<s:submit align="center" method="elencoSottoCategorie"
					value="SottoCateogoria"></s:submit>
			</s:if>
			<br> Pagine totali:
			<s:property value="#session.pagine" />
			<br> Pagina corrente:
			<s:property value="#session.paginacorrente" />
			<br> <br>
			<s:else>
				<s:set name="varInizio" value="#session.inizio"></s:set>
				<s:set name="varIniziop" value="#session.inizioprev"></s:set>
				<s:set name="varFine" value="#session.fine"></s:set>
				<s:set name="varFinep" value="#session.fineprev"></s:set>

				<s:set var="idareavar" value="#session.mapidarea" />

				<s:select label="Area" name="idarea" list="#session.listaaree"
					value="#idareavar" />
				<s:submit align="center" method="cerca"
					value="Cerca"></s:submit>
				<table>
					<tr>
						<td>
							<table border="1" width="250" height="80%">
								<tr>
									<td></td>
									<td>Codice</td>
									<td>SottoCateogoria</td>
									<td>Budget</td>
								</tr>
								<s:set var="totale" value="0"></s:set>
								<s:iterator begin="#varInizio" end="#varFine"
									value="varElencoSottoCategorie">
									<tr>
										<td><input type="radio" name="chiave"
											value="'<s:property value="idsottocategoria"/>'" /></td>
										<td><s:property value="codice" /></td>
										<td><s:property value="sottocategoria" />
										<td><s:property value="budget" />
									</tr>
								</s:iterator>
								<tr>
									<td colspan="3">TOTALE :</td>
									<td><s:property value="#session.totale" /></td>
								</tr>
							</table>
						</td>
						<td>
							<table border="1" width="250" height="85%">
								<tr>
									<td>Previsionale</td>
								</tr>
								<s:iterator begin="#varIniziop" end="#varFinep"
									value="#session.elencoprevisionali">
									<tr>
										<td><s:property /></td>
									</tr>
								</s:iterator>
								<tr>
									<td><s:property value="#session.totale" /></td>
								</tr>
							</table>
						</td>
					</tr>
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
					<s:submit align="center" method="cercaSottoCategoriePerArea"
						value="Avanti" />
					<s:submit align="center" method="ultima" value="Ultima" />
				</s:if>
				<br>
				<br>

				<s:submit align="center" method="definizione" value="Definizione"></s:submit>
				<s:submit align="center" method="chiudi" value="Chiudi"></s:submit>
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
