<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>Registro de estudiante</h3>
	<form method="post" action="registrar">
		Nombre: <input name="nombre"><br>
		Apellido: <input name="apellido"><br>
		Fecha de nacimiento: <input type="date" name="fechanac"><br>
		email: <input name="email"><br>
		<input type="submit" value="Registrar">
	</form>
</body>
</html>