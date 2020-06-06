<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
	
	<head>
		<title>
			PgsSottoCategoriaNuovoModifica.jsp
		</title>
	</head>
	
	
	
		<h1>Modifica SottoCategoria</h1>
	
	<body>
	
	<s:form action="SottoCategoriaAct">
	
	<table>
	<tr>
	<s:textfield label="Codice" name="codice" value="%{#session.oggetto.codice}"/>
	</tr>
	<tr>
	<s:textfield label="SottoCategoria" name="sottocategoria" value="%{#session.oggetto.sottocategoria}"/>
	</tr>
	<tr>
	<s:select label="Area" name="IDArea" list="#session.mappa" value="%{#session.oggetto.oarea.idarea}"/>	</tr>
	</table>
	<br><br><br><br>
	<s:submit align="left" method="registra" value="registra"/>
	<s:submit align="left" method="annulla" value="annulla"/>
	</s:form>
	
	<s:if test="hasActionErrors()">
        <div class="errors">
            <s:actionerror />
        </div>
    </s:if>
	
	</body>
		
</html>


