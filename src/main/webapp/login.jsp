<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<body>
	Unipe-Jet	
	<br />
	<form action="loginUsuario" method="POST">
		
		Login:
		<input type="text" name="j_username" /><br/>
		Senha:
		<input type="password" name="j_password"/><br />
		
		<input type="submit" value="Enviar" />
		
	</form>
		
	<a href="prepararCadastroUsuario">Cadastre-se</a><br/>
</body>
</html>