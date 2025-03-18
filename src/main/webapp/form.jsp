<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="miservlet">
		Usuario: <input type="text" name="nomusu" placeholder="Ej. Pepe"><br>
		<input type="submit" value="ENVIAR">
	</form>
	
	<br>
	<h3>Ahora con POST</h3>
	<form action="miservlet" method="post">
		Usuario: <input type="text" name="nomusu" placeholder="Ej. Pepe"><br>
		<input type="submit" value="ENVIAR">
	</form>
	
	<br>
	<h3>Ahora con POST (2 parámetros)</h3>
	<form action="miservlet" method="post">
		Usuario: <input type="text" name="usu" placeholder="Ej. Pepe"><br>
		Contraseña: <input type="text" name="pass" placeholder="Ej. 123456"><br>
		<input type="submit" value="ENVIAR">
	</form>
</body>
</html>