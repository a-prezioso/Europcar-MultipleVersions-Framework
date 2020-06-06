<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<html>
<head>
<sx:head />
</head>
<meta charset="ISO-8859-1">
<title>PgsPianoInvestimentoCercaPerArea</title>

<body>
	<s:form action="ListaPianiAction" theme="simple">
		<s:submit align="left" action="Main" value="Torna ad Home"></s:submit>
		<div align="center">
			<s:set name="varElencoPiani" value="#session.listapiani"></s:set>
			<s:label><h1>Piani d'Investimento</h1></s:label>
			<s:if test="%{#varElencoPiani.size()==0}">
				<h1>Non ci sono Piani </h1>
			</s:if>
			<s:else>
			<table>
			<tr>
				<td>Area d'Investimento: </td>
				<td> <s:property value="#session.listaaree.area"/>  </td>
				<s:hidden name="idareainvestimento" value="#session.listaaree.idarea"></s:hidden>
			</tr>
			</table>
			<s:select label="SottoCategoria" name="idsottocategoria" list="#session.listasottocat" value="%{#session.oggetto.osottocategoria.sottocategoria}"/>

					<s:submit align="center" method="cercaPerAreaSottoCategoria" value="cerca"></s:submit>
					<table border="1">
			<tr>
				<td> Spesa Investimento </td>
				<td> Anno Contabile </td>
				<td> Area </td>
				<td> SottoCategoria </td>
				<td> Budget </td>
				<td> Budget Speso</td>
			</tr>
			<s:iterator value="#session.listapiani">
				<tr>
					<td> <s:property value="ospesainvestimento.spesainvestimento"/> </td>
					<td> <s:property value="oannocontabile.descrizione"/> </td>
					<td> <s:property value="ospesainvestimento.osottocategoria.oarea.area"/> </td>
					<td> <s:property value="ospesainvestimento.osottocategoria.sottocategoria"/> </td>
					<td> <s:property value="ospesainvestimento.osottocategoria.budget"/> </td>
					<td> <s:property value="ospesainvestimento.osottocategoria.budgetspeso"/> </td>
				</tr>
			</s:iterator>
		</table>

			</s:else>
		</div>
	</s:form>
</body>
</html>