<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<body>
	<a href="prepararCadastroUsuario">Cadastro de Usuario</a>
	<br/>
	<a href="prepararListarVoo">Voos</a>
	<br />
	<h2>Usuários</h2>
	<br/>
	<table>
		<tr>
			<th>Id</th>
			<th>Nome</th>
			<th>Email</th>
			<th>Data de Nascimento</th>
			<th>RG</th>
			<th>CPF</th>
			<th>Login</th>
			<th>Senha</th>
			<th>Atualizar</th>
			<th>Remover</th>
		</tr>
		<c:forEach items="${usuarioList}" var="user">
			<tr>
				<td>${user.id}</td>
				<td>${user.nome}</td>
				<td>${user.email}</td>
				<td>${user.getDataNascimentoStr()}</td>
				<td>${user.rg}</td>
				<td>${user.cpf}</td>
				<td>${user.login}</td>
				<td>${user.senha}</td>
				<td><a href="prepararAtualizarUsuario?id=${user.id}">Atualizar</a>
				<td><a href="removerUsuario?id=${user.id}">Remover</a>
			</tr>
		</c:forEach>
	</table>


</body>
</html>