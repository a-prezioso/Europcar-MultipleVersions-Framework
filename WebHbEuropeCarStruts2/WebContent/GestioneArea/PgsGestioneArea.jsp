<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PgsGestioneArea</title>
</head>
<body>
	<s:form action="AreaAct" theme="simple">
	<br><br>
		<div align="center">
		<s:submit align="left" action="Main" value="Torna ad Home"></s:submit>
		<s:submit action="ArchivioAct" value="Archivio" />
		<br>
		<br>
		<h2>Archivio Aree</h2>
		<br>
		<br> Pagine totali:
			<s:property value="#session.pagine" />
			<br> Pagina corrente:
			<s:property value="#session.paginacorrente" />
		</div>
		<s:set name="varElencoAree" value="#session.lista"></s:set>
		
		<s:if test="%{#varElencoAree.size()==0}">
			<h1>Non ci sono Aree</h1>
			<s:submit align="center" method="nuovaArea" value="nuovo"></s:submit>
		
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
					<td>Area Geografica</td>
					<td>Venditore</td>
					<td>Codice Area</td>
				</tr>
					<s:set name="varInizio" value="#session.inizio"></s:set>
					<s:set name="varFine" value="#session.fine"></s:set>
				<s:iterator begin="#varInizio" end="#varFine" value="varElencoAree">
					<tr>
						<td><input id="chiaveArea" type="radio" name="chiave"
							value="'<s:property value="idarea"/>'" /></td>
						<td><s:property value="area" /></td>
						<td><s:property value="ovenditore.cognome" /> <s:property
								value="ovenditore.nome" /></td>
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
			<s:submit align="left" method="nuovaArea" value="nuova"></s:submit>
			<s:submit align="left" method="modificaArea" value="modifica"></s:submit>
			<s:submit align="left" onclick="return deleteConfirm()" method="eliminaArea" value="elimina"></s:submit>
			</div>
			<script type="text/javascript">
				function deleteConfirm() {
					var elements = document.getElementsByName("chiave");
					for (var i = 0; i < elements.length; i++) {
						if (elements[i].checked) {
							if (confirm("Eliminare l'area selezionata?")) {
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