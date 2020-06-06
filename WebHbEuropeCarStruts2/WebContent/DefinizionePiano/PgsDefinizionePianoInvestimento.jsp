<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
    <%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PgsDefinzionePianoInvestimento</title>

</head>
<sj:head/>
<h1> Definizione piano d'investimento</h1>
<body>
<s:form action="DefinizionePianoAction" theme="simple">
		
	<br><br><s:submit align="left" action="Main" value="Home"/><br><br>
	<s:if test="%{#session.listapiani.size()==0}">
			Non ci sono piani d'investimento
			<br><br>
		</s:if>
		<s:else>
		<p>Seleziona un piano d'investimento da cui partire</p>
		<s:select align="center" label="Piani d'Investimento" name="pianovecchio" list="#session.listapiani" value="0"/>
		<br><br>
		<p>Seleziona un piano d'investimento da definire</p>
		<s:select align="center" label="Piani d'Investimento" name="pianodadefinire" list="#session.listapiani" value="0"/>

		    <br><br>
		  <s:submit align="center" method="definizione" value="Definizione Piano"/> 
		</s:else>

</s:form>
	<s:if test="hasActionErrors()">
		<div class="errors">
			<s:actionerror />
		</div>
	</s:if>
</body>
</html>