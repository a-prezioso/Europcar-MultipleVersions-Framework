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
<TITLE>PgsRicercaFattura.jsp</TITLE>
</HEAD>
<BODY>
<div align="center">

<P align="center"> <FONT size="+2" color="ff0000#">Menù</FONT><BR>

<s:form action="RicercaFatAct">
	<br>
		<s:submit align="left" action="Main" value="Home"/>
		<s:submit align="left" action="FatturaPassivaAct" value="Indietro"/>
		<br>
<DIV align="center">
<TABLE>
 <TBODY>
  <TR>
   <TD><s:radio name="scelta" list="map"/></TD>
   </TR>
 </TBODY>   
</TABLE>
<BR>
<s:submit align="center" value="invio"/>
</DIV>
</s:form>

</div>
</BODY>
</HTML>