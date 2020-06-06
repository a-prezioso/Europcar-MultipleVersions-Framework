<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<html>
<head>
<sx:head />
<meta charset="ISO-8859-1">
<title>PgsGestioneImportaFatture</title>
</head>
<body>

<s:form action="ImportaFattureAction" method="POST" enctype="multipart/form-data" >
<br>  <s:submit align="left" action="Main" value="Home" /> <br>
<s:label> Gestione Importa Fatture: </s:label>
<div align ="center">

<sx:datetimepicker label="DataInizio" name="datainizio" displayFormat="dd-MMM-yyyy" />
<sx:datetimepicker label="DataFine" name="datafine" displayFormat="dd-MMM-yyyy" />
<s:file label="scegli il file" name="file"></s:file>
<s:if test="%{#session.messaggio.equalsIgnoreCase(null)}"></s:if>
<s:else><s:property value="%{#session.messaggio}"></s:property></s:else>
<s:if test="%{#!session.eccezione.equalsIgnoreCase(null)}"></s:if>
<s:else><s:property value="%{#session.eccezione}"/></s:else>
<s:submit method="salvaFattura" value="Importa"/>
</div>
</s:form>
	<s:if test="hasActionErrors()">
        <div class="errors">
            <s:actionerror />
        </div>
    </s:if>
</body>
</html>