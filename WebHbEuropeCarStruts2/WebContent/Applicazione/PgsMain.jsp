<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib prefix="s" uri="/struts-tags"%>
<HTML>
<HEAD>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META name="GENERATOR" content="IBM WebSphere Studio">
<TITLE>PgsMain.jsp</TITLE>
</HEAD>
<BODY>

	<div align="center">
		<P align="center">
			<FONT size="+2" color="ff0000#">Menù</FONT><BR>
			<s:form action="Login">
				<table>
					<tr>
						<td><s:submit align="left" action="Login" value="Logout"></s:submit>
					</tr>					
				</table>
			</s:form>
			<s:form action="Main" theme="simple">
			<td><s:submit align="left" method="cambiaAnno"
								value="Cambia Anno Contabile"></s:submit></td>
				<table align="center">
					<s:if test="#session.oggetto2.isAdmin()">
						<s:iterator value="map">
							<tr>
								<td>
									<div align="left">
										<s:radio theme="simple" name="scelta" list="key, value"
											listKey="key" listValue="value" />
									</div>
								</td>
							</tr>
						</s:iterator>
					</s:if>
					<s:else>
						<s:iterator value="map2">
							<tr>
								<td>
									<div align="left">
										<s:radio theme="simple" name="scelta" list="key, value"
											listKey="key" listValue="value" />
									</div>
								</td>
							</tr>
						</s:iterator>
					</s:else>
				</table>
				<s:submit align="center" value="invio" />
			</s:form>
	</div>
</BODY>
</HTML>