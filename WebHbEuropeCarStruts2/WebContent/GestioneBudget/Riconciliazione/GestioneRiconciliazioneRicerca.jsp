<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<html>
<head>
<title>PgsGestioneRiconciliazione.jsp</title>
<sx:head />
</head>


<h1>Riconciliazione Budget</h1>

<body>
	<s:form action="RiconciliazioneAction" theme="simple">
		<br>
		<br>
		<s:submit align="left" action="Main" value="Home" />
		<br>
		<br>
		<br>
		<br>
		<s:if test="%{#session.listasottocategoria.size()==0}">
			Non ci sono SottoCategorie per quest'Anno Contabile
			<br>
			<br>
		</s:if>


		<s:else>
			<table>
				<tr>
					<s:select label="SottoCategoria" name="idsottocategoria"
						list="#session.listasottocategoria"
						value="%{#session.oggettosottocategoria.idsottocategoria}" />
				</tr>
				<tr>
					<td><sx:datetimepicker label="DataInizio" name="datainizio" displayFormat="dd-MMM-yyyy"  startDate="%{#session.datainizio}" endDate="%{#session.datafine}" value="%{#session.datainizio}"/></td>
				</tr>
				<tr>
					<td><sx:datetimepicker label="DataFine" name="datafine" displayFormat="dd-MMM-yyyy" startDate="%{#session.datainizio}" endDate="%{#session.datafine}" value="%{#session.datafine}"/></td>
				</tr>

			</table>
			<br>
			<br>
		    
		  &nbsp;&nbsp;&nbsp;&nbsp; 
		  <s:submit align="center" method="riconciliazione" value="riconcilia" /> &nbsp;&nbsp;&nbsp;&nbsp;	
		   <s:submit align="center" method="annulla" value="chiudi" /> &nbsp;&nbsp;&nbsp;&nbsp;
		</s:else>
	</s:form>

</body>


</html>