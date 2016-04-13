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

import fr.keepplayin.dao.DemandeAmiDao;
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

		Long id = null;
		if (request.getParameter("id") != null) {
			id = Long.parseLong(request.getParameter("id"));
		}
		
		Utilisateur user;
		UtilisateurDao dao = new UtilisateurDao();
		DemandeAmiDao daoD = new DemandeAmiDao();

		// On refresh l'utilisateur en session
		session.setAttribute("utilisateur", dao.get(u.getId()));
		session.setAttribute("nombreDemande", daoD.nombreDemandeAttente(u));

		if (id != null && !id.equals(u.getId())) {
			user = dao.get(id);
			
			if (user == null) {
				RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/404.jsp");
				dis.forward(request, response);
				
				return;
			} else {
				session.setAttribute("utilisateurVisite", user);
				session.setAttribute("visite", Boolean.TRUE);
				session.setAttribute("ami", u.estAmi(user));
				session.setAttribute("enAttente", daoD.estEnAttente(u, user));
			}
		} else {
			session.setAttribute("visite", Boolean.FALSE);
			session.removeAttribute("ami");
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