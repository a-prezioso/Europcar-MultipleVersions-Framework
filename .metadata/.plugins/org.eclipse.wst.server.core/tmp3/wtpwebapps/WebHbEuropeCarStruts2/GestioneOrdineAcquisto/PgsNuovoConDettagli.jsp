<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PgsNuovoConDettagli.jsp</title>
</head>
<sx:head />
<body>

	<s:form action="GestioneOrdAct" theme="simple">
		<h1 align=center>Inserisci Ordine D'Acquisto</h1>
		<br />
		<div align="center">
			<table>
				<tr>
					<td>

						<table>
							<tr>
								<td>Ordine d'Acquisto : <s:textfield label="ordineacquisto"
										name="ordineAcquistoPar"
										value="%{#session.oggetto.ordineacquisto}" />
								</td>
							</tr>
						</table>
						<table>
							<tr>
								<td><sx:datetimepicker label="Data" name="dataPar"
										displayFormat="dd-MM-yyyy" startDate="#session.datain"
										endDate="#session.datafi" value="#session.datain" /></td>
							</tr>
						</table>
						<table>
							<tr>
								<td><s:set var="idforn"
										value="%{#session.oggetto.ofornitore.idfornitore}" />
									Fornitore : <s:select label="fornitore" name="fornitorePar"
										list="#session.elencoFornitori" value="#idforn" /></td>
							</tr>
						</table>
						<table>
							<tr>
								<td>Importo : <s:textfield label="importo"
										name="importoPar" value="%{#session.oggetto.importo}" /></td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
			<br> Pagine totali:
			<s:property value="#session.pagine" />
			<br> Pagina corrente:
			<s:property value="#session.paginacorrente" />
			<s:if test="%{#session.elencoDettagli.size()==0}">
				<br>
				<br>
			Non ci sono Dettagli
			<br>
				<br>
				<s:submit align="center" method="nuovaSpesa" value="nuovo Dettaglio" />
				<s:submit align="center" method="annulla" value="annulla" />
			</s:if>
			<br>
			<br>
			<s:else>
			<s:set name="varInizio" value="#session.inizio"></s:set>
			<s:set name="varFine" value="#session.fine"></s:set>
				<table border="1">
					<tr>
						<td></td>
						<td>Quantita</td>
						<td>Spesa Investimento</td>
						<td>Progetto</td>
						<td>Sotto Categoria</td>
						<td>Importo Unitario</td>
						<td>Importo totale</td>
					</tr>
					<s:iterator begin="#varInizio" end="#varFine" value="#session.elencoDettagli" status="incr">
						<tr>
							<td><input type="radio" name="chiaveDettaglio" value="<s:property value="%{#incr.index}" />" /></td>
							<td><s:property value="quantita" /></td>
							<td><s:property value="ospesainvestimento.spesainvestimento" /> </td>
							<td><s:property value="oprogetto.progetto" /></td>
							<td><s:property value="ospesainvestimento.osottocategoria.sottocategoria" /></td>
							<td><s:property value="importo" /></td>
							<td><s:property value="oordineacquisto.importo" /></td>
						</tr>
					</s:iterator>
				</table>
				<br>	<s:set name="varControlloindietro" value="#session.controlloindietro"></s:set>
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
				<s:submit align="center" method="nuovaSpesa" value="nuovo Dettaglio" />
				<s:submit align="center" method="eliminaSpesa" value="elimina Dettaglio" />
				<br><br>
				<s:submit align="center" method="registra" value="registra" />
				<s:submit align="center" method="annullaModifica" value="annulla" />

			</s:else>
		</div>
	</s:form>
	<s:if test="hasActionErrors()">
		<div class="errors">
			<s:actionerror />
		</div>
	</s:if>
</body>
</html>