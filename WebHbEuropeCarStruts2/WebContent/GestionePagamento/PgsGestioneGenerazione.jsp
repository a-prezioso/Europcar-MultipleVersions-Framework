<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PgsGestioneGenerazione.jsp</title>
<sx:head />
</head>
<body>

<s:form action="GenerazioneAction">
<s:submit align="center" method="chiudi" value="Chiudi" />
<table>
	<tr>
					<td><sx:datetimepicker label="DataInizio" name="datainizio" startDate="#session.datainizio" endDate="#session.datafine" value="#session.datainizio"
							displayFormat="dd-MMM-yyyy" /></td>
				</tr>
				<tr>
					<td><sx:datetimepicker label="DataFine" name="datafine" startDate="#session.datainizio" endDate="#session.datafine" value="#session.datafine"
							displayFormat="dd-MMM-yyyy" /></td>
				</tr>
</table>
<br><br>
<s:submit align="center" method="generazione" value="Genera Distinte" />

</s:form>
<s:if test="hasActionErrors()">
        <div class="errors">
            <s:actionerror />
        </div>
    </s:if>
</body>
</html>