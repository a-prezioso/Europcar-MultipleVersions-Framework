<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PgsGestioneUtente</title>
</head>
<body>
	<s:form action="UtenteAction" theme="simple">
		<s:submit align="left" action="Main" value="Torna ad Home"></s:submit>
		<div align="center">
			<s:set name="varElencoUtenti" value="#session.lista"></s:set>
			<s:label>Archivio Utente</s:label>
			<br> Pagine totali:
			<s:property value="#session.pagine" />
			<br> Pagina corrente:
			<s:property value="#session.paginacorrente" />
			<s:if test="%{#varElencoUtenti.size()==0}">
				<h1>Non ci sono Utenti</h1>
				<s:if test="%{#session.oggetto2.isAdmin()}">
					<s:submit align="center" method="nuovoUtente" value="nuovo"></s:submit>
				</s:if>
			</s:if>
			<s:else>
				<div align="center">

						<table border="1">
							<tr>
								<td></td>
								<td>Username</td>
								<td>Password</td>
								<td>Venditore</td>
								<td>Admin</td>
							</tr>
							<s:set name="varInizio" value="#session.inizio"></s:set>
							<s:set name="varFine" value="#session.fine"></s:set>

							<s:iterator begin="#varInizio" end="#varFine"
								value="varElencoUtenti">
								<tr>
									<td><input type="radio" name="chiave"
										value="'<s:property value="idutente"/>'" /></td>
									<td><s:property value="username" /></td>
									<td><s:property value="password" /></td>
									<td><s:property value="ovenditore.cognome" /> <s:property
											value="ovenditore.nome" /></td>
									<td><s:property value="admin" /></td>
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
						<s:submit align="center" method="nuovoUtente" value="nuovo"></s:submit>
						<s:submit align="center" method="modificaUtente" value="modifica"></s:submit>
						<s:submit align="center" onclick="return deleteConfirm()"
							method="eliminaUtente" value="elimina"></s:submit>
				</div>
				<script type="text/javascript">
					function deleteConfirm() {
						var elements = document.getElementsByName("chiave");
						for (var i = 0; i < elements.length; i++) {
							if (elements[i].checked) {
								if (confirm("Eliminare l'utente selezionato?")) {
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
		</div>
	</s:form>
	<s:if test="hasActionErrors()">
		<div class="errors">
			<s:actionerror />
		</div>
	</s:if>
</body>
</html>