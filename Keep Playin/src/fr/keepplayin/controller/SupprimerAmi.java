package fr.keepplayin.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.keepplayin.dao.DemandeAmiDao;
import fr.keepplayin.dao.PublicationDao;
import fr.keepplayin.dao.UtilisateurDao;
import fr.keepplayin.model.DemandeAmi;
import fr.keepplayin.model.Publication;
import fr.keepplayin.model.Utilisateur;

public class SupprimerAmi extends HttpServlet {
	private static final long serialVersionUID = 1L;

   /**
    * Default constructor. 
    */
   public SupprimerAmi() {
   	super();
       // TODO Auto-generated constructor stub
   }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long id = Long.parseLong(request.getParameter("id"));
		
		HttpSession session = request.getSession();
		UtilisateurDao dao = new UtilisateurDao();
		Utilisateur source = (Utilisateur)session.getAttribute("utilisateur");
		Utilisateur cible = dao.get(id);
		
		source.supprimerAmi(cible);
		cible.supprimerAmi(source);
		
		dao.put(source);
		dao.put(cible);
		
		response.sendRedirect("/profil?id=" + id);
	}
}
