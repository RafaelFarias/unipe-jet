<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<body>
	<a href="prepararCadastroVoo">Cadastro de Voo</a>
	<br />
	<h2>Voos</h2>
	<br/>
	<table>
		<tr>
			<th>Numero Voo</th>
			<th>Cidade de Origem</th>
			<th>Cidade de Destino</th>
			<th>Hora da Partida</th>
			<th>Duracao</th>
			<th>Distancia</th>
			<th>Preco</th>
			<th>Capacidade</th>
			<th>Atualizar</th>
			<th>Remover</th>
		</tr>
		<c:forEach items="${vooList}" var="voo">
			<tr>
				<td>${voo.numVoo}</td>
				<td>${voo.cidadeOrigem}</td>
				<td>${voo.cidadeDestino}</td>
				<td>${voo.horaPartida}</td>
				<td>${voo.duracao}</td>
				<td>${voo.distancia}</td>
				<td>${voo.preco}</td>
				<td>${voo.capacidade}</td>
				<td><a href="prepararAtualizarVoo?numVoo=${voo.numVoo}">Atualizar</a>
				<td><a href="removerVoo?numVoo=${voo.numVoo}">Remover</a>
			</tr>
		</c:forEach>
	</table>


</body>
</html>