<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
	<head>
		<title>
			PgsRicercaDistinte.jsp</title>
	</head>
		<h1>Cerca Distinte per Fatture</h1>
		
		<body>
		<s:form action="RicercaAction" theme="simple">
		<br><br>
		<s:submit align="left" action="Main" value="Home"/>
		<br><br>
		<s:submit align="left" action="GestioneAction" value="indietro"/>
		<br><br><br><br>
		<s:if test="%{#session.listafatture.size()==0}">
			Non ci sono Distinte
			<br><br>
		</s:if>

			<table>
			<tr>
			<td><s:select label="Fattura Passiva" name="idfatturapassiva" list="#session.listafatture" value="%{#pippo}"/></td></tr>
			<tr>
			</table>
		    <br><br>
		  <s:submit align="center" method="ricercaPerFatture" value="cerca"/> 

		</s:form>
			<s:if test="hasActionErrors()">
        <div class="errors">
            <s:actionerror />
        </div>
    </s:if>
		</body>
</html>