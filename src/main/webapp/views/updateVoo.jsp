<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<body>
	<h2>Atualiza��o de Voo</h2>
	<a href="prepararListarVoo">Voltar</a><br/>
	<form:form action="updateActionVoo" method="POST"
		modelAttribute="voo">
		<form:hidden path="id" />
		Cidade de origem:
		<form:input path="cidadeOrigem" />
		<br />
		Cidade de destino:
		<form:input path="cidadeDestino" />
		<br />
		Hora da partida:
		<form:input path="horaPartida" />
		<br />
		Dura��o:
		<form:input path="duracao" />
		<br />
		Dist�ncia:
		<form:input path="distancia" />
		<br />
		Pre�o:
		<form:input path="preco" />
		<br />
		Capacidade:
		<form:input path="capacidade" />
		<br />			

		<input type="submit" value="Enviar" />
	</form:form>
</body>
</html>