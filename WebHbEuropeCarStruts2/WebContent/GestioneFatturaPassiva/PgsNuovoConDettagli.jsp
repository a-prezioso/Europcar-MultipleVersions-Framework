<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<!DOCTYPE html>
<html>
<sx:head />
<head>
<meta charset="ISO-8859-1">
<title>PgsNuovoConDettagli.jsp</title>
</head>
<body>

	<s:form action="GestioneFatAct" theme="simple">
		<h1 align=center>Inserisci Fattura Passiva</h1>
		<br />
		<div align="center">
			<table>
				<table>
					<tr>
						<td>Numero : <s:textfield label="Numero" name="numeroPar"
								value="%{#session.oggetto.numero}" /></td>
					</tr>
				</table>
				<BR>
				<table>
					<tr>
						<td><s:set var="idfornitore"
								value="%{#session.oggetto.ofornitore.idfornitore}" /> Fornitore
							: <s:select label="fornitore" name="fornitorePar"
								list="#session.elencoFornitori" value="#idfornitore" /></td>
					</tr>
				</table>
				<BR>
				<table>
					<tr>
						<td><sx:datetimepicker label="Data" name="dataPar"
								displayFormat="dd-MM-yyyy" startDate="%{#session.datain}"
								endDate="%{#session.datafi}" value="%{#session.oggetto.data}" /></td>
					</tr>
				</table>
				<table>
					<tr>
						<td>Descrizione : <s:textfield label="Descrizione"
								name="descrizionePar" value="%{#session.oggetto.descrizione}" /></td>
					</tr>
				</table>
			</table>
			<br />Pagine totali:
			<s:property value="#session.pagine" />
			<br> Pagina corrente:
			<s:property value="#session.paginacorrente" /> <br><br>
			<s:if test="%{#session.elencoDettagli.size()==0}">
			Non ci sono Dettagli
			<br>
				<br>
				<s:submit align="center" method="nuovoDettaglioNuovo"
					value="nuovo Dettaglio" />
				<s:submit align="center" method="annulla" value="annulla" />
			</s:if>
			<s:else>
			<s:set name="varInizio" value="#session.inizio"></s:set>
			<s:set name="varFine" value="#session.fine"></s:set>
				<table border="1">
					<tr>
						<td></td>
						<td>Dettaglio Fattura</td>
						<td>Numero Preventivo</td>
						<td>Imponibile</td>
						<td>Iva</td>

					</tr>

					<s:iterator begin="#varInizio" end="#varFine" value="#session.elencoDettagli" status="incr">
						<tr>
							<td><input type="radio" name="chiaveDettaglio"
								value="<s:property value="%{#incr.index}" />" /></td>
							<td><s:property value="dettagliofattura" /></td>
							<td><s:property value="opreventivo.codice" /></td>
							<td><s:property value="importo" /></td>
							<td><s:property value="oaliquota.aliquota" /></td>

						</tr>
					</s:iterator>
				</table>
			<br><s:set name="varControlloindietro" value="#session.controlloindietro"></s:set>
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

				<s:submit align="center" method="nuovoDettaglioNuovo"
					value="nuovo Dettaglio" />
				<s:submit align="center" onclick="return deleteConfirm()"
					method="eliminaDettaglioNuovo" value="elimina Dettaglio" />
				
				<br>
				<br>
				<s:submit align="center" method="registra" value="registra" />
				<s:submit align="center" method="annulla" value="annulla" />
			</s:else>
			<script type="text/javascript">
					function deleteConfirm() {
						var elements = document
								.getElementsByName("chiaveDettaglio");
						for (var i = 0; i < elements.length; i++) {
							if (elements[i].checked) {
								if (confirm("Eliminare il Dettaglio selezionato?")) {
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
		</div>
	</s:form>
	<s:if test="hasActionErrors()">
		<div class="errors">
			<s:actionerror />
		</div>
	</s:if>
</body>
</html>