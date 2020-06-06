<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
<title>PgsGestioneFornitore.jsp</title>
</head>


<h1>Gestione Fornitore</h1>

<body>
	<s:form action="FornitoreAct" theme="simple">
		<br>
		<br> <div align="center">
		<s:submit align="left" action="Main" value="Home" />
		<s:submit action="ArchivioAct" value="Archivio" />
		<br>
		<br>
		<br>
		<br>  Pagine totali:
			<s:property value="#session.pagine" />
			<br> Pagina corrente:
			<s:property value="#session.paginacorrente" />
		</div>
		<s:if test="%{#session.lista.size()==0}">
			Non ci sono Fornitori
			<br>
			<br>
			<s:submit method="nuovoFornitore" value="nuovo" />
		</s:if>


		<s:else>
		<div align="center">
			<table border="1">
				<tr>
					<td></td>
					<td>Ragione Sociale</td>
					<td>Indirizzo</td>
					<td>Citta</td>
					<td>Cap</td>
					<td>Provincia</td>
					<td>Partita Iva</td>
				</tr>
				<s:set name="varInizio" value="#session.inizio"></s:set>
				<s:set name="varFine" value="#session.fine"></s:set>
				<s:iterator begin="#varInizio" end="#varFine" value="#session.lista">
					<tr>
						<td><input id="chiaveFor" type="radio" name="chiave"
							value="'<s:property value="idfornitore"/>'"></td>
						<td><s:property value="ragionesociale" /></td>
						<td><s:property value="indirizzo" /></td>
						<td><s:property value="citta" /></td>
						<td><s:property value="cap" /></td>
						<td><s:property value="provincia" /></td>
						<td><s:property value="partitaiva" /></td>
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
			<s:submit align="center" method="nuovoFornitore" value="nuovo" />
			<s:submit align="center" method="modificaFornitore" value="modifica" />
			<s:submit align="center" onclick="return deleteConfirm()" method="eliminaFornitore" value="elimina" />
			</div>
			<script type="text/javascript">
					function deleteConfirm() {
					var elements = document.getElementsByName("chiave");
					for(var i = 0; i < elements.length; i++) {
						if (elements[i].checked) {
						if (confirm("Eliminare il fornitore selezionato?")) {
							return true; 
							} else {
								return false;
							} 
						} else {
							if(i == elements.length) {
								return true;
							}
							
						} 
					} }
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