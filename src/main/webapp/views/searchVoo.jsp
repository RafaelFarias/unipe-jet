<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery.maskedinput/1.4.1/jquery.maskedinput.js"></script>
<html>

<script>
function mascaraData(campoData, e){
    var data = campoData.value;
    
    if(window.event) { // IE                    
        keynum = e.keyCode;
    } else if(e.which){ // Netscape/Firefox/Opera                   
        keynum = e.which;
    }
    
    keypressed = String.fromCharCode(keynum)
    
    if (keynum != 8 && data.length == 2){
        data = data + '/';
        campoData.value = data;
		return true;              
    }
    if (keynum != 8 && data.length == 5){
        data = data + '/';
        campoData.value = data;
        return true;
    }
}
</script>

<body>
	<h2>Buscar por Voo</h2>
	<a href="prepararListarVoo">Voltar</a><br/>
	<form:form action="buscarVoo" method="POST"
		modelAttribute="voo">
		Cidade de origem:
		<form:input path="cidadeOrigem" /><br/>
		Cidade de destino:
		<form:input path="cidadeDestino" /><br/>		
		Data:
		<form:input path="data" OnKeyUp="mascaraData(this,event);" maxlength="10"/><br/>		
				
		<input type="submit" value="Enviar" />
	</form:form>
</body>
</html>