package fr.keepplayin.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.keepplayin.dao.UtilisateurDao;
import fr.keepplayin.model.Publication;
import fr.keepplayin.model.Utilisateur;

public class Publi extends HttpServlet {
	private static final long serialVersionUID = 1L;

   /**
    * Default constructor. 
    */
   public Publi() {
   	super();
       // TODO Auto-generated constructor stub
   }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/connexion.jsp");
//		dis.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String msg = request.getParameter("message");
		HttpSession session = request.getSession();
		Utilisateur auteur = (Utilisateur)session.getAttribute("utilisateur");
		Long id = Long.parseLong(request.getParameter("id"));
		if(auteur != null){
			Publication publi = new Publication(msg, auteur);
			UtilisateurDao userDao = new UtilisateurDao();
			Utilisateur userProfil = userDao.get(id);
			userProfil.ajouterPublication(publi);
			userDao.put(userProfil);
		}
		
		if(id.equals(auteur.getId())){
			response.sendRedirect("/profil");
		}
		else{
			response.sendRedirect("/profil?id="+id);
		}
			
	}
}
