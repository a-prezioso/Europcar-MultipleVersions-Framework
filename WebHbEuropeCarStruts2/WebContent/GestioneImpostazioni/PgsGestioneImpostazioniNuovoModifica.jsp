<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>PgsGestioneUtenteNuovoModifica</title>
<body>
	<s:form action="ImpostazioniUtenteAction">
		<s:label> Modifica Utente: </s:label>
		<div align="center">

				<s:textfield label="Username" name="userv"
					value="%{#session.oggetto2.username}"></s:textfield>
				<s:submit method="cambiaPassword" value="CambiaPassword"></s:submit>
				<s:submit method="registraUtente" value="Registra"></s:submit>
				<s:submit method="annullauser" value="Annulla"></s:submit>

		</div>
	</s:form>
	<s:if test="hasActionErrors()">
        <div class="errors">
            <s:actionerror />
        </div>
    </s:if>
</body>