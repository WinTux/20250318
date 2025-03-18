package com.pepito.jakarta.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class RecibirGalletitaServlet
 */

@WebServlet(urlPatterns="/galletas", initParams= {
		@WebInitParam(name="USD",value="123")
})
public class RecibirGalletitaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecibirGalletitaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		var galletas = request.getCookies();
		// galletas.length
		//galletas[0].getName()
		//galletas[0].getValue()
		response.getWriter().append("<html><body><table border='1'>");
		response.getWriter().append("<tr><td>Llave</td><td>Valor</td></tr>");
		for(var g : galletas) {
			response.getWriter().append("<tr><td>"+g.getName()+"</td><td>"+g.getValue()+"</td></tr>");
		}
		response.getWriter().append("</table></body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
