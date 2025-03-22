package com.pepito.jakarta.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Servlet implementation class RegistrarServlet
 */
@WebServlet("/registrar")
public class RegistrarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Rescatar los parámetros del formulario
		String nom = request.getParameter("nombre");
		String ap = request.getParameter("apellido");
		String fecha = request.getParameter("fechanac");
		String email = request.getParameter("email");
		// Establecer la conexión a la DDBB
		try {
			Class.forName("org.postgresql.Driver");
			String cadena = "jdbc:postgresql://localhost:5432/universidadx";
			Connection con = DriverManager.getConnection(cadena, "usuario3","123456ABCxyz+");
			PreparedStatement pst =  con.prepareStatement("insert into estudiante (nombre, apellido, fecha_nacimiento,email) values (?,?,?,?)");
			pst.setString(1, nom);
			pst.setString(2, ap);
			// Si el formulario registroestudiante.jsp recibe un simple input type="text" o type="date"
			SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
			pst.setDate(3, new java.sql.Date(formato.parse(fecha).getTime()));
			pst.setString(4, email);
			int n = pst.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
