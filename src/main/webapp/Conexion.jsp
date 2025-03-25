<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Conexión JDBC</title>
	<%@ include file="estilobootstrap.jsp" %>
</head>
<body>
	<%
		// Paso 0: agregar import a java.sql.* 
			
		// 1er paso: Agregar dependencia
		
		// 2do paso: Inscribir el driver
		Class.forName("org.postgresql.Driver");
	
		// 3er paso: Crear una conexión
		String cadena = "jdbc:postgresql://localhost:5432/universidadx";
		Connection con = DriverManager.getConnection(cadena,"usuario3","123456ABCxyz+");
		
		// 4to paso: Crear un statement
		Statement st = con.createStatement();
		
		// 5to paso: Ejecutar una query
		ResultSet rs = st.executeQuery("select * from estudiante;");
		
		// 6to paso: Procesar los resultados
		
		rs.next();
		String nom = rs.getString("nombre");
		
	%>
	
	<%= "Exito conectandose a la DDBB" %>
	<br>
	El nombre es: <%= nom %>
	
	<%
		rs.next();
		nom = rs.getString("nombre");
	%>
	<br>
	El nombre es: <%= nom %>
	<div class="container">
	<div class ="row">
	<div class="col-1"></div>
	<div class="col-10">
	<table class="table table-success table-hover">
		<tr>
			<th>ID</th>
			<th>Nombre</th>
			<th>Apellido</th>
			<th>Fecha de nacimiento</th>
			<th>email</th>
		</tr>
	<%
		// Cargar registros rstantes
		while(rs.next()){
			// guardar los datos en una lista.
			int id = rs.getInt(1);
			String nombre = rs.getString(2);
			String apellido = rs.getString(3);
			Date fecha_nac = rs.getDate(4);
			String email = rs.getString(5);
			/*
			<tr>
			  <td> id </td>
			  <td> nombre </td>
			  ...
			</tr>
			*/
			out.append("<tr>");
			out.append("<td>"+id);
			out.append("</td>");
			
			out.append("<td>"+nombre);
			out.append("</td>");
			
			out.append("<td>"+apellido);
			out.append("</td>");
			
			out.append("<td>"+fecha_nac);
			out.append("</td>");
			
			out.append("<td>"+email);
			out.append("</td>");
			
			out.append("<td>");
			out.append("<a href='/registroestudiante.jsp?id="+id+"'>Editar");
			out.append("</a>");
			out.append("<a href='/Eliminar?id="+id+"'>Eliminar");
			out.append("</a>");
			out.append("</td>");
			out.append("</tr>");
		}
	
		rs.close();
		st.close();
		con.close();
	%>
	</table>
	</div>
	</div>
	</div>
	
</body>
</html>