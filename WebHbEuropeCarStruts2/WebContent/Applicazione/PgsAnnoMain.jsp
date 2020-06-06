<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
	<head>
		<title>
			PgsAnnoMain.jsp
		</title>
	</head>
	
	
		
		
		<body>
		<s:form action="selectAnno" theme="simple">
		<div align="center">
			<br><br>
		<h1>Seleziona Anno Contabile</h1>
	
		<br><br><br><br>
		<s:if test="%{#session.listaanni.size()==0}">
			Non ci sono Anni Contabili
			<br><br>
		</s:if>
		
		
		<s:else>
		
			<table>
			<tr>
			<s:select label="Anno Contabile" name="chiave" list="#session.listaanni" value="%{#session.oggettoanno.idannocontabile}"/>	</tr>
			</table>
		    <br><br>
		  <s:submit align="center" method="selezioneAnno" value="vai"/>
		</s:else>
		</div>
		</s:form>
	<s:if test="hasActionErrors()">
        <div class="errors">
            <s:actionerror />
        </div>
    </s:if>
	
		</body>
</html>