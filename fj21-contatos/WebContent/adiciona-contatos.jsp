<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="caelum"%>
<html>
<head>
<meta charset="UTF-8">
<title>Adiciona contato</title>
<link href="css/jquery.css" rel="stylesheet">
<link href="css/jquery.css" rel="stylesheet">
<script src="js/jquery.js"></script>
<script src="js/jquery-ui.js"></script>
<script>
	$(function() {
		$("#includedContent").load("mvc?logica=ListaContatosLogic");
	});	
</script>
<script>
	function valData(data) {//dd/mm/aaaa

		day = data.substring(0, 2);
		month = data.substring(3, 5);
		year = data.substring(6, 10);

		if ((month == 01) || (month == 03) || (month == 05) || (month == 07)
				|| (month == 08) || (month == 10) || (month == 12)) {//mes com 31 dias
			if ((day < 01) || (day > 31)) {
				alert('invalid date');
			}
		} else

		if ((month == 04) || (month == 06) || (month == 09) || (month == 11)) {//mes com 30 dias
			if ((day < 01) || (day > 30)) {
				alert('invalid date');
			}
		} else

		if ((month == 02)) {//February and leap year
			if ((year % 4 == 0) && ((year % 100 != 0) || (year % 400 == 0))) {
				if ((day < 01) || (day > 29)) {
					alert('invalid date');
				}
			} else {
				if ((day < 01) || (day > 28)) {
					alert('invalid date');
				}
			}
		}

	}
	
	function mascaraData( campo, e )
	{
		var kC = (document.all) ? event.keyCode : e.keyCode;
		var data = campo.value;
		
		if( kC!=8 && kC!=46 )
		{
			if( data.length==2 )
			{
				campo.value = data += '/';
			}
			else if( data.length==5 )
			{
				campo.value = data += '/';
			}
			else
				campo.value = data;
		}
	}
</script>
<c:import url="cabecalho.jsp" />
</head>
<body>
	<form action="gravaContato" method="post">
		<table align="center">
			<tr>
				<td></td>
				<td><input type="hidden" name="id" value="${param.id}" /></td>
			</tr>
			<tr>
				<td>Nome:</td>
				<td><input type="text" name="nome" value="${param.nome}" /></td>
			</tr>
			<tr>
				<td>E-mail:</td>
				<td><input type="email" name="email" value="${param.email}" /></td>
			</tr>
			<tr>
				<td>Endereço:</td>
				<td><input type="text" name="endereco"
					value="${param.endereco}" /></td>
			</tr>
			<tr>
				<td>Data Nascimento:</td>
				<td><caelum:campoData id="dataNascimento"
						data="${param.dataNascimento}">
				</caelum:campoData></td>
				<br />
			</tr>
			<td><button>Salvar</button></td>
			</tr>
		</table>
	</form>
	<div id="includedContent"></div>
</body>
</html>