<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<title>PgsGestioneVenditoreNuovoModifica</title>
<body>
<s:form action="VenditoreAction" >
<s:label> Modifica o Crea Venditore: </s:label>
<div align ="center">
<s:if test="%{#session.oggetto2.isAdmin()}">
<s:textfield label="Cognome" name="cognomev" value="%{#session.oggetto.cognome}" ></s:textfield>
<s:textfield label="Nome" name="nomev" value="%{#session.oggetto.nome}" ></s:textfield>
<s:textfield label="Indirizzo" name="indirizzov" value="%{#session.oggetto.indirizzo}" ></s:textfield>
<s:textfield label="Numero Telefono" name="numTel" value="%{#session.oggetto.numerotelefono}"></s:textfield>
<s:set var="idtipo" value="%{#session.oggetto.otipovenditore.idtipovenditore}"/>
<s:select label="TipoVenditore" name="idtipovenditore" list="#session.listatipivenditori" value="#idtipo"></s:select>
<s:submit method="registraVenditore" value="Registra" ></s:submit>
<s:submit method="annulla" value="Annulla"></s:submit>
<s:submit method="nuovoTipoVenditore" value="Nuovo Tipo Venditore"></s:submit>
</s:if>
<s:else>
<s:textfield label="Cognome" name="cognomev" value="%{#session.oggetto.cognome}" ></s:textfield>
<s:textfield label="Nome" name="nomev" value="%{#session.oggetto.nome}" ></s:textfield>
<s:textfield label="Indirizzo" name="indirizzov" value="%{#session.oggetto.indirizzo}" ></s:textfield>
<s:textfield label="Numero Telefono" name="numTel" value="%{#session.oggetto.numerotelefono}"></s:textfield>
<s:submit method="registraVenditore" value="Registra" ></s:submit>
<s:submit method="annulla" value="Annulla"></s:submit>
</s:else>
</div>
</s:form>
<s:if test="hasActionErrors()">
        <div class="errors">
            <s:actionerror />
        </div>
    </s:if>
</body>
