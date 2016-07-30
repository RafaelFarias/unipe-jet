<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<body>
	<a href="prepararCadastroUsuario">Cadastro de Usuário</a>
	<br />
	<h2>USUÁRIOS</h2>
	<br/>
	<table>
		<tr>
			<th>Id</th>
			<th>Nome</th>
			<th>Email</th>
			<th>Telefone</th>
			<th>Atualizar</th>
			<th>Remover</th>
		</tr>
		<c:forEach items="${usuarioList}" var="user">
			<tr>
				<td>${user.id}</td>
				<td>${user.nome}</td>
				<td>${user.email}</td>
				<td>${user.telefone}</td>
				<td><a href="prepararAtualizarUsuario?id=${user.id}">Atualizar</a>
				<td><a href="removerUsuario?id=${user.id}">Remover</a>
			</tr>
		</c:forEach>
	</table>


</body>
</html>