<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<title>PgsGestioneGruppoNuovoModifica</title>
<body>
<s:form action="GruppoAction" >
<s:label> Modifica o Crea Gruppo: </s:label>
<div align ="center">
<s:textfield label="Nome Gruppo" name="nome" value="%{#session.oggetto.nomeGruppo}" ></s:textfield>
<s:textfield label="Codice Identificativo" name="codex" value="%{#session.oggetto.codice}"></s:textfield>
<s:submit method="registraGruppo" value="Registra" ></s:submit>
<s:submit method="annulla" value="Annulla"></s:submit>
</div>
</s:form>
<s:if test="hasActionErrors()">
        <div class="errors">
            <s:actionerror />
        </div>
    </s:if>
</body>
</html>