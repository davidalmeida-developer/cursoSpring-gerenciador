<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/formNovaEmpresa.html" var="linkFormNovaEmpresa"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" lang="pt-br">
<title>Teste JSP</title>
<link rel="stylesheet" href="style.css">
</head>
	<body>
		<c:if test="${not empty empresa}">
			<h1>${empresa}</h1>
		</c:if>
		
		<c:if test="${empty empresa}">
			<h1>Nenhuma empresa cadastrada!</h1>
			<p>Para cadastrar clique abaixo:</p>
			<a href="${linkFormNovaEmpresa}">Link</a>
		</c:if>
	</body>
</html>