<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<html>
<head>
<sx:head />
</head>
<title>PgsGestionePrevisionaleNuovoModifica</title>
<body>
<s:form action="VenditoreAction" >
<s:label> Nuovo o modifica Previsione: </s:label>
<div align ="center">
<table>
<tr>
	<td>Venditore</td>
</tr>
<tr>
	<td><s:property value="#session.oggetto.cognome"/><s:property value="#session.oggetto.nome"/></td>
</tr>
</table>
<table align="center">
<s:set var="idareavar" value="#session.oggettopr.oarea.idarea"/>
<tr><s:select label="Area Geografica" name="idarea" list="#session.listaaree" value="#idareavar"/></tr>
<s:set var="idaziendavar" value="#session.oggettopr.oazienda.idazienda"/>
<tr><s:select label="Azienda" name="idazienda" list="#session.listaaziende" value="#idaziendavar"/></tr>
<s:set var="idsottocatvar" value="#session.oggettopr.osottocategoria.idsottocategoria"/>
<tr><s:select label="SottoCateogoria" name="idsottocategoria" list="#session.listasottocategorie" value="#idsottocatvar"/></tr>
<sx:datetimepicker label="DataVisita" name="datavisita" displayFormat="dd-MMM-yyyy" startDate="#session.datain" endDate="#session.datafi" value="#session.datain"/>

<sx:datetimepicker label="AnnoDiRiferimento" name="annodiriferimento" displayFormat="dd-MMM-yyyy" startDate="#session.datain" endDate="#session.datafi" value="#session.datain"/>

<sx:datetimepicker label="DataRegistrazione" name="dataregistrazione" displayFormat="dd-MMM-yyyy" startDate="#session.datain" endDate="#session.datafi" value="#session.datain"/>
<tr><s:textfield label="Confidenza" name="confidenza" value="%{#session.oggettopr.confidenza}"/></tr>
<tr><s:textfield label="PotenzialeEuropeCar" name="potenzialeeuropecar" value="%{#session.oggettopr.potenzialeeuropecar}"/></tr>
<tr><s:textfield label="PotenzialeAzienda" name="potenzialeazienda" value="%{#session.oggettopr.potenzialeazienda}"/></tr>
<tr><s:textfield label="ShareAnte" name="shareante" value="%{#session.oggettopr.shareante}"/></tr>
<tr><s:textfield label="SharePost" name="sharepost" value="%{#session.oggettopr.sharepost}"/></tr>
<tr><s:textfield label="ShareAvis" name="shareavis" value="%{#session.oggettopr.shareavis}"/></tr>
<tr><s:textfield label="ShareHertz" name="sharehertz" value="%{#session.oggettopr.sharehertz}"/></tr>
<tr><s:textfield label="ShareMaggiore" name="sharemaggiore" value="%{#session.oggettopr.sharemaggiore}"/></tr>
<tr><s:textfield label="ShareSixt" name="sharesixt" value="%{#session.oggettopr.sharesixt}"/></tr>
</table>
<s:submit align="center" method="registraPrevisionale" value="Registra" ></s:submit>
<s:submit align="center" method="annullaPrev" value="Annulla"></s:submit>
</div>
</s:form>
	<s:if test="hasActionErrors()">
        <div class="errors">
            <s:actionerror />
        </div>
    </s:if>
    <br><br>
</body>
</html>
