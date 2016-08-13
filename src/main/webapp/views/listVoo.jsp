<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<body>
	<a href="prepararCadastroVoo">Cadastro de Voo</a>
	<br/>
	<a href="prepararListarUsuario">Usuarios</a>
	<br />
	<a href="prepararBuscarVoo">Buscar Voo</a>
	<br />
	<h2>Voos</h2>
	<br/>
	<table>
		<tr>
			<th>Numero Voo</th>
			<th>Cidade de Origem</th>
			<th>Cidade de Destino</th>
			<th>Data do voo</th>
			<th>Hora da Partida</th>
			<th>Duracao</th>
			<th>Distancia</th>
			<th>Preco</th>
			<th>Capacidade</th>
			<th>Comprar</th>
			<th>Atualizar</th>
			<th>Remover</th>			
		</tr>
		<c:forEach items="${vooList}" var="voo">
			<tr>
				<td>${voo.id}</td>
				<td>${voo.cidadeOrigem}</td>
				<td>${voo.cidadeDestino}</td>
				<td>${voo.getDataStr()}</td>
				<td>${voo.horaPartida}</td>
				<td>${voo.duracao}</td>
				<td>${voo.distancia}</td>
				<td>${voo.preco}</td>
				<td>${voo.capacidade}</td>
			
			<c:if test="${voo.capacidade > 0}">
				<td><a href="prepararComprarVoo?id=${voo.id}">Comprar</a></td>
			</c:if>
			<c:if test="${voo.capacidade < 1}">
				<td>Sem vagas</td>
			</c:if>				
			
				<td><a href="prepararAtualizarVoo?id=${voo.id}">Atualizar</a></td>
				<td><a href="removerVoo?id=${voo.id}">Remover</a></td>
			</tr>
		</c:forEach>
	</table>


</body>
</html>