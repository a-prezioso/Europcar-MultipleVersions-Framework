<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib prefix="s" uri="/struts-tags" %>
<HTML>
<HEAD>
<%@ page 
language="java"
contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"
%>

<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META name="GENERATOR" content="IBM WebSphere Studio">
<TITLE>PgsGestionePagamentoMain.jsp</TITLE>
</HEAD>
<BODY>
<div align="center">

<P align="center"> <FONT size="+2" color="ff0000#">Menù</FONT><BR>

<s:form action="GestioneAction">
	<br>
		<s:submit align="center" action="Main" value="Home"/>
		<s:submit align="center" action="MessaInPagamentoAction" value="Chiudi"/>
		<br>
<DIV align="center">
<TABLE align="center">
 <TBODY>
  <TR>

   <TD><s:iterator value="map"><div align="left"><s:radio theme="simple" name="scelta" list="key, value" listKey="key" listValue="value"/><br/> </div> </s:iterator></TD>
   </TR>
 </TBODY>   
</TABLE>
<BR>
<s:submit align="center" value="invio"/>
</DIV>
</s:form>
<DIV ALIGN="center"><br>
</div>
</div>
</BODY>
</HTML>