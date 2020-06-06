<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PgsOrdineAcquisto.jsp</title>
</head>
<body>

	<s:form action="GestioneOrdAct" theme="simple">
		<s:submit action="Main" value="home" />
		<s:submit align="left" method="cambiaAnno"
			value="Cambia Anno Contabile"></s:submit>
		<s:submit action="OrdineAcquistoAct" value="indietro" />
		<h1 align=center>Gestione Ordini D'Acquisto</h1>
		<br>
		<div align="center">
			Fornitore :
			<s:select label="Fornitore" name="fornitorePar"
				list="#session.elencoFornitoriOrdini"
				value="%{#session.oggetto.ofornitore.idfornitore}"></s:select>
			<s:submit align="center" method="ricerca" value="cerca" />
			<br> <br> Pagine totali:
			<s:property value="#session.pagine" />
			<br> Pagina corrente:
			<s:property value="#session.paginacorrente" />
			<s:if test="%{#session.elenco.size()==0}">
			Non ci sono Ordini
			<br>
				<br>
				<s:submit align="center" method="nuovo" value="nuovo" />
			</s:if>
		</div>
		<s:else>
			<br>
			<br>
			<s:set name="varInizio" value="#session.inizio"></s:set>
			<s:set name="varFine" value="#session.fine"></s:set>
			<div align="center">
				<table border="1" align="center">
					<tr>
						<td></td>
						<td>Ordine D'Acquisto</td>
						<td>Data</td>
						<td>Fornitore</td>

					</tr>
					<s:iterator begin="#varInizio" end="#varFine"
						value="#session.elenco">
						<tr>
							<td><input type="radio" name="chiave"
								value="'<s:property value="idordineacquisto"/>'"></td>
							<td><s:property value="ordineacquisto" /></td>
							<td><s:property value="data" /></td>
							<td><s:property value="ofornitore.ragionesociale" /></td>
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
				<s:submit align="center" method="nuovo" value="nuovo" />
				<s:submit align="center" method="modifica" value="modifica" />
				<s:submit align="center" onclick="return deleteConfirm()"
					method="elimina" value="elimina" />
			</div>
		</s:else>

		<script type="text/javascript">
			function deleteConfirm() {
				if (chiave != 0) {
					if (confirm("eliminare l'Ordine d'Acquisto selezionato con tutti i suoi dettagli??"))
						return true;
				} else
					return false;
			}
		</script>

		<s:if test="hasActionErrors()">
			<div class="errors">
				<s:actionerror />
			</div>
		</s:if>

	</s:form>




</body>
</html>