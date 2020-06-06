<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
	
	<head>
		<title>
			PgsDefinizioneBudgetSottoCategoria.jsp
		</title>
	</head>
	
	
	
		<h1>Definizione del Budget</h1>
	
	<body>
	
	<s:form action="DefinizioneAction">
	
	<table>
	<tr>
	<s:textfield disabled="true" label="Area" name="idarea" value="%{#session.oggettoarea.area}"/>
	</tr>
	<tr>
	<s:textfield label="SottoCategoria" disabled="true" name="chiave"  value="%{#session.oggettosottocategoria.sottocategoria}"/>
	</tr>
	<tr>
	<s:textfield label="Budget" name="budjetvar"  value="%{#session.oggettosottocategoria.budget}"/>	</tr>
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


