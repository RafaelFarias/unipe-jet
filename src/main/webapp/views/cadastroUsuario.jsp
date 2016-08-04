<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>

<script>
$("#TipoDocumentoCombo").change(function(){
	alert('oi')
    var x=$(this).val();
});
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