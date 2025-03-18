package com.pepito.jakarta.controller;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Servlet implementation class SesionesServlet
 */
@WebServlet("/sesiones")
public class SesionesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    String valorSesion, valorContexto;
    
    public SesionesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nomUsuario = request.getParameter("usuario");
		response.getWriter().append("Valor de petición: "+nomUsuario+"<br>");
		
		
		HttpSession sesion = request.getSession();
		if(valorSesion == null)
			sesion.setAttribute("username", nomUsuario);
		valorSesion = (String)sesion.getAttribute("username");
		response.getWriter().append("Valor de sesión: "+valorSesion+"<br>");
		
		
		ServletContext contexto = 
				request.getSession().getServletContext();
		if(valorContexto == null)
			contexto.setAttribute("username", nomUsuario);
		valorContexto = (String)contexto.getAttribute("username");
		response.getWriter().append("Valor de contexto: "+valorContexto+"<br>");
		
		// Manejando cookies
		
		Cookie galletita1 = new Cookie("usuario","Pepe");
		Cookie galletita2 = new Cookie("token","123abc456");
		Cookie galletita3 = new Cookie("id","u07");
		response.addCookie(galletita1);
		response.addCookie(galletita2);
		response.addCookie(galletita3);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
