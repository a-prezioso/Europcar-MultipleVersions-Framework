<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PgsFatturaPassiva.jsp</title>
</head>
<body>

	<s:form action="GestioneFatAct" theme="simple">
		<br>
		<br>
		<s:submit action="Main" value="home" />
		<s:submit action="FatturaPassivaAct" value="Indietro" />
		<h1 align=center>Gestione Fattura Passiva</h1>
		<br />
		<s:submit align="center" method="cambiaAnno"
			value="Cambia Anno Contabile"></s:submit>
		<div align="center">
			<s:set var="idfornitore"
				value="%{#session.oggetto.ofornitore.dfornitore}" />
			Fornitore :
			<s:select label="Fornitore" name="fornitorePar"
				list="#session.elencoFornitori" value="#idfornitore"></s:select>
			<s:submit align="center" method="ricerca" value="cerca" />
			<br />
			<br />Pagine totali:
			<s:property value="#session.pagine" />
			<br> Pagina corrente:
			<s:property value="#session.paginacorrente" /><br>
			<s:if test="%{#session.elenco.size()==0}">
				<br>
				<br>
	Non ci sono Fatture
	<br>
				<br>
				<s:submit align="center" method="nuovo" value="nuovo" />
				<s:submit action="FatturaPassivaAct" value="Indietro" />

			</s:if>
		</div>
		<s:else>
			<div align="center">
			<s:set name="varInizio" value="#session.inizio"></s:set>
			<s:set name="varFine" value="#session.fine"></s:set>
				<table border="1">
					<tr>
						<td></td>
						<td>Numero</td>
						<td>Data</td>

					</tr>
					<s:iterator begin="#varInizio" end="#varFine" value="#session.elenco">
						<tr>
							<td><input type="radio" name="chiave"
								value="'<s:property value="idfatturapassiva"/>'"></td>
							<td><s:property value="numero" /></td>
							<td><s:property value="data" /></td>
						</tr>
					</s:iterator>
				</table>
				<br />
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
				<br />
				<s:submit align="center" method="nuovo" value="nuovo" />
				<s:submit align="center" method="modifica" value="modifica" />
				<s:submit align="center" onclick="return deleteConfirm()"
					method="elimina" value="elimina" />
			</div>
		</s:else>

		<script type="text/javascript">
			function deleteConfirm() {
				var elements = document.getElementsByName("chiave");
				for (var i = 0; i < elements.length; i++) {
					if (elements[i].checked) {
						if (confirm("Eliminare la Fattura selezionata?")) {
							return true;
						} else {
							return false;
						}
					} else {
						if (i == elements.length) {
							return true;
						}

					}
				}
			}
		
			
		</script>

	</s:form>
	<s:if test="hasActionErrors()">
		<div class="errors">
			<s:actionerror />
		</div>
	</s:if>
</body>
</html>