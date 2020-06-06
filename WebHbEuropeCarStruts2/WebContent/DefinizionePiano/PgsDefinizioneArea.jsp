<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PgsDefinzioneArea</title>
</head>
<div align="center">
<h2>Definisci le aree per il nuovo piano d'investimento</h2>
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
 left: 10px;
}

/* Control the right side */
.right {
 right: 10px;
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

   <div class="centered" style="top: 30px; z-index: 4;">
  &nbsp;&nbsp;<br><br><br><br><br><s:submit align="left" action="Main" value="Home" />&nbsp;<s:submit align="left" action="DefinizionePianoAction" value="Indietro" />
  </div><br>


  <div class="split left" style="z-index: 3;">
   <div class="centered">
    <table border="1">
     <tr>
      <td></td>
      <td>Codice</td>
      <td>Area</td>
      <td>Anno Contabile</td>
     </tr>

     <s:iterator value="#session.listaaree" >
      <tr>
       <td><input id="idarea" type="checkbox"
        name="chiaveAree"  value="'<s:property value="idarea"/>'"></td>
        
       <td><s:property value="codice" /></td>
       <td><s:property value="area" /></td>
       <td><s:property value="oannocontabile.descrizione" /></td>
      </tr>
     </s:iterator>
    </table>
   </div>
  </div>


  <br>
  <br>



 
  <div class="split right" style="z-index: 3;">
   <div class="centered">
    <s:if test="#session.listaareenuove.size()==0">
 	 <b>Non ci sono ancora Aree in questo piano d'investimento</b>
  </s:if>
  <s:else>
    <table border="1">
     <tr>
	  <td></td>
      <td>Codice</td>
      <td>Area</td>
      <td>Anno Contabile</td>
     </tr>

     <s:iterator value="#session.listaareenuove" >
      <tr>
		<td><input id="idarea" type="checkbox"
        name="chiaveAreeNuove" value="'<s:property value="idarea"/>'"></td>
       <td><s:property value="codice" /></td>
       <td><s:property value="area" /></td>
       <td><s:property value="oannocontabile.descrizione" /></td>
      </tr>
     </s:iterator>
    </table>
    </s:else>
   </div>
  </div>
  
  <br>
  <br>
 
 <div class="centered" style="top: 350px; z-index: 4;"><s:submit type="image" align="left" method="definisciAree" src="aaa.jpg" /></div><br><br>
 <div class="centered" style="top: 450px; z-index: 4;"><s:submit type="image" align="left" method="togliDefinisciAree" src="bbb.jpg" /></div>
  <br><br><div class="centered" style="top: 600px; z-index: 4;"><s:submit align="left" value="Definisci SottoCategorie" method="definizioneSottoCategoria" />&nbsp;&nbsp;&nbsp;
 <s:submit  align="left" onclick="return deleteConfirm()" method="rimuoviAree" value="Rimuovi" /> &nbsp;&nbsp;&nbsp;
 <s:submit  align="center" method="salva" value="Salva" /></div>

 </s:form>
 			<script type="text/javascript">
				function deleteConfirm() {
					var elementsnuovi = document.getElementsByName("chiaveAreeNuove");
					var elementsvecchi = document.getElementsByName("chiaveAree");
					for (var i = 0; i < elementsnuovi.length; i++) {
						if (elementsnuovi[i].checked) {

							if (confirm("Eliminare tutte le sottocategorie e le spese investimento collegate a quest'area?")) {
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
					for (var i = 0; i < elementsnuovi.length; i++) {
						if (elementsnuovi[i].checked) {

							if (confirm("Eliminare tutte le sottocategorie e le spese investimento collegate a quest'area?")) {
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