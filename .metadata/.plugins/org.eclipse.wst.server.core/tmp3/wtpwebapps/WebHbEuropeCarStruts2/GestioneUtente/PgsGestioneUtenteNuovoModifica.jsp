<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>PgsGestioneUtenteNuovoModifica</title>
<body>
	<s:form action="UtenteAction" >
		<div align="center">
		<s:label> Modifica o Crea Utente: </s:label>
		</div>
			<s:if test="%{#session.oggetto2.isAdmin()}">
		<div align="center">
				<s:textfield label="Username" name="userv"
					value="%{#session.oggettou.username}"></s:textfield>

				<s:checkbox label="Admin" name="adminv"
					value="%{#session.oggettou.admin}"></s:checkbox>
				<s:set var="idvend"
					value="%{#session.oggettou.ovenditore.idvenditore}"></s:set>
				<s:select label="Venditore" name="idvenditore"
					list="#session.listavenditori" value="idvend"></s:select>
					
				<s:if test="%{#session.oggettou.idutente != 0}">
					<s:submit method="cambiaPassword" value="CambiaPassword"></s:submit>
				</s:if>
				<s:else>
				<s:password label="Inserire la Password" name="pwnuova1" value="%{#session.oggetto.password}"/>
				<s:password label="Reinserire la Password" name="pwnuova2" value="%{#session.oggetto.password}"/>
				</s:else>
				<s:submit method="registraUtente" value="Registra"></s:submit>
				<s:submit method="annulla" value="Annulla"></s:submit>
		</div>
			</s:if>
			
			
			<s:else>
		<div align="center">
				<s:textfield label="Username" name="userv"
					value="%{#session.oggettou.username}"></s:textfield>
				<s:submit method="cambiaPassword" value="CambiaPassword"></s:submit>
				<s:submit method="registraUtente" value="Registra"></s:submit>
				<s:submit method="annulla" value="Annulla"></s:submit>
				</div>
			</s:else>
	</s:form>
	<s:if test="hasActionErrors()">
        <div class="errors">
            <s:actionerror />
        </div>
    </s:if>
</body>