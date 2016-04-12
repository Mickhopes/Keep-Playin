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

import fr.keepplayin.dao.UtilisateurDao;
import fr.keepplayin.model.Utilisateur;

/**
 * Servlet implementation class Init
 */
public class Profil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Profil() {
        // TODO Auto-generated constructor stub
    }
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* Redirection vers la jsp */
		String id = request.getParameter("id");
		Utilisateur user;
		HttpSession session = request.getSession();
		UtilisateurDao dao = new UtilisateurDao();
		
		if (id != null) {
			user = dao.get(Long.parseLong(id));
			
			if (user == null) {
				RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/404.jsp");
				dis.forward(request, response);
				
				return;
			} else {
				session.setAttribute("utilisateurVisite", user);
				session.setAttribute("visite", Boolean.TRUE);
			}
		} else {
			session.setAttribute("visite", Boolean.FALSE);
		}
		
		// On refresh l'utilisateur en session
		Utilisateur u = (Utilisateur) session.getAttribute("utilisateur");
		if (u != null) {
			session.setAttribute("utilisateur", dao.get(u.getId()));
		}
		
		RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/profil.jsp");
		
		if (session.getAttribute("utilisateur") != null) {
			dis.forward(request, response);
		} else {
			response.sendRedirect("/index");
		}
		
		
		// On envoi les paramètres à la requête avant de la forward à la jsp
//		request.setAttribute("currentUrl", "index");
//		request.setAttribute("mapDoc", map);
//		if (erreur != null) {
//			request.setAttribute("erreur", erreur);
//		}
		
		//dis.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}