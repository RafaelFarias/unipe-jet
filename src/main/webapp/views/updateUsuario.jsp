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
	<h2>Atualização de Usuario</h2>
	<a href="prepararListarUsuario">Voltar</a><br/>
	<form:form action="updateActionUsuario" method="POST"
		modelAttribute="usuario">
		<form:hidden path="id" />
		Nome:
		<form:input path="nome" />
		<br />
		Email:
		<form:input path="email" />
		<br />
		Data de Nascimento:
		<form:input path="dataNascimento" OnKeyUp="mascaraData(this,event);" maxlength="10"/>
		<br />
		RG:
		<form:input path="rg" />
		CPF:
		<form:input path="cpf" />
		<br />
		Login:
		<form:input path="login" />
		<br />
		Senha:
		<form:password path="senha"/>
		<br />
		
		Autorizacao:
		<form:select path="autorizacao.id" items="${autorizacoes}"
			itemValue="id" itemLabel="nome" />
		<br />

		<input type="submit" value="Enviar" />
	</form:form>
</body>
</html>