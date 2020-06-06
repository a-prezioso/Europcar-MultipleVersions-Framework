
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PgsDefinzioneSottoCategoria</title>
</head>
<div align="center">
<h2>Definisci le sottocategorie per il nuovo piano d'investimento</h2>
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
		<s:submit align="left" action="Main" value="Home" />&nbsp;<s:submit align="left" method="indietroSottoCategoria" value="Indietro" />&nbsp;
		</div><br>
		

		<div class="split left" style="z-index: 3;">
			<div class="centered">
				<table border="1">
					<tr>
						<td></td>
						<td>Codice</td>
						<td>SottoCategoria</td>
						<td>Area</td>
					</tr>
					<s:iterator value="#session.listasottocategorie">
						<tr>
							<td><input id="idsottocategoria" type="checkbox" name="chiaveSottocategorie"
								value="'<s:property value="idsottocategoria"/>'"></td>
							<td><s:property value="codice" /></td>
							<td><s:property value="sottocategoria" /></td>
							<td><s:property value="oarea.area" /></td>
						</tr>
					</s:iterator>
				</table>
			</div>
		</div>


		<br>
		<br>



	



		<div class="split right" style="z-index: 3;">
			<div class="centered">
			<a>Nuova Area per la Sottocategoria</a><s:select name="chiavearea" list="#session.mapAree" value="#session.oggetto"/>
			<br><br><br><br>
			<s:if test="#session.listasottocategorienuove.size()==0">
			<b>Non ci sono ancora Sottocateogorie in questo piano d'investimento</b>
			</s:if>
			<s:else>
			
				<table border="1">
					<tr>
						<td></td>
						<td>Codice</td>
						<td>SottoCategoria</td>
						<td>Area</td>
					</tr>
					<s:iterator value="#session.listasottocategorienuove" >
						<tr>
							<td><input id="idsottocategoria" type="checkbox" name="chiaveSottocategorienuove"
								value="'<s:property value="idsottocategoria"/>'"></td>
							<td><s:property value="codice" /></td>
							<td><s:property value="sottocategoria" /></td>
							<td><s:property value="oarea.area" /></td>
						</tr>
					</s:iterator>
				</table>
				</s:else>
			</div>
		</div>
		<br>
		<br>
		<div class="centered" style="top: 350px; z-index: 4;"><s:submit type="image" align="left" method="definisciSottocategoria" src="aaa.jpg" /></div> <br><br>
		 <div class="centered" style="top: 450px; z-index: 4;"><s:submit type="image" align="left" method="togliDefinisciSottocategoria" src="bbb.jpg" /></div>
		<br><br><div class="centered" style="top: 600px;z-index: 4;"><s:submit align="left" value="Definisci Spese Investimento" method="definizioneSpesaInvestimento" />&nbsp;&nbsp;&nbsp;
		<s:submit  align="left" onclick="return deleteConfirm()" method="rimuoviSottoCategorie" value="Rimuovi" /> &nbsp;&nbsp;&nbsp;
 <s:submit  align="center" method="salva" value="Salva" /></div>
	
	</s:form>
	<script type="text/javascript">
				function deleteConfirm() {
					var elementsnuovi = document.getElementsByName("chiaveSottocategorienuove");
					var elementsvecchi = document.getElementsByName("chiaveSottocategorie");
					for (var i = 0; i < elementsnuovi.length; i++) {
						if (elementsnuovi[i].checked) {

							if (confirm("Eliminare tutte le spese investimento collegate a questa sottocategoria?")) {
								return true;
							} else {
								return false;
							}
						} else {
							if (i == elementsnuovi.length) {
								return true;
							}
						}
					} 
					for (var i = 0; i < elementsvecchi.length; i++) {
						if (elementsvecchi[i].checked) {

							if (confirm("Eliminare tutte le spese investimento collegate a questa sottocategoria?")) {
								return true;
							} else {
								return false;
							}
						} else {
							if (i == elementsvecchi.length) {
								return true;
							}
						}
					}
					
				}
			</script>
	 <br><br><br><br><br><br><br><br><br>
		<s:if test="hasActionErrors()">
		<div class="errors">
			<s:actionerror />
		</div>
	</s:if>

</body>
</html>