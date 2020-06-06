
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PgsDefinzioneSpesaInvestimento</title>
</head>
<div align="center">
<h2>Definisci le spese d'investimento per il nuovo piano d'investimento</h2>
</div>
<style>
/* Split the screen in half */
.split {
	height: 100%;
	width: 50%;
	position: fixed;
	z-index: 1;
	top: -100px;
	overflow-x: hidden;
	padding-top: 20px;
}

/* Control the left side */
.left {
	left: 100px;
	
}

/* Control the right side */
.right {
	right: 100px;
	
}

/* If you want the content centered horizontally and vertically */
.centered {
	position: absolute; 
	left: 50%;
	transform: translate(-50%, -50%);
	text-align: center;
	top: 50%;
}


</style>

<body>
	<s:form action="DefinizionePianoAction" theme="simple">

	<br> <div class="centered" style="top: 30px; z-index: 4;">
		&nbsp;&nbsp;<br><br><br><br><br>
		<s:submit align="left" action="Main" value="Home" />&nbsp;<s:submit align="left" method="indietroSpesaInvestimento" value="Indietro" />&nbsp;
		</div><br>


		<div class="split left" style="z-index: 3;">
			<div class="centered">
				<table border="1">
					<tr>
						<td></td>
						<td>SpesaInvestimento</td>
						<td>SottoCategoria</td>
					</tr>

					<s:iterator value="#session.listaspeseinvestimento">
						<tr>
							<td><input id="idspesainvestimento" type="checkbox"  name="chiaveSpese"
								value="'<s:property value="idspesainvestimento"/>'"></td>
							<td><s:property value="spesainvestimento" /></td>
							<td><s:property value="osottocategoria.sottocategoria" /></td>
						</tr>
					</s:iterator>
				</table>
			</div>
		</div>
		<br>
		<br>



		<div class="split right" style="z-index: 3;">
			<div class="centered">
			<br><br><br><br><br><br><br><br>
			<a>Nuova SottoCategoria per la Spesa d'investimento</a><BR><BR><s:select name="chiavesottocategoria" list="#session.mapStocat" value="#session.oggetto"/>
			<br><br><br><br>
			<s:if test="#session.listaspeseinvestimentonuove.size()==0">
				<b>Non ci sono ancora Spese d'investimento in questo piano d'investimento</b>
			</s:if>
			<s:else>
				<table border="1">
					<tr>
					<td></td>
						<td>SpesaInvestimento</td>
						<td>SottoCategoria</td>
					</tr>

					<s:iterator value="#session.listaspeseinvestimentonuove">
						<tr>
							<td><input id="idspesainvestimento" type="checkbox" name="chiaveSpesenuove"
								value="'<s:property value="idspesainvestimento"/>'"></td>
							<td><s:property value="spesainvestimento" /></td>
							<td><s:property value="osottocategoria.sottocategoria" /></td>
						</tr>
					</s:iterator>
				</table>
				</s:else>
			</div>
		</div>
		<br>
		<br>
		<div class="centered" style="top: 350px; z-index: 4;"><s:submit type="image" align="left" method="definisciSpesa" src="aaa.jpg" /></div>
		<div class="centered" style="top: 450px; z-index: 4;"><s:submit type="image" align="left" method="togliDefinisciSpesa" src="bbb.jpg" /></div>
		 <br><br><div class="centered" style="top: 600px; z-index: 4;"><s:submit  align="left" method="rimuoviSpesa" value="Rimuovi" />&nbsp;&nbsp;&nbsp;
		<s:submit  align="left" method="salva" value="Salva" /></div>
		
	

	</s:form>
	<br><br><br><br><br><br><br><br><br><br><br>
	<s:if test="hasActionErrors()">
		<div class="errors">
			<s:actionerror />
		</div>
	</s:if>
</body>
</html>