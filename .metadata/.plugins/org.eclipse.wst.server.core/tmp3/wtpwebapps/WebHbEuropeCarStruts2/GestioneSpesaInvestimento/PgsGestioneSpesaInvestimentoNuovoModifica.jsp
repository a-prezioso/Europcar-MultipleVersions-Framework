<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
	
	<head>
		<title>
			PgsSpesaInvestimentoNuovoModifica.jsp
		</title>
	</head>
	
	
		<s:if test="#session.oggettospesa.idspesainvestimento!=0">
		<h1> Modifica SpesaInvestimento</h1>
		</s:if>
		<s:else> <h1>Nuova SpesaInvestimento</h1></s:else>
	<body>
	
	<s:form action="SpesaInvestimentoAction">
	
	<table>
	<tr>
	<s:if test="#session.oggettospesa.idspesainvestimento!=0">
	<s:textfield disabled="true" label="Sottocategoria" name="idsottocategoria" value="%{#session.oggettosottocategoria.sottocategoria}"></s:textfield>
	</s:if>
	<s:else>
	<s:select label="SottoCategoria" name="idsottocategoria" list="#session.listasottocategorie" value="%{#session.oggettospesa.osottocategoria.idsottocategoria}"/>
	</s:else>
	</tr>
	<tr>
	<s:textfield label="SpesaInvestimento" name="spesainvvar" value="%{#session.oggettospesa.spesainvestimento}"/>
	</tr>
	<tr>
	</tr>
	</table>
	<br><br><br><br>
	<s:submit align="left" method="registraSpesaInvestimento" value="registra"/>
	<s:submit align="left" method="annulla" value="annulla"/>
	</s:form>
			<s:if test="hasActionErrors()">
        <div class="errors">
            <s:actionerror />
        </div>
    </s:if>
	</body>
	
		
	
		
</html>


