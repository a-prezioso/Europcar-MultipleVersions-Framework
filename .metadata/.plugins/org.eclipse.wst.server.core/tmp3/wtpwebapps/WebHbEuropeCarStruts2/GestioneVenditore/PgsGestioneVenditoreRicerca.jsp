<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PgsGestioneVenditaRicerca</title>
</head>
<body>
	<s:form action="VenditoreAction" theme="simple">
	<div align="center">
		<s:submit align="left" action="Main" value="Torna ad Home"></s:submit>
		<br><br>
			<s:submit align="left" action="Main" value="Torna ad Home"></s:submit>
			<br> <br> <br> Pagine totali:
			<s:property value="#session.pagineprev" />
			<br> Pagina corrente:
			<s:property value="#session.paginacorrenteprev" />
			</div>
		<br><br> <s:submit align="left" method="indietroAlVenditore" value="Indietro"></s:submit><br>
		<div align="center">
			<s:set name="varElencoPrevisionale" value="#session.listaPrev"></s:set>
			<s:label>Gestione Venditori</s:label>
			<s:if test="%{#varElencoPrevisionale.size()==0}">
				<h1>Non ci sono Previsionali</h1>
				<s:submit align="center" method="nuovoPrevisionale" value="nuovo"></s:submit>
			</s:if>
			<s:else>
			<table>
			<tr>
				<td>Venditore</td>
				<td> <s:property value="#session.oggetto.cognome"/> <s:property value="#session.oggetto.nome"/> </td>
			</tr>
			</table>
			<h1>Filtra per: </h1>
			<table>
			<tr>
				<td>Area Geografica: </td>
				<td>Azienda: </td>
			</tr>
			
			<tr>
				<td><s:select name="idarea" list="#session.listaaree" value="%{#session.oggetto.idarea}"></s:select></td>
				<td><s:select name="idazienda" list="#session.listaaziende" value="%{#session.oggetto.idazienda}"></s:select></td>
			</tr>
			</table>
			<br><s:submit value="cerca" align="left" method="ricercaPerAreaAzienda"></s:submit><br><br>
				<table border="1">
					<tr>
						<td></td>
						<td>Area Geografica</td>
						<td>Azienda</td>
						<td>Venditore</td>
						<td>SottoCategoria</td>
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
					<s:set name="varInizio" value="#session.inizioprev"></s:set>
					<s:set name="varFine" value="#session.fineprev"></s:set>
					<s:iterator begin="#varInizio" end="#varFine" value="varElencoPrevisionale">
						<tr>
							<td><input type="radio" name="chiaveprevisionale"
								value="'<s:property value="idprevisione"/>'" /></td>
							<td><s:property value="oarea.area" /></td>
							<td><s:property value="oazienda.ragioneSociale"/></td>
							<td><s:property value="ovenditore.nome"/><s:property value="ovenditore.cognome"/></td>
							<td><s:property value="osottocategoria.sottocategoria"/></td>
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
					value="#session.controlloindietroprev"></s:set>
				<s:if test="%{#varControlloindietro}">
					<s:submit align="center" method="primaPrev" value="Prima" />
					<s:submit align="center" method="indietroPrev" value="Indietro" />
				</s:if>

				<s:set name="varControllofine" value="#session.controllofineprev"></s:set>
				<s:if test="%{#varControllofine}">
					<s:submit align="center" method="avanti" value="Avanti" />
					<s:submit align="center" method="ultimaPrev" value="Ultima" />
				</s:if>
				<br><br>
				<s:submit align="center" method="nuovoPrevisionale" value="Nuova Previsione"></s:submit>
				<s:submit align="center" method="modificaPrevisionale" value="Modifica Previsione"></s:submit>
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