<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<html>
<head>
<title>PgsDefinizioneBudget.jsp</title>
<sx:head />
</head>
<h1>Cerca SottoCategorie per Anni:</h1>

<body>
	<s:form action="RiconciliazioneAction" theme="simple">
		<br>
		<br>
		<s:submit align="left" action="Main" value="Home" />
		<br>
		<br>
		<br>
		<br>

		<s:if test="%{#session.listaanni.size()==0}">
			Non ci sono Anni Contabili
			<br>
			<br>

		</s:if>

		<s:else>
			<s:select label="Anno Contabile" name="idannocontabile" list="#session.listaanni" value="%{#session.oggetto.oannocontabile.idannocontabile}"/>	
			<br><br>

		  <s:submit align="center" method="cerca" value="cerca" />
		</s:else>
	</s:form>
</body>


</html>