<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
<title>PgsElencoOrdinePerSottoCategoria.jsp</title>
</head>


<h1>Gestione Ordine</h1>

<body>
	<s:form action="SottoCategoriaOrdAct" theme="simple">
	<div align="center">
		<br>
		<br>
		<s:submit align="left" action="Main" value="Home" />
		<s:submit align="left" action="SottoCategoriaOrdAct" value="Indietro" />
		<br>
		<br>
		<br>
		<br> Pagine totali:
			<s:property value="#session.pagine" />
			<br> Pagina corrente:
			<s:property value="#session.paginacorrente" />
		<s:if test="%{#session.listaordini.size()==0}">
			<br><br>Non ci sono Ordini
			<br>
			<br>

		</s:if>
</div>

		<s:else>
<div align="center">
			<table border="1">
				<tr>

					<td>Descrizione</td>
					<td>Fornitore</td>
					<td>Progetto</td>
					<td>Importo</td>
				</tr>
	<s:set name="varInizio" value="#session.inizio"></s:set>
					<s:set name="varFine" value="#session.fine"></s:set>

					<s:iterator begin="#varInizio" end="#varFine" value="#session.listaordini">
					<tr>
						<td><s:property value="ospesainvestimento.spesainvestimento" />
						</td>
						<td><s:property
								value="oordineacquisto.ofornitore.ragionesociale" /></td>
						<td><s:property value="oprogetto.progetto" /></td>
						<td><s:property value="importo" /></td>
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
			<br>
			<br>
</div>
		</s:else>
	</s:form>

</body>


</html>