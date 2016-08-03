<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<body>
	<h2>Atualização de Passageiro</h2>
	<a href="prepararListarPassageiro">Voltar</a><br/>
	<form:form action="updateActionPassageiro" method="POST"
		modelAttribute="passageiro">
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
		Login:
		<form:input path="login" />
		<br />
		
		Autorizacao:
		<form:select path="autorizacao.id" items="${autorizacoes}"
			itemValue="id" itemLabel="nome" />
		<br />

		<input type="submit" value="Enviar" />
	</form:form>
</body>
</html>