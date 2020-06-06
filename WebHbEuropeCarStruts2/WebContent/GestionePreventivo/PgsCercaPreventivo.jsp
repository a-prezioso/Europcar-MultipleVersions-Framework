<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
	<head>
		<title>
			PgsGestionePreventivo.jsp
		</title>
	</head>
	
	
		<h1>Cerca Preventivo per Fornitore</h1>
		
		<body>
		<s:form action="PreventivoAct" theme="simple">
		<br><br>
		<s:submit align="left" action="Main" value="Home"/>
		<br><br><br><br>
		<s:if test="%{#session.mappa.size()==0}">
			Non ci sono Fornitori
			<br><br>
		</s:if>
		
		
		<s:else>
			<table>
			<tr>
			<s:select label="Fornitore" name="IDFornitore" list="#session.mappa" value="%{#session.oggetto.ofornitore.idfornitore}"/>	</tr>
			</table>
		    <br><br>

		  <s:submit align="center" method="cerca" value="cerca"/>
		</s:else>
		</s:form>
	
		</body>
	<s:if test="hasActionErrors()">
        <div class="errors">
            <s:actionerror />
        </div>
    </s:if>
	
</html>