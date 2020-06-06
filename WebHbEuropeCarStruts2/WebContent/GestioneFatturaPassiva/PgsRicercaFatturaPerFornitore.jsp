<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
	<head>
		<title>
			PgsRicercaFatturaPerFornitore.jsp
		</title>
	</head>
	
	
		<h1>Cerca Fattura per Fornitore</h1>
		
		<body>
		<s:form action="FornitoreFatAct" theme="simple">
		<br><br>
		<s:submit align="left" action="Main" value="Home"/>
		<s:submit align="center" action="RicercaFatAct" value="indietro"/> 
		<br><br><br><br>
		<s:if test="%{#session.mappa==0}">
			Non ci sono Fornitori
			<br><br>
		</s:if>
		
		
		<s:else>
			<table>
			<tr>
			<s:select label="Fornitore" name="IDFornitore" list="#session.mappa" value="%{#session.oggetto.ofatturapassiva.ofornitore.idfornitore}"/>	</tr>
			</table>
		    <br><br>
		  <s:submit align="center" method="cerca" value="cerca"/>
		 
		</s:else>
		</s:form>
	<s:if test="hasActionErrors()">
        <div class="errors">
            <s:actionerror />
        </div>
    </s:if>
		</body>
	
	
</html>