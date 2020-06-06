<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<html>
<head>
<sx:head />
</head>
<title>PgsGestionePrevisionaleNuovoModifica</title>
<body>
<s:form action="PrevisionaleAction" >
<s:label> Gestione Previsionale: </s:label>
<div align ="center">

<s:set var="idareavar" value="#session.oggetto.oarea.idarea"/>
<s:select label="Area Geografica" name="idarea" list="#session.listaaree" value="#idareavar"/>
<s:set var="idaziendavar" value="#session.oggetto.oazienda.idazienda"/>
<s:select label="Azienda" name="idazienda" list="#session.listaaziende" value="#idaziendavar"/>
<s:set var="idsottocatvar" value="#session.oggetto.osottocategoria.idsottocategoria"/>
<s:select label="SottoCategoria" name="idsottocategoria" list="#session.listasottocategorie" value="#idsottocatvar"/>
<s:if test="%{#session.oggetto2.isAdmin()}">
<s:set var="idvenditorevar" value="#session.oggetto.ovenditore.idvenditore"/>
<s:select label="Venditore" name="idvenditore" list="#session.listavenditori" value="#idvenditorevar"/>
</s:if>

<sx:datetimepicker label="DataVisita" name="datavisita" displayFormat="dd-MMM-yyyy" startDate="#session.datain" endDate="#session.datafi" value="#session.datain"/>

<sx:datetimepicker label="AnnoDiRiferimento" name="annodiriferimento" displayFormat="dd-MMM-yyyy" startDate="#session.datain" endDate="#session.datafi" value="#session.datain"/>

<sx:datetimepicker label="DataRegistrazione" name="dataregistrazione" displayFormat="dd-MMM-yyyy" startDate="#session.datain" endDate="#session.datafi" value="#session.datain"/>

<s:textfield label="Confidenza" name="confidenza" value="%{#session.oggetto.confidenza}"/>
<s:textfield label="PotenzialeEuropeCar" name="potenzialeeuropecar" value="%{#session.oggetto.potenzialeeuropecar}"/>
<s:textfield label="PotenzialeAzienda" name="potenzialeazienda" value="%{#session.oggetto.potenzialeazienda}"/>
<s:textfield label="ShareAnte" name="shareante" value="%{#session.oggetto.shareante}"/>
<s:textfield label="SharePost" name="sharepost" value="%{#session.oggetto.sharepost}"/>
<s:textfield label="ShareAvis" name="shareavis" value="%{#session.oggetto.shareavis}"/>
<s:textfield label="ShareHertz" name="sharehertz" value="%{#session.oggetto.sharehertz}"/>
<s:textfield label="ShareMaggiore" name="sharemaggiore" value="%{#session.oggetto.sharemaggiore}"/>
<s:textfield label="ShareSixt" name="sharesixt" value="%{#session.oggetto.sharesixt}"/>

<s:submit method="registraPrevisionale" value="Registra" ></s:submit>
<s:submit method="annulla" value="Annulla"></s:submit>
</div>
</s:form>
<s:if test="hasActionErrors()">
        <div class="errors">
            <s:actionerror />
        </div>
    </s:if>
</body>
</head>
</html>
