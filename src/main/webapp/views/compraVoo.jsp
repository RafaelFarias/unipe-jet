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
	<h2>Compra de Voo</h2>
	<br/>
	
		<c:forEach items="${vooList}" var="voo">
		    <ul>
				<li>Numero Voo: ${voo.id}</li>			
				<li>Cidade Origem: ${voo.cidadeOrigem}</li>
				<li>Cidade Destino: ${voo.cidadeDestino}</li>
				<li>Data: ${voo.getDataStr()}</li>
				<li>Hora da partida: ${voo.horaPartida}</li>
				<li>Duracao: ${voo.duracao}</li>
				<li>Distancia: ${voo.distancia}</li>
				<li>Preco: ${voo.preco}</li>
				<li>Capacidade: ${voo.capacidade}</li>
			</ul>
			<a href="finalizarCompra?id=${voo.id}">Finalizar Compra</a>		
		</c:forEach>	
</body>
</html>