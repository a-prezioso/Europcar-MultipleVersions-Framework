<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<title>PgsGestioneAziendaNuovoModifica</title>
<body>
<s:form action="AziendaAction" >
<s:label> Modifica o Crea Azienda: </s:label>
<div align ="center">
<s:textfield label="Ragione Sociale" name="ragSoc" value="%{#session.oggetto.ragioneSociale}" ></s:textfield>
<s:textfield label="Indirizzo" name="indirizz" value="%{#session.oggetto.indirizzo}"></s:textfield>
<s:textfield label="ContractID" name="cid" value="%{#session.oggetto.contractID}"></s:textfield>
<s:set var="idgroup" value="%{#session.oggetto.ogruppo.idgruppo}"></s:set>
<s:select label="Gruppo" name="idgruppo" list="#session.listagruppi" value="idgroup"></s:select>
<s:submit method="registraAzienda" value="Registra" ></s:submit>
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
