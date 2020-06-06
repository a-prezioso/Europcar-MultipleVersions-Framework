<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PgsLogin.jsp</title>
</head>

<body>

<s:form action="Login" theme="simple">
<div align="center">
<br><br><br><br>
<h1> Gestione Login</h1><br>
  <table border="1">
   <tr>
    <td><s:textfield label="Username" name="user" value="%{#session.oggetto2.username}"></s:textfield></td>
   </tr> 
   <tr>
    <td><s:password label="Password" name="pw" value="%{#session.oggetto2.password}"></s:password></td>
   </tr>
</table> <br>
<s:submit method="login" align="left" value="invio" />
</div>
</s:form>

<s:if test="hasActionErrors()">
        <div class="errors">
            <s:actionerror />
        </div>
    </s:if>

</body>
</html>