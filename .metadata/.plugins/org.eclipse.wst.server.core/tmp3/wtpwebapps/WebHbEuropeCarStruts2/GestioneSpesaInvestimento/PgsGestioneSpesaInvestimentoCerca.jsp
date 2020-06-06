<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
<title>PgsGestioneSpesaInvestimentoCerca.jsp</title>
</head>


<h1>Gestione SpeseInvestimento</h1>

<body>
	<s:form action="SpesaInvestimentoAction" theme="simple">
		<br>
		<br>
		<div align="center">
			<s:submit align="left" action="Main" value="Home" />
			<s:submit align="left" action="SpesaInvestimentoAction"
				value="Indietro" />
			<br>
			<br>
			<br>
			<br> <br> Pagine totali:
			<s:property value="#session.pagine" />
			<br> Pagina corrente:
			<s:property value="#session.paginacorrente" />
		<br>
		<s:if test="%{#session.listaspese.size()==0}">
			Non ci sono SpeseInvestimento per questa SottoCategoria
			<br>
			<br>
			<s:submit method="nuovaSpesaInvestimento" value="nuovo" /> 
			<s:submit action="SpesaInvestimentoAction" value="annulla" /> 
		</s:if>

</div>
		<s:else>
		<br><br>
		<div align="center">
			<s:select label="SottoCategoria" name="idsottocategoria"
				list="#session.listasottocategorie"
				value="%{#session.oggetto.osottocategoria.idsottocategoria}" />
			<s:submit align="center" method="cerca" value="cerca"></s:submit>
			<table border="1">
				<tr>
					<td></td>
					<td>SpesaInvestimento</td>
					<td>SottoCategoria</td>
				</tr>
				<s:set name="varInizio" value="#session.inizio"></s:set>
				<s:set name="varFine" value="#session.fine"></s:set>

				<s:iterator begin="#varInizio" end="#varFine" value="#session.listaspese">
					<tr>
						<td><input type="radio" name="chiave"
							value="'<s:property value="idspesainvestimento"/>'"></td>
						<td><s:property value="spesainvestimento" /></td>
						<td><s:property value="osottocategoria.sottocategoria" /></td>
					</tr>
				</s:iterator>
			</table>
			<br>
			<br>
			
		   <s:submit align="center" method="nuovaSpesaInvestimento" value="nuova" />
			<s:submit align="center" method="modificaSpesaInvestimento" value="modifica" /> 
			 <s:submit align="center" onclick="return deleteConfirm()"
				method="eliminaSpesaInvestimento" value="elimina" /> 
					<s:set name="varControlloindietro"
					value="#session.controlloindietro"></s:set>
				<s:if test="%{#varControlloindietro}">
					<s:submit align="center" method="prima" value="Prima" />
					<s:submit align="center" method="indietro" value="Indietro" />
				</s:if>

				<s:set name="varControllofine" value="#session.controllofine"></s:set>
				<s:if test="%{#varControllofine}">
					<s:submit align="center" method="avanti" value="Avanti" />
					<s:submit align="center" method="ultima" value="Ultima" />
				</s:if>
				</div>
			<script type="text/javascript">
					function deleteConfirm() {
					var elements = document.getElementsByName("chiave");
					for(var i = 0; i < elements.length; i++) {
						if (elements[i].checked) {
						if (confirm("Eliminare la spesa d'investimento selezionata?")) {
							return true; 
							} else {
								return false;
							} 
						} else {
							if(i == elements.length) {
								return true;
							}		
						} 
					} }
				</script>
				
		</s:else>
	</s:form>
	<s:if test="hasActionErrors()">
		<div class="errors">
			<s:actionerror />
		</div>
	</s:if>
</body>


</html>