<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
<title>PgsDefinizioneBudget.jsp</title>
</head>
<h1>Cerca SottoCategorie per Area: </h1>

<body>
	<s:form action="DefinizioneAction" theme="simple">
		<br>
		<br>
		<s:submit align="left" action="Main" value="Home" />
		<s:submit align="left" method="cambiaAnno"
								value="Cambia Anno Contabile"></s:submit>
		<s:submit align="left" action="BudgetAct" value="Indietro" />
		<br>
		<br>
		<br>
		<br>
	
			<s:if test="%{#session.listaaree==0}">
			Non ci sono aree
			<br>
				<br>
	
		</s:if>

		<s:else>
			<table>
				<tr>
					<s:select label="Area" name="idarea" list="#session.listaaree" value="%{#session.oggetto.oarea.idarea}" />
				</tr>
			</table>
			<br>
			<br>
		  <s:submit align="center" method="cercaSottoCategoriePerArea" value="cerca" /> 
		</s:else>
		
	</s:form>
	<s:if test="hasActionErrors()">
        <div class="errors">
            <s:actionerror />
        </div>
    </s:if>
</body>


</html>