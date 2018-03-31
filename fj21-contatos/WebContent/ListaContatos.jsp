<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<%@ page
	import="java.util.*, br.com.caelum.dao.*, br.com.caelum.modelo.*, br.com.caelum.util.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista Contatos</title>
</head>
<body>
	<jsp:useBean id="dao" class="br.com.caelum.dao.ContatoDao" />
	<main class="container">
	<table class="table table-striped">
		<thead>
			<tr>
				<th scope="col">Nome</th>
				<th scope="col">E-Mail</th>
				<th scope="col">Endereco</th>
				<th scope="col">Data Nascimento</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="contato" items="${dao.list}">
				<tr>
					<td>${contato.nome}</td>
					<td>
					    <c:if test="${not empty contato.email}"> 
					        <a href="mailto:${contato.email}">${contato.email}</a>				
					    </c:if>
					    <c:if test="${empty contato.email}">
					        E-mail náo informado
					    </c:if>
					</td>
					<td>${contato.endereco}</td>
					<td><fmt:formatDate value="${contato.dataNascimento.time}" pattern="dd/MM/yyyy" /></td>

				</tr>
			</c:forEach>
		</tbody>
	</table>
	</main>
</body>
</html>