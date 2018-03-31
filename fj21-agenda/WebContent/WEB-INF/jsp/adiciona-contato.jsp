<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="caelum" %>
<html>
<head>
	<meta charset="UTF-8">
	<title>Adiciona contato</title>
	<link href="css/jquery.css" rel="stylesheet">
	<script src="js/jquery.js"></script>
    <script src="js/jquery-ui.js"></script>
     <script> 
    $(function(){
      $("#includedContent").load("mvc?logica=ListaContatosLogic"); 
    });
    </script> 
    <c:import url="/WEB-INF/jsp/cabecalho.jsp"/>
</head>
	<body>
		<form action="mvc">
		<table align="center">
		<tr>
		        <td></td><td><input type="hidden" name="logica" value="AlteraContatoLogic" /></td>
			</tr>
		    <tr>
		        <td></td><td><input type="hidden" name="id" value="${param.id}" /></td>
			</tr><tr>
				<td>Nome:</td><td><input type="text" name="nome" value="${param.nome}"/></td>
			</tr><tr>
				<td>E-mail:</td><td> <input type="email" name="email" value="${param.email}" /></td>
			</tr><tr>
				<td>Endereço:</td><td> <input type="text" name="endereco"  value="${param.endereco}"/></td>
			</tr><tr>
				<td>
				     Data Nascimento:</td><td> <caelum:campoData id="dataNascimento" data="${param.dataNascimento}"></caelum:campoData> 
				  
				</td>
			</tr><tr>	
				<td>
				    <input type="submit" value="gravar" />	
				</td>
			</tr>			
		</table>			
		</form>
		<div id="includedContent"></div>
	<c:import url="/WEB-INF/jsp/rodape.jsp"/>
	</body>
</html>