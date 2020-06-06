<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
<title>PgsRicercaPianoPerArea.jsp</title>
</head>

<div align="center">
	<h1>Ricerca Piani D'Investimento:</h1>
</div>
<body>
	<s:form action="ListaPianiAction" theme="simple">
		<br>
		<table align="center">
			<tr>
				<td><s:submit align="center" action="Main" value="Home" /></td>
				<td><s:submit align="left" action="PianoInvestimentoAction"
						value="Indietro"></s:submit></td>
			</tr>
		</table>
		<br>
		<s:if test="%{#session.listaanni.size()==0}">
			Non ci sono Piani D'Investimento
			<br>
			<br>
		</s:if>
		<s:else>
			<table>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td>

						<table border="1" align="center">
							<td colspan="2"><br> Pagine totali: <s:property
									value="#session.pagineAnno" /> <br> Pagina corrente: <s:property
									value="#session.paginacorrenteAnno" /></td>
							<tr>
								<td></td>
								<td>Piano D'Investimento:</td>
								<s:set name="varInizioAnno" value="#session.inizioAnno"></s:set>
								<s:set name="varFineAnno" value="#session.fineAnno"></s:set>
								<s:iterator begin="#varInizioAnno" end="#varFineAnno"
									value="#session.listaanni">
									<tr>
										<td><input type="radio" name=chiave
											value="'<s:property value="idannocontabile"/>'" /></td>
										<td><s:property value="descrizione" /></td>
									</tr>
								</s:iterator>
						</table> <br> <s:submit align="center" method="ispezioneAnno"
							value="Ispeziona Piano" /> <br> <br> <s:set
							name="varControlloindietroAnno"
							value="#session.controlloindietroAnno"></s:set> <s:if
							test="%{#varControlloindietroAnno}">
							<s:submit align="center" method="primaAnno" value="Prima" />
							<s:submit align="center" method="indietroAnno" value="Indietro" />
						</s:if> <s:set name="varControllofineAnno"
							value="#session.controllofineAnno"></s:set> <s:if
							test="%{#varControllofineAnno}">
							<br>
							<br>
							<s:submit align="center" method="avantiAnno" value="Avanti" />
							<s:submit align="center" method="ultimaAnno" value="Ultima" />
						</s:if>
					</td>
					<br>
					<br>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<s:if test="%{#session.checkarea}">
						<br>
						<br>
						<table>
							<tr>
								<td><b>Non Ci Sono Aree Per Questo Piano</b></td>
							</tr>
						</table>

					</s:if>
					<s:else>
						<s:if test="%{#session.listaaree.get(0)!=null}">
							<div align="center">
								<td>
									<table border="1">
										<td colspan="2"><br> Pagine totali: <s:property
												value="#session.pagineArea" /> <br> Pagina corrente: <s:property
												value="#session.paginacorrenteArea" /> <br> Anno di
											riferimento: <s:property value="#session.anno.descrizione" /></td>
										<tr>

											<td></td>
											<td>Area D'Investimento</td>
										</tr>
										<s:set name="varInizioArea" value="#session.inizioArea"></s:set>
										<s:set name="varFineArea" value="#session.fineArea"></s:set>
										<s:iterator begin="#varInizioArea" end="#varFineArea"
											value="#session.listaaree">
											<tr>
												<td><input type="radio" name=idarea
													value="'<s:property value="idarea"/>'" /></td>
												<td><s:property value="area" /></td>
											</tr>
										</s:iterator>
									</table> <br> <s:submit align="center" method="ispezioneArea"
										value="Ispeziona Area" /> <br> <br> <s:set
										name="varControlloindietroArea"
										value="#session.controlloindietroArea"></s:set> <s:if
										test="%{#varControlloindietroArea}">
										<s:submit align="center" method="primaArea" value="Prima" />
										<s:submit align="center" method="indietroArea"
											value="Indietro" />
									</s:if> <s:set name="varControllofineArea"
										value="#session.controllofineArea"></s:set> <s:if
										test="%{#varControllofineArea}">
										<br>
										<br>
										<s:submit align="center" method="avantiArea" value="Avanti" />
										<s:submit align="center" method="ultimaArea" value="Ultima" />
									</s:if> <br> <br>
								</td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
							</div>
							<br>
							<s:if test="%{#session.checksottocategoria}">
								<table>
									<tr>
										<td><b>Non ci sono SottoCategorie per quest'Area
												D'Investimento</b></td>
									</tr>
								</table>
							</s:if>
							<s:else>
								<s:if test="%{#session.listasottocategorie.get(0)!=null}">
									<div align="center">
										<td>
											<table border="1">
												<td colspan="2"><br> Pagine totali: <s:property
														value="#session.pagineSottCat" /> <br> Pagina
													corrente: <s:property
														value="#session.paginacorrenteSottCat" /> <br> Area
													di riferimento <s:property
														value="#session.oggettoarea.area" /></td>
												<tr>

													<td></td>
													<td>SottoCategoria</td>
												</tr>
												<s:set name="varInizioSottCat"
													value="#session.inizioSottCat"></s:set>
												<s:set name="varFineSottoCat" value="#session.fineSottCat"></s:set>
												<s:iterator begin="#varInizioSottCat" end="#varFineSottoCat"
													value="#session.listasottocategorie">
													<tr>
														<td><input type="radio" name=idsottocategoria
															value="'<s:property value="idsottocategoria"/>'" /></td>
														<td><s:property value="sottocategoria" /></td>
													</tr>
												</s:iterator>
											</table>
									</div>
									<br>
									<s:submit align="center" method="ispezioneSottoCategoria"
										value="Ispeziona SottoCategoria" />
									<br>
									<br>
									<s:set name="varControlloindietroSottCat"
										value="#session.controlloindietroSottCat"></s:set>
									<s:if test="%{#varControlloindietroSottCat}">
										<s:submit align="center" method="primaSottoCategoria"
											value="Prima" />
										<s:submit align="center" method="indietroSottoCategoria"
											value="Indietro" />
									</s:if>

									<s:set name="varControllofineSottCat"
										value="#session.controllofineSottCat"></s:set>
									<s:if test="%{#varControllofineSottCat}">
										<br>
										<br>
										<s:submit align="center" method="avantiSottoCateogoria"
											value="Avanti" />
										<s:submit align="center" method="ultimaSottoCategoria"
											value="Ultima" />
									</s:if>
									<br>
									<br>
									</td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<br>
									<s:if test="%{#session.checkspesa}">
										<table>
											<tr>
												<td><b>Non ci sono Spese D'Investimento per questa
														SottoCategoria!</b></td>
											</tr>
										</table>

									</s:if>
									<s:else>
										<s:if test="%{#session.listaspese.get(0)!=null}">
											<div align="center">
												<td>
													<table border="1">
														<td colspan="2"><br> Pagine totali: <s:property
																value="#session.pagineSpesaInv" /> <br> Pagina
															corrente: <s:property
																value="#session.paginacorrenteSpesaInv" /> <br>
															SottoCategoria di riferimento : <s:property
																value="#session.oggettosottocat.sottocategoria" /></td>
														<tr>

															<td>Spesa Investimento</td>
														</tr>
														<s:set name="varInizioSpesaInv"
															value="#session.inizioSpesaInv"></s:set>
														<s:set name="varFineSpesaInv"
															value="#session.fineSpesaInv"></s:set>
														<s:iterator begin="#varInizioSpesaInv"
															end="#varFineSpesaInv" value="#session.listaspese">
															<tr>
																<td><s:property value="spesainvestimento" /></td>
															</tr>
														</s:iterator>
													</table> <br> <br> <s:set
														name="varControlloindietroSpesaInv"
														value="#session.controlloindietroSpesaInv"></s:set> <s:if
														test="%{#varControlloindietroSpesaInv}">
														<s:submit align="center" method="primaSpesaInvestimento"
															value="Prima" />
														<s:submit align="center"
															method="indietroSpesaInvestimento" value="Indietro" />
													</s:if> <s:set name="varControllofineSpesaInv"
														value="#session.controllofineSpesaInv"></s:set> <s:if
														test="%{#varControllofineSpesaInv}">
														<br>
														<br>
														<s:submit align="center" method="avantiSpesaInvestimento"
															value="Avanti" />
														<s:submit align="center" method="ultimaSpesaInvestimento"
															value="Ultima" />
													</s:if> <br> <br>
												</td>
											</div>
										</s:if>
									</s:else>
								</s:if>
							</s:else>
						</s:if>
					</s:else>
				</tr>
			</table>
		</s:else>
	</s:form>
	<s:if test="hasActionErrors()">
		<div class="errors">
			<s:actionerror />
		</div>
	</s:if>
</body>
</html>