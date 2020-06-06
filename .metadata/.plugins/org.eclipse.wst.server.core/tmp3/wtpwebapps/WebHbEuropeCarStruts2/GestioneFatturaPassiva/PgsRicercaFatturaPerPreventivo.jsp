<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
	<head>
		<title>
			PgsRicercaFatturaPerPreventivo.jsp
		</title>
	</head>
	
	
		<h1>Cerca Fattura per Preventivo</h1>
		
		<body>
		<s:form action="PreventivoFatAct" theme="simple">
		<br><br>
		<s:submit align="left" action="Main" value="Home"/>
		 <s:submit align="center" action="RicercaFatAct" value="indietro"/> &nbsp;&nbsp;&nbsp;&nbsp;	
		<br><br><br><br>
		<s:if test="%{#session.mappa==0}">
			Non ci sono Preventivi
			<br><br>
		</s:if>
		
		
		<s:else>
			<table>
			<tr>
			<s:select label="Preventivo" name="IDPreventivo" list="#session.mappa" value="%{#session.oggetto.opreventivo.idpreventivo}"/>	</tr>
			</table>
		    <br><br>
		  &nbsp;&nbsp;&nbsp;&nbsp; 
		  <s:submit align="center" method="cerca" value="cerca"/> &nbsp;&nbsp;&nbsp;&nbsp;	
		 
		</s:else>
		</s:form>
	<s:if test="hasActionErrors()">
        <div class="errors">
            <s:actionerror />
        </div>
    </s:if>
		</body>
	
	
</html>