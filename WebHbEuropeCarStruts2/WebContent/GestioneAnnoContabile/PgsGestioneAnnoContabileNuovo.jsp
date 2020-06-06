<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<html>
<head>
<sx:head />
</head>
<title>PgsGestioneAnnoContabileNuovo</title>
<body>
	<s:form action="AnnoContabileAction">
		<s:label> Crea Anno Contabile: </s:label>
		<div align="center">
			<s:submit method="registraAnno" value="Registra"></s:submit>
			<s:submit method="annulla" value="Annulla"></s:submit>
		</div>
	</s:form>
</body>