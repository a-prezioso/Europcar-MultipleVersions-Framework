<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PgsGestioneImpostazioni</title>
</head>
<body>
	<s:form action="ImpostazioniUtenteAction" theme="simple">
		<s:submit align="left" action="Main" value="Torna ad Home"></s:submit>
		<div align="center">
			<s:set name="varElencoUtenti" value="#session.lista"></s:set>
			<s:label>Archivio Utente</s:label>
			<s:if test="%{#varElencoUtenti.size()==0}">
				<h1>Non ci sono Utenti</h1>
			</s:if>
				<table border="1">
					<tr>
						<td></td>
						<td>Username</td>
						<td>Password</td>
						<td>Venditore</td>
						<td>Admin</td>
					</tr>
					<s:iterator value="varElencoUtenti">
						<tr>
							<td><input type="radio" name="chiave"
								value="'<s:property value="idutente"/>'" /></td>
							<td><s:property value="username" /></td>
							<td><s:property value="password" /></td>
							<td><s:property value="ovenditore.cognome"/><s:property value="ovenditore.nome"/></td>
							<td><s:property value="admin" /></td>
						</tr>
					</s:iterator>
				</table>
				<br />
				<br />
				<s:submit align="center" method="modificaUtente" value="modifica"></s:submit>
		</div>
	</s:form>
	<s:if test="hasActionErrors()">
        <div class="errors">
            <s:actionerror />
        </div>
    </s:if>
</body>
</html>