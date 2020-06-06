<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
<title>PgsGestioneSottoCategoria.jsp</title>
</head>


<h1>Gestione SottoCategorie</h1>

<body>
	<s:form action="SottoCategoriaAct" theme="simple">
		<br>
		<br>
		<div align="center">
			<s:submit align="left" action="Main" value="Home" />
			<s:submit action="ArchivioAct" value="Archivio" />
			<br>
			<br>
			<br>
			<br>Pagine totali:
			<s:property value="#session.pagine" />
			<br> Pagina corrente:
			<s:property value="#session.paginacorrente" />
		</div>
		<s:if test="%{#session.lista.size()==0}">
			Non ci sono SottoCategorie
			<br>
			<br>
			<s:submit method="nuovaSottoCategoria" value="nuovo" />
		</s:if>


		<s:else>
			<div align="center">
				<table border="1">
					<tr>
						<td></td>
						<td>Codice</td>
						<td>SottoCategoria</td>
						<td>Area</td>
					</tr>
					<s:set name="varInizio" value="#session.inizio"></s:set>
					<s:set name="varFine" value="#session.fine"></s:set>
					<s:iterator value="#session.lista" begin="#varInizio"
						end="#varFine">
						<tr>
							<td><input id="chiaveSot" type="radio" name="chiave"
								value="'<s:property value="idsottocategoria"/>'"></td>
							<td><s:property value="codice" /></td>
							<td><s:property value="sottocategoria" /></td>
							<td><s:property value="oarea.area" /></td>
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
				<s:submit align="center" method="nuovaSottoCategoria" value="nuovo" />
				<s:submit align="center" method="modificaSottoCategoria"
					value="modifica" />
				<s:submit align="center" onclick="return deleteConfirm()"
					method="eliminaSottoCategoria" value="elimina" />
			</div>
			<script type="text/javascript">
					function deleteConfirm() {
					var elements = document.getElementsByName("chiave");
					for(var i = 0; i < elements.length; i++) {
						if (elements[i].checked) {
						if (confirm("Eliminare la sottocategoria selezionata?")) {
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