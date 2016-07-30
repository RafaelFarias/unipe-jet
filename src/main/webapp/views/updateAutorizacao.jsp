<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<body>
	<h2>Cadastro de Autorização</h2>
	<a href="prepararListarAutorizacao">Voltar</a><br/>
	<form:form action="updateActionAutorizacao" method="POST"
		modelAttribute="autorizacao">
		<form:hidden path="id" />
		Nome:
		<form:input path="nome" />
		<br />
		<input type="submit" value="Enviar" />
	</form:form>
</body>
</html>