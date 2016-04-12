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
		HttpSession session = request.getSession();
		Utilisateur u = (Utilisateur) session.getAttribute("utilisateur");
		if (u == null) {
			response.sendRedirect("/index");
			
			return;
		}

		String id = request.getParameter("id");
		Utilisateur user;
		UtilisateurDao dao = new UtilisateurDao();

		// On refresh l'utilisateur en session
		session.setAttribute("utilisateur", dao.get(u.getId()));

		if (id != null) {
			user = dao.get(Long.parseLong(id));
			
			if (user == null) {
				RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/404.jsp");
				dis.forward(request, response);
				
				return;
			} else {
				request.setAttribute("utilisateurVisite", user);
				request.setAttribute("visite", Boolean.TRUE);
				request.setAttribute("ami", u.estAmi(user));
			}
		} else {
			session.setAttribute("visite", Boolean.FALSE);
		}

		RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/profil.jsp");
		dis.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}