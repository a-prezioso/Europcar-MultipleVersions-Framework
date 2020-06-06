<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<title>PgsCambioPassword</title>
<body>
<s:form action="UtenteAction" >
<s:label> Modifica  Password: </s:label>
<div align ="center">
<s:password label="Inserire la vecchia Password" name="pwvecchia" value="%{#session.oggetto.password}"/>
<s:password label="Inserire la nuova Password" name="pwnuova1" value="%{#session.oggetto.password}"/>
<s:password label="Reinserire la nuova Password" name="pwnuova2" value="%{#session.oggetto.password}"/>
<s:submit method="registraPassword" value="Registra" ></s:submit>
<s:submit method="annulla" value="Annulla"></s:submit>
</div>
</s:form>
<s:if test="hasActionErrors()">
        <div class="errors">
            <s:actionerror />
        </div>
    </s:if>
</body>
</html>