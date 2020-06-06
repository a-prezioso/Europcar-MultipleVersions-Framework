<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PgsPianoInvestimentoGenera.jsp</title>
</head>
<body>
	<s:form action="GeneraPianoAction" theme="simple">
	<div align="center">
	<s:submit align="left" action="Main" value="Torna ad Home"></s:submit>
	<s:submit align="left" action="PianoInvestimentoAction" value="Indietro"></s:submit>
	
			</div>
	<h1>Genera Piano d'Investimento</h1>
	<br> <br>
	<s:if test="#session.ok">
		<b>Piano D'Investimento generato con successo! </b>
	</s:if>
	<br><br>
	
	<s:label><h2>Lista Piani D'Investimento: </h2></s:label>
	<br> Pagine totali:
			<s:property value="#session.pagine" />
			<br> Pagina corrente:
			<s:property value="#session.paginacorrente" />
	<s:if test="%{#session.listaanni.size()==0}">
	<h1>Non ci sono Piani</h1>
	</s:if>
	<s:else>
		<table border="1">
			<tr>
				<td></td>
				<td> Piano D'Investimento:  </td>
			</tr>
			<s:set name="varInizio" value="#session.inizio"></s:set>
					<s:set name="varFine" value="#session.fine"></s:set>
			<s:iterator  begin="#varInizio" end="#varFine" value="#session.listaanni">
				<tr>
					<td><input type="radio" name=idanno
								value="'<s:property value="idannocontabile"/>'" /></td>
					<td> <s:property value="descrizione"/> </td>
				</tr>
			</s:iterator>
		</table>
			<s:set name="varControlloindietro"
					value="#session.controlloindietro"></s:set>
				<s:if test="%{#varControlloindietro}">
					<s:submit align="center" method="prima" value="Prima" />
					<s:submit align="center" method="indietro" value="Indietro" />
				</s:if>

				<s:set name="varControllofine" value="#session.controllofine"></s:set>
				<s:if test="%{#varControllofine}">
					<s:submit align="center" method="execute" value="Avanti" />
					<s:submit align="center" method="ultima" value="Ultima" />
				</s:if> 
				<br><br>
		<s:submit align="center" method="generaPiano" value="Genera Piano"></s:submit>
	</s:else>
	</s:form>
	<s:if test="hasActionErrors()">
        <div class="errors">
            <s:actionerror />
        </div>
    </s:if>
</body>
</html>