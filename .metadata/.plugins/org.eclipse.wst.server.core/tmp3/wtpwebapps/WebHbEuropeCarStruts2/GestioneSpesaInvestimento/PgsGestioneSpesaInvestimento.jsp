<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
	<head>
		<title>
			PgsGestioneSpesaInvestimento.jsp
		</title>
	</head>
	
	
		<h1>Cerca SpesaInvestimento per SottoCategoria</h1>
		
		<body>
		<s:form action="SpesaInvestimentoAction" theme="simple">
		<br><br>
		<s:submit align="left" action="Main" value="Home"/>
		<s:submit align="left" action="BudgetAct" value="Indietro" />
		<br><br><br><br>
		<s:if test="%{#session.listasottocategorie.size()==0}">
			Non ci sono SottoCategorie
			<br><br>
		</s:if>
		
		
		<s:else>
		<br><br>
			<table>
			<tr>
			<s:select label="SottoCategoria" name="idsottocategoria" list="#session.listasottocategorie" value="%{#session.oggetto.osottocategoria.idsottocategoria}"/>	</tr>
			</table>
		    <br><br>

		  <s:submit align="center" method="cerca" value="cerca"/> 
		</s:else>
		</s:form>
			<s:if test="hasActionErrors()">
        <div class="errors">
            <s:actionerror />
        </div>
    </s:if>
		</body>
	
	
</html>