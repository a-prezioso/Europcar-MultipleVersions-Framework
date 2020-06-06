<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PgsGestioneAnnoContabile</title>
</head>
<body>
	<s:form action="AnnoContabileAction" theme="simple">
		<s:submit align="left" action="Main" value="Torna ad Home"></s:submit>
		<div align="center">
			<s:set name="varElencoAnni" value="#session.lista"></s:set>
			<s:label>Archivio Anni contabili</s:label>
			<br>
			<br>
			<br> Pagine totali:
			<s:property value="#session.pagine" />
			<br> Pagina corrente:
			<s:property value="#session.paginacorrente" />
			<br>
			<s:if test="%{#varElencoAnni.size()==0}">
				<h1>Non ci sono Anni contabili</h1>
				<s:submit align="center" method="nuovaAnno" value="nuovo"></s:submit>
			</s:if>
		</div>
		<s:else>
			<div align="center">
				<table border="1">
					<tr>
						<td></td>
						<td>Descrizione</td>
						<td>Data inizio</td>
						<td>Data fine</td>
					</tr>
					<s:set name="varInizio" value="#session.inizio"></s:set>
					<s:set name="varFine" value="#session.fine"></s:set>

					<s:iterator begin="#varInizio" end="#varFine" value="varElencoAnni">
						<tr>
							<td><input type="radio" name="chiave"
								value="'<s:property value="idannocontabile"/>'" /></td>
							<td><s:property value="descrizione" /></td>
							<td><s:property value="datainizio" /></td>
							<td><s:property value="datafine" /></td>
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
				<br> <br>
				<s:submit align="center" method="nuovaAnno" value="nuovo"></s:submit>
				<s:submit align="center" onclick="return deleteConfirm()" method="eliminaAnno" value="elimina"></s:submit>
			</div>

		</s:else>
	</s:form>
			<script type="text/javascript">
				function deleteConfirm() {
					var elements = document.getElementsByName("chiave");
					for (var i = 0; i < elements.length; i++) {
						if (elements[i].checked) {
							if (confirm("Eliminare l'anno contabile selezionato?")) {
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
	<s:if test="hasActionErrors()">
		<div class="errors">
			<s:actionerror />
		</div>
	</s:if>
</body>
</html>