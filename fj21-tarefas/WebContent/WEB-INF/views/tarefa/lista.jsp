<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<script type="text/javascript">
	function finalizaAgora(id) {
		$.post("finalizaTarefa",	{'id'	:	id},	function() {
	    //	selecionando	o	elemento	html	através	da	
		//	ID	e	alterando	o	HTML	dele	
		   $("#tarefa_"+id).html("Finalizado");
		});
	}
	</script>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista Tarefas</title>
<script type="text/javascript" src="resources/js/jquery.js"></script>
</head>
<body>


	<a href="novaTarefa">Criar Nova Tarefa</a>
	<br />
	<br />

	<table>
		<tr>
			<th>ID</th>
			<th>DESCRIÇÃO</th>
			<th>FINALIZAÇÃO</th>
			<th>DATA DE FINALIZAÇÃO</th>
			<th>AÇÃO</th>
		</tr>

		<c:forEach items="${tarefas}" var="tarefa">
			<tr>
				<th>${tarefa.id}</th>
				<th>${tarefa.descricao}</th>
				<c:if test="${tarefa.finalizado eq false}">
					<td id="tarefa_${tarefa.id}"><a href="#"
						onClick="finalizaAgora(${tarefa.id})"> Finaliza Agora! </a></td>
				</c:if>
				<c:if test="${tarefa.finalizado eq true}">
					<td>Finalisado</td>
				</c:if>				
				<td>
					<fmt:formatDate value="${tarefa.dataFinalizacao.time}" pattern="dd/MM/yyyy" />
				</td>
				<td><a href="removeTarefa?id=${tarefa.id}">Remover</a></td>
				<td><a href="mostraTarefa?id=${tarefa.id}&dataFinalizacao=<fmt:formatDate value="${tarefa.dataFinalizacao.time}" pattern="dd/MM/yyyy" />">Alterar</a></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>