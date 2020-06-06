<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
</head>
<meta charset="ISO-8859-1">

<title>PgsGestioneAliquotaIva.jsp</title>
<h1>Gestione Aliquota Iva</h1>

<body>

	<s:form action="AliquotaIvaAct" theme="simple">
		<br>
		<br>
		<div align="center">
			<s:submit align="left" action="Main" value="Home" />
			<s:submit action="ArchivioAct" value="Archivio" />
			<br>
			<br>
			<br>
			<br> Pagine totali:
			<s:property value="#session.pagine" />
			<br> Pagina corrente:
			<s:property value="#session.paginacorrente" />
		</div>
		<s:if test="%{#session.lista.size()==0}">
			Non ci sono Aliquote
			<br>
			<br>
			<s:submit method="nuovaAliquota" value="nuovo" />
		</s:if>


		<s:else>
			<div align="center">
				<table border="1">
					<tr>
						<td></td>
						<td>Descrizione</td>
						<td>Aliquota</td>
					</tr>
					<s:set name="varInizio" value="#session.inizio"></s:set>
					<s:set name="varFine" value="#session.fine"></s:set>

					<s:iterator begin="#varInizio" end="#varFine" value="#session.lista">
						<tr>
							<td><input id="chiaveAli" type="radio" name="chiave" value="'<s:property value="idaliquotaiva"/>'"></td>
							<td><s:property value="descrizione" /></td>
							<td><s:property value="aliquota" /></td>
						</tr>
					</s:iterator>
				</table>
			</div>
			<br>
			<div align="center">

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
				<s:submit align="center" method="nuovaAliquota" value="nuovo" />
				<s:submit align="center" method="modificaAliquota" value="modifica" />
				<s:submit align="center" onclick="return deleteConfirm()"
					method="eliminaAliquota" value="elimina" />
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