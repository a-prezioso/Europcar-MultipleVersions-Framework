<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PgsGestioneVenditore</title>
</head>
<body>
	<s:form action="VenditoreAction" theme="simple">
		<div align="center">
			<s:submit align="left" action="Main" value="Torna ad Home"></s:submit>
			<br> <br> <br> Pagine totali:
			<s:property value="#session.pagine" />
			<br> Pagina corrente:
			<s:property value="#session.paginacorrente" />
		</div>
		<div align="center">
			<s:set name="varElencoVenditori" value="#session.lista"></s:set>
			<s:label>Gestione Venditori</s:label>
			<s:if test="%{#varElencoVenditori.size()==0}">
				<h1>Non ci sono Venditori</h1>
				<s:submit align="center" method="nuovoVenditore" value="nuovo"></s:submit>
			</s:if>
			<s:else>
				<s:if test="%{#session.oggetto2.isAdmin()}">
					<table border="1">
						<tr>
							<td></td>
							<td>Cognome</td>
							<td>Nome</td>
							<td>Indirizzo</td>
							<td>Numero Telefono</td>
							<td>Tipo Venditore</td>
						</tr>
						<s:set name="varInizio" value="#session.inizio"></s:set>
					<s:set name="varFine" value="#session.fine"></s:set>
						<s:iterator begin="#varInizio" end="#varFine" value="varElencoVenditori">
							<tr>
								<td><input type="radio" name="chiave"
									value="'<s:property value="idvenditore"/>'" /></td>
								<td><s:property value="cognome" /></td>
								<td><s:property value="nome" /></td>
								<td><s:property value="indirizzo" /></td>
								<td><s:property value="numerotelefono" /></td>
								<td><s:property value="otipovenditore.tipovenditore" /></td>
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
					<s:submit align="center" method="execute" value="Avanti" />
					<s:submit align="center" method="ultima" value="Ultima" />
				</s:if>
				<br><br>
					<s:submit align="center" method="nuovoVenditore" value="nuovo"></s:submit>
					<s:submit align="center" method="modificaVenditore"
						value="modifica"></s:submit>
					<s:submit align="center" onclick="return deleteConfirm()"
						method="eliminaVenditore" value="elimina"></s:submit>
					<s:submit align="center" method="previsionalePerVenditore"
						value="previsionale"></s:submit>
					</div>
					<script type="text/javascript">
						function deleteConfirm() {
							var elements = document.getElementsByName("chiave");
							for (var i = 0; i < elements.length; i++) {
								if (elements[i].checked) {
									if (confirm("Eliminare il venditore selezionato?")) {
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
				</s:if>
				<s:else>
					<table border="1">
						<tr>
							<td></td>
							<td>Cognome</td>
							<td>Nome</td>
							<td>Indirizzo</td>
							<td>Numero Telefono</td>
							<td>Tipo Venditore</td>
						</tr>
						<s:iterator value="varElencoVenditori">
							<tr>
								<td><input type="radio" name="chiave"
									value="'<s:property value="idvenditore"/>'" /></td>
								<td><s:property value="cognome" /></td>
								<td><s:property value="nome" /></td>
								<td><s:property value="indirizzo" /></td>
								<td><s:property value="numerotelefono" /></td>
								<td><s:property value="otipovenditore.tipovenditore" /></td>
							</tr>
						</s:iterator>
					</table>
					<br />
					<br />
					<s:submit align="center" method="modificaVenditore"
						value="modifica"></s:submit>
					<s:submit align="center" method="previsionalePerVenditore"
						value="previsionale"></s:submit>
				</s:else>
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