<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PgsGestioneGruppo</title>
</head>
<body>
	<s:form action="GruppoAction" theme="simple">
	<div align="center">
	<h2>Archivio Gruppo</h2>
		<s:submit align="left" action="Main" value="Torna ad Home"></s:submit>
		<br>
			
		<br>
		
		<s:submit action="ArchivioAct" value="Archivio" />
		<br>
		<br>
		<br>
		<br> Pagine totali:
			<s:property value="#session.pagine" />
			<br> Pagina corrente:
			<s:property value="#session.paginacorrente" />
		</div>
		<s:set name="varElencoGruppi" value="#session.lista"></s:set>
	
		<s:if test="%{#varElencoGruppi.size()==0}">
			<h1>Non ci sono Gruppi</h1>
			<s:submit align="center" method="nuovoGruppo" value="nuovo"></s:submit>
			<br>
			<br>
			<br>
			<br>
		</s:if>
		<s:else>
			<div align="center">
			<table border="1">
				<tr>
					<td></td>
					<td>Nome Gruppo</td>
					<td>Codice Identificativo</td>
				</tr>
				<s:set name="varInizio" value="#session.inizio"></s:set>
				<s:set name="varFine" value="#session.fine"></s:set>				
				<s:iterator begin="#varInizio" end="#varFine" value="varElencoGruppi">
					<tr>
						<td><input id="chiaveGru" type="radio" name="chiave"
							value="'<s:property value="idgruppo"/>'" /></td>
						<td><s:property value="nomeGruppo" /></td>
						<td><s:property value="codice" /></td>
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
			<s:submit align="left" method="nuovoGruppo" value="nuovo"></s:submit>
			<s:submit align="left" method="modificaGruppo" value="modifica"></s:submit>

			<s:submit align="left" onclick="return deleteConfirm()" method="eliminaGruppo" value="elimina"></s:submit>
			</div>
			<script type="text/javascript">
				function deleteConfirm() {
					var elements = document.getElementsByName("chiave");
					for (var i = 0; i < elements.length; i++) {
						if (elements[i].checked) {
							if (confirm("Eliminare l'aliquota selezionato?")) {
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