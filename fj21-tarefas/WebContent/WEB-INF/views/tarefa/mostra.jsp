
<%@	taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="caelum"%>

<html>
<head>
	<meta charset="UTF-8">
	<title>Mostra Contato</title>
	<link href="resources/css/jquery.css" rel="stylesheet">
	<script type="text/javascript" src="resources/js/jquery.js"></script>
    <script type="text/javascript" src="resources/js/jquery-ui.js"></script>

</head>
<body>
	<h3>Alterar tarefa - ${tarefa.id}</h3>
	<form action="alteraTarefa" method="post">
		<input type="hidden" name="id" value="${tarefa.id}" /> Descrição:<br />
		
		<textarea name="descricao" cols="100" rows="5">${tarefa.descricao}</textarea>
		<br /> Finalizado <input type="checkbox" name="finalizado" value="true" ${tarefa.finalizado?	'checked'	:	''	} /> 
		<br /> Data de finalização: <br /> 
		
		<caelum:campoData id="dataFinalizacao" data="${param.dataFinalizacao}"/>
<%-- 		<fmt:formatDate value="${tarefa.dataFinalizacao.time}" pattern="dd/MM/yyyy"/> --%>
		<br /> 
		<input type="submit" value="Alterar" />
	</form>
</body>
</html>