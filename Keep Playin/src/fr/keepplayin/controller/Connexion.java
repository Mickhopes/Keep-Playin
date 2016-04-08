package fr.keepplayin.controller;

import java.io.IOException;
import java.net.UnknownHostException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.keepplayin.dao.UtilisateurDao;
import fr.keepplayin.model.Utilisateur;

/**
 * Servlet implementation class Connexion
 * 
 * @author Line Pouvaret
 */

public class Connexion extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Connexion() {
    	super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/connexion.jsp");
		dis.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mail = request.getParameter("mail");
		String password = request.getParameter("password");
		
		UtilisateurDao userDao = new UtilisateurDao();
		Utilisateur user = userDao.chercherEmail(mail);
		
		if (user != null){
			if(user.getMdp().equals(password)){
				HttpSession session = request.getSession();
				session.setAttribute("utilisateur", user);
				response.sendRedirect("/profil");
			}
			else{
				// erreur mot de passe
				response.sendRedirect("/connexion?erreur=infoincorrecte");
			}
		}
		else{
			response.sendRedirect("/connexion?erreur=infoincorrecte");
		}
	}

}
