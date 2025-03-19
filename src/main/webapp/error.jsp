<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<%@ include file="estilobootstrap.jsp" %>
<meta charset="UTF-8">
<title>ERROR</title>
</head>
<body>
	<h1 class="display-3">Ocurrió un error</h1>
	<p class="lead">Contactese con soporte</p>
	<%= exception.getMessage() %>
	
	<%--
		Estudiante
			nombre
			apellido
			ci
			
		EstudiatePost
			nombre
			apellido
			
		pregrado.Estudiante
		
		postgrado.Estudiante
	--%>
</body>
</html>