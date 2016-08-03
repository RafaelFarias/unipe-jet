<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<body>
	<h2>Cadastro de Passageiros</h2>
	<a href="prepararListarPassageiro">Voltar</a><br/>
	<form:form action="addPassageiro" method="POST"
		modelAttribute="passageiro">
		Nome:
		<form:input path="nome" /><br/>
		Rg:
		<form:input path="rg" /><br/>
		Cpf:
		<form:input path="cpf" /><br/>
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