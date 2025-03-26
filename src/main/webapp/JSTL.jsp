<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="sql" uri="jakarta.tags.sql"%>
<%@ taglib prefix="func" uri="jakarta.tags.functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String[] arr = new String[5];
	arr[0] = "Casa";
	arr[1] = "Cuarto";
	arr[2] = "Puerta";
	arr[3] = "Pared";
	arr[4] = "Piso";
	pageContext.setAttribute("arr1", arr);
	%>
	<c:set var="mensaje" value="Hola Mundo" />
    <p>${func:toUpperCase(mensaje)}</p> <!-- Imprime "HOLA MUNDO" -->
	<h3>Cosas</h3>
	<%= arr.length %>
	<table border="1">
		<c:forEach items = "${arr1}" var="cosa">
			<tr>
				<td><c:out value="${cosa}"/></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>