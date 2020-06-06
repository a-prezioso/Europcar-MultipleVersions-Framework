<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<title>PgsGestioneTipoVenditoreNuovoModifica</title>
<body>
<s:form action="VenditoreAction" >
<s:label> Crea Tipo Venditore: </s:label>
<div align ="center">
<s:textfield label="Tipo Venditore" name="tipov" value="%{#session.oggettotipo.tipovenditore}" ></s:textfield>
<s:submit method="registraTipoVenditore" value="Registra" ></s:submit>
<s:submit method="indietro" value="Annulla"></s:submit>
</div>
</s:form>
</body>
