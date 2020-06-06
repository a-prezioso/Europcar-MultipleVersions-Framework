<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
<title>PgsGestionePrevisionaleRicerca.jsp</title>
</head>
<h1>Cerca Previsionale per Fornitore</h1>

<body>
	<s:form action="PrevisionaleAction" theme="simple">
		<br>
		<br>
		<div align="center">
			<s:submit align="left" action="Main" value="Home" />
			<br>
			<br>
			<br>
			<br>
			<s:submit align="left" method="cambiaAnno"
				value="Cambia Anno Contabile"></s:submit>
			
		</div>
		<br>
		<s:if test="%{#session.listavenditori.size()==0}">
			Non ci sono Venditori
			<br>
			<br>
		</s:if>
		<s:else>
		<div align="center">
		<s:select label="Venditore" name="idvenditore"
			list="#session.listavenditori"
			value="%{#session.oggetto.ovenditore.idvenditore}" />
		<br>
		<br>

		<br>
		<br>
		<s:submit align="center" method="ricercaPerVenditore" value="cerca" />
		</div>
	</s:else>
	</s:form>
	<s:if test="hasActionErrors()">
		<div class="errors">
			<s:actionerror />
		</div>
	</s:if>

</body>


</html>