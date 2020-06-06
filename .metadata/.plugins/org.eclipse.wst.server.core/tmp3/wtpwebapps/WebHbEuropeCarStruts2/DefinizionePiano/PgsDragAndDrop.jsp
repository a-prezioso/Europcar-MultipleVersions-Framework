<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PgsDragAndDrop.jsp</title>
</head>
<style>
div { 

  padding-right:10pt;

}

h2{

  text-align:center;
}

#bambini{
  width:100%;
  display:block;
  padding-bottom:20pt;
}

#buoni{
align: center;
  width: 200px;
  float:left;
  width:200px;
  border-left:1px solid gray;
  border-right:3px dashed gray;
  margin-left:15px;
min-height:100px;
}

#cattivi{
  align: center;
  width: 200px;
  float:left;
  margin-left:15px;
  border-right:1px solid gray;
  min-height:100px;
}

.bimbo{
  width: 150px;
  padding:5px;
  margin:5px;
  border:2px solid lightgray;  
}
</style>
<script type="text/javascript">
function noselect(event){ 
	  if (event.preventDefault)
	  { event.preventDefault(); }
	  return false;
	}

	//preparo gli elementi trascinabili, memorizzandone l'id al verificarsi dell'evento dragStart
	var bimbi = document.querySelectorAll('.bimbo');

	for (var i = 0; i < bimbi.length; i++) {
	  bimbi<i>.addEventListener('dragstart', function (event) {
	    event.dataTransfer.setData('bimboId', this.id);
	  });
	}

	//funzione per preparare l'elemento di destinazione per il drop
	function bindDnDEvents(dropTarget){

	dropTarget.addEventListener('dragover', noselect);
	dropTarget.addEventListener('dragenter', noselect);
	dropTarget.addEventListener('drop', function (event) { 
	 
	  if (event.preventDefault)
	  { event.preventDefault(); }
	  
	  var move = document.querySelector('#'+ event.dataTransfer.getData('bimboId'));
	  
	  dropTarget.appendChild(move);
	  
	  return false;
	  
	});

	}

	//seleziono gli elementi su cui sarà possinole fare il drop
	var areaCattivi = document.querySelector('#cattivi');
	var areaBuoni = document.querySelector('#buoni');

	bindDnDEvents(areaCattivi);
	bindDnDEvents(areaBuoni);
</script>
<body>
		  <div align="center" id="bambini">-
		    <div align="center" id="bimbo1" draggable="true" class="bimbo">Area</div>
		    <div align="center" id="bimbo2" draggable="true" class="bimbo">SottoCategoria</div>
		    <div align="center" id="bimbo3" draggable="true" class="bimbo">Spesa Investimento</div>
		    <div align="center" id="bimbo4" draggable="true" class="bimbo">Anno Contabile</div>
		  </div>
		  <div align="center" >
		   <div align="center" id="buoni" ><h2>Vecchio Piano D'investimento</h2></div>
		  <div align="center" id="cattivi"><h2>Nuovo Piano D'investimento</h2></div>
		  </div>
</body>
</html>