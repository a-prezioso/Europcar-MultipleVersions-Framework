<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
	<head>
		<title>
			PgsRicercaFatturaPerSottoCategoria.jsp
		</title>
	</head>
	
	
		<h1>Cerca Fattura per SottoCategoria</h1>
		
		<body>
		<s:form action="SottoCategoriaFatAct" theme="simple">
		<br><br>
		<s:submit align="left" action="Main" value="Home"/>
		 <s:submit align="center" action="RicercaFatAct" value="indietro"/> &nbsp;&nbsp;&nbsp;&nbsp;	
		<br><br><br><br>
		<s:if test="%{#session.mappa==0}">
			Non ci sono SottoCategorie
			<br><br>
		</s:if>
		
		
		<s:else>
			<table>
			<tr>
			<s:select label="SottoCategoria" name="IDSottoCategoria" list="#session.mappa" value="%{#session.oggetto.ospesainvestimento.osottocategoria.idsottocategoria}"/>	</tr>
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