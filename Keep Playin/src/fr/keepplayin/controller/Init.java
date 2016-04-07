package fr.keepplayin.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Hashtable;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javax.servlet.RequestDispatcher;

/**
 * Servlet implementation class Init
 */
public class Init extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Init() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init() throws ServletException {
    	// Charger les object Objectify
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*HttpSession session = request.getSession();
		Utilisateur user = (Utilisateur) session.getAttribute("utilisateur");
		if (user == null) {
			response.sendRedirect("index.html");
		} else {
			response.sendRedirect("Profil");
		}*/
		/* Redirection vers la jsp */
		RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/index.jsp");
		
		// On envoi les paramètres à la requête avant de la forward à la jsp
//		request.setAttribute("currentUrl", "index");
//		request.setAttribute("mapDoc", map);
//		if (erreur != null) {
//			request.setAttribute("erreur", erreur);
//		}
		
		dis.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}