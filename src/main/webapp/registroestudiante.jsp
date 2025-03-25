<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>Registro de estudiante</h3>
	<form method="post" action="registrar">
		<%
			String nn = (String)request.getParameter("id");
		if (nn==null){
			out.append("Nombre: <input name='nombre'><br>");
			out.append("Apellido: <input name='apellido'><br>");
			out.append("Fecha de nacimiento: <input type='date' name='fechanac'><br>");
			out.append("email: <input name='email'><br>");
		}else{
			//primero rescatamos el registro nn
			String cadena = "jdbc:postgresql://localhost:5432/universidadx";
			Connection con = DriverManager.getConnection(cadena,"usuario3","123456ABCxyz+");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from estudiante where id = "+nn);
			if(rs.next()){
				int id = rs.getInt("id");
				String nom = rs.getString("nombre");
				String ape = rs.getString("apellido");
				Date fecha = rs.getDate("fecha_nacimiento");
				String eml = rs.getString("email");
				//Ahora armamos el resto del formulario
				out.append("Nombre: <input name='nombre' value='"+nom+"'><br>");
				out.append("Apellido: <input name='apellido' value='"+ape+"'><br>");
				out.append("Fecha de nacimiento: <input type='date' name='fechanac' value='"+fecha+"'><br>");
				out.append("email: <input name='email' value='"+eml+"'><br>");
				out.append("<input type='hidden' name='id' value='"+id+"'><br>");
			}
		}
		%>
		<input type="submit" value="Registrar">
	</form>
</body>
</html>