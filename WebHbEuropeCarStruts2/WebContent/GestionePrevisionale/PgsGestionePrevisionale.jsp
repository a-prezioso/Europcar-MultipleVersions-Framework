<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<html>
<head>
<sx:head />
</head>
<meta charset="ISO-8859-1">
<title>PgsGestionePrevisionale</title>

<body>
	<s:form action="PrevisionaleAction" theme="simple">
	<div align="center">
		<s:submit align="left" action="Main" value="Torna ad Home"></s:submit>
		<br><br><s:submit align="left" action="PrevisionaleAction" value="Indietro"></s:submit>
		<br>
			<br>
			<br> Pagine totali:
			<s:property value="#session.pagine" />
			<br> Pagina corrente:
			<s:property value="#session.paginacorrente" />
			</div>
		<div align="center">
			<s:set name="varElencoPrevisionali" value="#session.lista"></s:set>
			<s:label>Gestione Previsionale</s:label>
			<s:if test="%{#varElencoPrevisionali.size()==0}">
				<h1>Non ci sono Previsionali </h1>
				<s:submit align="center" method="nuovoPrevisionale" value="nuovo"></s:submit>
			</s:if>
			<s:else>
			<table>
			<tr>
				<td>Venditore</td>
				<td> <s:property value="#session.oggettovenditore.cognome"/> <s:property value="#session.oggettovenditore.nome"/> </td>
			</tr>
			</table>
				<table>
				

						<tr> <td><s:select label="Area Geografica" name="idarea" list="#session.listaaree" value="%{#session.oggetto.oarea.idarea}"/> </td></tr>
						<tr> <td><s:select label="Azienda" name="idazienda" list="#session.listaaziende" value="%{#session.oggetto.oazienda.idazienda}"/></td></tr>
						<tr><td><sx:datetimepicker label="DataInizio" name="datainizio" displayFormat="dd-MM-yyyy" startDate="%{#session.datain}" endDate="%{#session.datafi}" value="%{#session.datain}"/> </td> </tr>
						<tr><td><sx:datetimepicker label="DataFine" name="datafine" displayFormat="dd-MM-yyyy" startDate="%{#session.datain}" endDate="%{#session.datafi}" value="%{#session.datafi}"/> </td></tr>
					</table>
					<s:submit align="center" method="cercaAreaAziendaData" value="cerca"></s:submit>
					<table  border="1">
					<tr>
						<td></td>
						<td>Area Geografica</td>
						<td>Azienda</td>
						<td>SottoCategoria</td>
						<s:if test="%{#session.oggetto2.isAdmin()}">
						<td>Venditore</td>
						</s:if>
						<td>Data Visita</td>
						<td>Anno Di Riferimento</td>
						<td>Data Registrazione</td>
						<td>Confidenza</td>
						<td>Potenzial EuropeCar</td>
						<td>Potenziale Azienda</td>
						<td>Share Ante </td>
						<td>Share Post</td>
						<td>Share Avis</td>
						<td>Share Hertz</td>
						<td>Share Maggiore</td>
						<td>Share Sixt</td>
					</tr>
					<s:set name="varInizio" value="#session.inizio"></s:set>
					<s:set name="varFine" value="#session.fine"></s:set>
					<s:iterator begin="#varInizio" end="#varFine" value="varElencoPrevisionali">
						<tr>
							<td><input type="radio" name="chiave"
								value="'<s:property value="idprevisione"/>'" /></td>
							<td><s:property value="oarea.area" /></td>
							<td><s:property value="oazienda.ragioneSociale"/></td>
							<td><s:property value="osottocategoria.sottocategoria"/></td>
							<s:if test="%{#session.oggetto2.isAdmin()}">
							<td><s:property value="ovenditore.nome"/><s:property value="ovenditore.cognome"/></td>
							</s:if>
							<td><s:property value="datavisita.getDay()"/>/<s:property value="datavisita.getMonth()"/>/<s:property value="annodiriferimento"/></td>
							<td><s:property value="annodiriferimento"/></td>
							<td><s:property value="dataregistrazione.getDay()"/>/<s:property value="dataregistrazione.getMonth()"/>/<s:property value="annodiriferimento"/></td>

							<td><s:property value="confidenza"/></td>
							<td><s:property value="potenzialeeuropecar"/></td>
							<td><s:property value="potenzialeazienda"/></td>
							<td><s:property value="shareante"/></td>
							<td><s:property value="sharepost"/></td>
							<td><s:property value="shareavis"/></td>
							<td><s:property value="sharehertz"/></td>
							<td><s:property value="sharemaggiore"/></td>
							<td><s:property value="sharesixt"/></td>
						</tr>
					</s:iterator>
				</table>
				<br />
				<br />
				<div align="center">

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
				<s:submit align="center" method="nuovoPrevisionale" value="nuovo"></s:submit>
				<s:submit align="center" method="modificaPrevisionale" value="modifica"></s:submit>
				<s:submit align="center" onclick="return deleteConfirm()"
					method="eliminaPrevisionale" value="elimina"></s:submit>
					</div>
				<script type="text/javascript">
					function deleteConfirm() {
					var elements = document.getElementsByName("chiave");
					for(var i = 0; i < elements.length; i++) {
						if (elements[i].checked) {
						if (confirm("Eliminare il previsionale selezionato?")) {
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
		</div>
	</s:form>
	<s:if test="hasActionErrors()">
        <div class="errors">
            <s:actionerror />
        </div>
    </s:if>
</body>
</html>