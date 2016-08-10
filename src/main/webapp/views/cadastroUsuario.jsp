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
	<h2>Cadastro de Usuario</h2>
	<a href="prepararListarUsuario">Voltar</a><br/>
	<form:form action="addUsuario" method="POST"
		modelAttribute="usuario">
		Nome completo:
		<form:input path="nome" /><br/>
		Email:
		<form:input path="email" /><br/>
		Tipo de documento:
		<select size="1" id="TipoDocumentoCombo" name="TipoDocumentoCombo">
			<option selected value=""></option>
			<option value="RG">RG</option>
			<option value="CPF">CPF</option>
		</select><br/>
		<c:if test="${x = 'RG'}">
			RG:
			<form:input path="rg" /><br/>
		</c:if>
		<c:if test="${x = 'CPF'}">		
			CPF:
			<form:input path="cpf" /><br/>
		</c:if>
		Data de Nascimento:				
		<form:input id="dataNascimentoInput" OnKeyUp="mascaraData(this,event);" path="dataNascimento" maxlength="10"/>
		<br/>
		Login:
		<form:input path="login" /><br/>
		Senha:
		<form:password path="senha"/><br />
		
		Autorizacao:
		<form:select path="autorizacao.id" items="${autorizacoes}"
			itemValue="id" itemLabel="nome" /><br/>
		<input type="submit" value="Enviar" />
	</form:form>
</body>
</html>