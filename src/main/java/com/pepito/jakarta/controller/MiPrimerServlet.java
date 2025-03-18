package com.pepito.jakarta.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class MiPrimerServlet
 */

public class MiPrimerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MiPrimerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequsest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String valor = request.getParameter("nomusu");
		
		//Resultados de procesos varios
		String valorImportante1 = "codigo_interno_X";
		int valorImportante2 = 123;
		request.setAttribute("valor1", valorImportante1);
		request.setAttribute("valor2", valorImportante2);
		
		
		response.getWriter().append("Hola, me enviaste: "+valor);
		RequestDispatcher var = request.getRequestDispatcher("respuesta");
		var.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String valor = request.getParameter("nomusu");
		
		String usuario = request.getParameter("usu");
		String password = request.getParameter("pass");
		response.getWriter().append("<html><body><h3>Hola, me enviaste: "+valor+"</h3><p>"+usuario+"</p><p>"+password+"</p></body></html>");
	}

}
