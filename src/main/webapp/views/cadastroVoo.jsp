<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>

<body>
	<h2>Cadastro de Voo</h2>
	<a href="prepararListarVoo">Voltar</a><br/>
	<form:form action="addVoo" method="POST"
		modelAttribute="voo">
		Cidade de origem:
		<form:input path="cidadeOrigem" /><br/>
		Cidade de destino:
		<form:input path="cidadeDestino" /><br/>		
		Hora da partida:
		<form:input path="horaPartida" /><br/>
		Dura��o:
		<form:password path="duracao"/><br />
		Dist�ncia:
		<form:password path="distancia"/><br />
		Pre�o:
		<form:password path="preco"/><br />
		Capacidade:
		<form:password path="capacidade"/><br />
				
		<input type="submit" value="Enviar" />
	</form:form>
</body>
</html>