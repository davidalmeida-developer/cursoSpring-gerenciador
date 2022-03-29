<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List,br.com.alura.gerenciador.modelo.Empresa"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:url value="entrada?acao=NovaEmpresaForm" var="linkFormNovaEmpresa"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Java Standard Taglib</title>
</head>
<body>

	<c:if test="${not empty empresa}">
		<h1>Nenhuma empresa cadastrada!</h1>
		<p>Para cadastrar clique <a href="${linkFormNovaEmpresa}">AQUI!</a></p>
	</c:if>
	
	<c:if test="${empty empresa}">
		<h2>Para cadastrar clique <a href="${linkFormNovaEmpresa}">AQUI!</a></h2>
		
	</c:if>

	<p>Lista de empresas:</p>
	
	<ul>
		<c:forEach items="${empresas}" var="empresa">
			<li>
				${empresa.nome} - <fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy"/> 
				<a href="/gerenciador/entrada?acao=MostraEmpresa&id=${empresa.id}">Editar</a>
				<a href="/gerenciador/entrada?acao=RemovaEmpresa&id=${empresa.id}">Remove</a>
			</li>
		</c:forEach>
	
	</ul>
	<c:if test="${not empty empresa}">
		<a href="${linkFormNovaEmpresa}">Cadastrar nova empresa.</a>
	</c:if>
</body>
</html>