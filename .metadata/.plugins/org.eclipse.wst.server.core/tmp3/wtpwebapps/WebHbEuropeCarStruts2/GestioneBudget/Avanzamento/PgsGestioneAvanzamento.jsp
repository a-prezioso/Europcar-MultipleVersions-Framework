<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<html>
<head>
<title>PgsGestioneAvanzamentot.jsp</title>
<sx:head />
</head>
<h1>Cerca SottoCategorie per Area:</h1>

<body>
	<s:form action="AvanzamentoAction" theme="simple">
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

		<s:if test="%{#session.listaaree.size()==0}">
			Non ci sono Aree
			<br>
			<br>

		</s:if>

		<s:else>
			<table>
				<tr>
					<s:select label="Area" name="idarea" list="#session.listaaree"
						value="%{#session.oggettoarea.idarea}" />
				</tr>
				<tr>
					<td><sx:datetimepicker label="DataInizio" name="datainizio"
							displayFormat="dd-MMM-yyyy" startDate="%{#session.datain}" endDate="%{#session.datafi}" value="%{#session.datain}"/></td>
				</tr>
				<tr>
					<td><sx:datetimepicker label="DataFine" name="datafine"
							displayFormat="dd-MMM-yyyy" startDate="%{#session.datain}" endDate="%{#session.datafi}" value="%{#session.datafi}" /></td>
				</tr>

			</table>
			<br>
			<br>
	
		  <s:submit align="center" method="avanzamento" value="cerca" />
		</s:else>
	</s:form>
	<s:if test="hasActionErrors()">
        <div class="errors">
            <s:actionerror />
        </div>
    </s:if>
</body>


</html>