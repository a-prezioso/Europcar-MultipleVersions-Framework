<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
<title>PgsElencoFatturaPerFornitore.jsp</title>
</head>


<h1>Gestione Fattura</h1>

<body>
	<s:form action="FornitoreFatAct" theme="simple">
		<br>
		<br>
		<div align="center">
			<s:submit align="left" action="Main" value="Home" />
			<s:submit align="center" action="FornitoreFatAct" value="indietro" />
			<br> <br> <br> <br> Pagine totali:
			<s:property value="#session.pagine" />
			<br> Pagina corrente:
			<s:property value="#session.paginacorrente" />

			<s:if test="%{#session.listafatture.size()==0}">
			Non ci sono Fatture
			<br>
				<br>

			</s:if>

		</div>
		<s:else>
			<div align="center">
				<table border="1">
					<tr>

						<td>Data Fattura</td>
						<td>N. Fattura</td>
						<td>Importo</td>
					</tr>
					<s:set name="varInizio" value="#session.inizio"></s:set>
					<s:set name="varFine" value="#session.fine"></s:set>

					<s:iterator begin="#varInizio" end="#varFine"
						value="#session.listafatture">
						<tr>
							<td><s:property value="ofatturapassiva.data" /></td>
							<td><s:property value="ofatturapassiva.numero" /></td>
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
				<br> <br>
			</div>
		</s:else>
	</s:form>
	<s:if test="hasActionErrors()">
		<div class="errors">
			<s:actionerror />
		</div>
	</s:if>
</body>


</html>