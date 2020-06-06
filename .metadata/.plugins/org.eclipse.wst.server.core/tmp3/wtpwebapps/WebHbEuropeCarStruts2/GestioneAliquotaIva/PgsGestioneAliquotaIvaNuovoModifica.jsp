<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="/struts-dojo-tags" prefix="d"%>  
<html>
	
	<head>
		<title>
			PgsAliquotaIvaNuovoModifica.jsp
		</title>
	</head>
	
	
	
		<h1>Modifica AliquotaIva</h1>
	
	<body>
	
	<s:form action="AliquotaIvaAct">
	
	<table>
	<tr>
	<s:textfield label="descrizione" name="descrizioneAli" value="%{#session.oggetto.descrizione}"/>
	</tr>
	<tr>
	<s:textfield label="aliquota" name="aliquotaAli" value="%{#session.oggetto.aliquota}"/>
	</tr>
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
