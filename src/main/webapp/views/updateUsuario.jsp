<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<body>
	<h2>Atualização de Usuário</h2>
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
		Telefone:
		<form:input path="telefone" />
		<br />
		Username:
		<form:input path="username" />
		<br />
		
		Autorizacao:
		<form:select path="autorizacao.id" items="${autorizacoes}"
			itemValue="id" itemLabel="nome" />
		<br />

		<input type="submit" value="Enviar" />
	</form:form>
</body>
</html>