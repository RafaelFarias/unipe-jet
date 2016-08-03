<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<body>
	<a href="prepararCadastroPassageiro">Cadastro de Passageiro</a>
	<br />
	<h2>PASSAGEIROS</h2>
	<br/>
	<table>
		<tr>
			<th>Id</th>
			<th>Nome</th>
			<th>RG</th>
			<th>CPF</th>
			<th>Login</th>
			<th>Senha</th>
			<th>Atualizar</th>
			<th>Remover</th>
		</tr>
		<c:forEach items="${passageiroList}" var="user">
			<tr>
				<td>${user.id}</td>
				<td>${user.nome}</td>
				<td>${user.rg}</td>
				<td>${user.cpf}</td>
				<td>${user.login}</td>
				<td>${user.senha}</td>
				<td><a href="prepararAtualizarPassageiro?id=${user.id}">Atualizar</a>
				<td><a href="removerPassageiro?id=${user.id}">Remover</a>
			</tr>
		</c:forEach>
	</table>


</body>
</html>