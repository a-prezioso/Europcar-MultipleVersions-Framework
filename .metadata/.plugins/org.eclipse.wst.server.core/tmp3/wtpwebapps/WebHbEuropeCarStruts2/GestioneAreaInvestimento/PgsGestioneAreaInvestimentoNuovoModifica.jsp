<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
	
	<head>
		<title>
			PgsAreaNuovoModifica.jsp
		</title>
	</head>
	
	
	
		<h1>Modifica Area</h1>
	
	<body>
	
	<s:form action="AreaInvestimentoAct">
	
	<table>
	<tr>
	<s:textfield label="codice" name="codice" value="%{#session.oggetto.codice}"/>
	</tr>
	<tr>
	<s:textfield label="area" name="area" value="%{#session.oggetto.area}"/>
	</tr>
	<tr>
	<s:select label="anno contabile" name="idannocontabile" list="#session.mappa" value="%{#session.oggetto.oannocontabile.idannocontabile}"/>
	</tr>
	</table>
	<br><br><br><br>
	<s:submit align="left" method="registra" value="registra"/>
	<s:submit align="left" method="annulla" value="annulla"/>
	</s:form>
	
	</body>
	
	<s:if test="hasActionErrors()">
        <div class="errors">
            <s:actionerror />
        </div>
    </s:if>
	
		
</html>
