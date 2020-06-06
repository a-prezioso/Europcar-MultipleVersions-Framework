<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
	<head>
		<title>
			PgsSottoPreventivoNuovoModifica.jsp
		</title>
	</head>
		<h1>Modifica Preventivo</h1>
	<body>
	<s:form action="PreventivoAct">
	<table>
	<tr>
	<s:select label="Fornitore" name="IDFornitore" list="#session.mappa" value="%{#session.oggetto.ofornitore.idfornitore}"/>
	</tr>
	<tr>
	<s:textfield label="Codice" name="codice" value="%{#session.oggetto.codice}"/>
	</tr>
	<tr>
	<s:textfield label="Preventivo" name="preventivo" value="%{#session.oggetto.preventivo}"/></tr>
	</table>
	<br><br><br><br>
	<s:submit align="left" method="registra" value="registra"/>
	<s:submit align="left" method="annulla" value="annulla"/>
	</s:form>
		<s:if test="hasActionErrors()">
        <div class="errors">
            <s:actionerror />
        </div>
    </s:if>
	</body>	
</html>

