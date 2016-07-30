<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<body>
	<a href="prepararCadastroAutorizacao">Cadastro de Autorização</a>
	<br />
	<h2>AUTORIZAÇÕES</h2>
	<br/>
	<table>
		<tr>
			<th>ID</th>
			<th>Nome</th>
			<th>Atualizar</th>
			<th>REmover</th>
		</tr>
		<c:forEach items="${autorizacaoList}" var="auth">
			<tr>
				<td>${auth.id}</td>
				<td>${auth.nome}</td>
				<td><a href="prepararAtualizarAutorizacao?id=${auth.id}">Atualizar</a>
				<td><a href="removerAutorizacao?id=${auth.id}">REmover</a>
			</tr>
		</c:forEach>
	</table>


</body>
</html>