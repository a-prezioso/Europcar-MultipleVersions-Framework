<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PgsGestioneAzienda</title>
</head>
<body>
	<s:form action="AziendaAction" theme="simple">
		<div align="center">
			<br>
			<br>
			<s:submit align="left" action="Main" value="Torna ad Home"></s:submit>
			<br> <br>
			<s:submit action="ArchivioAct" value="Archivio" />


			<br>
			<h2>Archivio Aziende</h2>
			<br> Pagine totali:
			<s:property value="#session.pagine" />
			<br> Pagina corrente:
			<s:property value="#session.paginacorrente" />

			<s:set name="varElencoAziende" value="#session.lista"></s:set>
			<br>
		</div>
		<s:if test="%{#varElencoAziende.size()==0}">
			<h1>Non ci sono Aziende</h1>
			<s:submit align="center" method="nuovaAzienda" value="nuovo"></s:submit>
			<br>
			<br>
			<br>
		</s:if>
		<s:else>
			<div align="center">
				<table border="1">
					<tr>
						<td></td>
						<td>Ragione Sociale</td>
						<td>Gruppo</td>
						<td>Indirizzo</td>
						<td>ContractID</td>
					</tr>
					<s:set name="varInizio" value="#session.inizio"></s:set>
					<s:set name="varFine" value="#session.fine"></s:set>
					<s:iterator begin="#varInizio" end="#varFine"
						value="varElencoAziende">
						<tr>
							<td><input id="chiaveAzi" type="radio" name="chiave"
								value="'<s:property value="idazienda"/>'" /></td>
							<td><s:property value="ragioneSociale" /></td>
							<td><s:property value="ogruppo.nomeGruppo" /></td>
							<td><s:property value="indirizzo" /></td>
							<td><s:property value="contractID" /></td>
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
					<s:submit align="center" method="execute" value="Avanti" />
					<s:submit align="center" method="ultima" value="Ultima" />
				</s:if>

				<br>
				<br>
				<s:submit align="left" method="nuovaAzienda" value="nuovo"></s:submit>
				<s:submit align="left" method="modificaAzienda" value="modifica"></s:submit>
				<s:submit align="left" onclick="return deleteConfirm()"
					method="eliminaAzienda" value="elimina"></s:submit>
			</div>

			<script type="text/javascript">
				function deleteConfirm() {
					var elements = document.getElementsByName("chiave");
					for (var i = 0; i < elements.length; i++) {
						if (elements[i].checked) {
							if (confirm("Eliminare l'azienda selezionato?")) {
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
		</s:else>
	</s:form>
	<s:if test="hasActionErrors()">
		<div class="errors">
			<s:actionerror />
		</div>
	</s:if>
</body>
</html>