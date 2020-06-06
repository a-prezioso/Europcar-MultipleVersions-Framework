<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<title>PgsGestioneAreaNuovoModifica</title>
<body>
<s:form action="AreaAct" >
<s:label> Modifica o Crea Area Geografica: </s:label>
<div align ="center">
<s:textfield label="Codice Area" name="codex" value="%{#session.oggetto.codice}" ></s:textfield>
<s:textfield label="Nome Area" name="areav" value="%{#session.oggetto.area}"></s:textfield>
<s:set var="idvend" value="%{#session.oggetto.ovenditore.idvenditore}"></s:set>
<s:select label="Venditore" name="idvenditore" list="#session.listavenditori" value="idvend"></s:select>
<s:submit method="registraArea" value="Registra" ></s:submit>
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

