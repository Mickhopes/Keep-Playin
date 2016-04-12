package fr.keepplayin.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.keepplayin.dao.PublicationDao;
import fr.keepplayin.dao.UtilisateurDao;
import fr.keepplayin.model.Publication;
import fr.keepplayin.model.Utilisateur;

public class Modification extends HttpServlet {
	private static final long serialVersionUID = 1L;

   /**
    * Default constructor. 
    */
   public Modification() {
   	super();
       // TODO Auto-generated constructor stub
   }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/modif-profil.jsp");
		dis.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// On récupère tous les paramètres à changer
		String prenom = request.getParameter("prenom");
		String nom = request.getParameter("nom");
		String nomDeScene = request.getParameter("nomDeScene");
		String oldPassword = request.getParameter("old-password");
		String password = request.getParameter("password");
		String jour = request.getParameter("jour");
		String mois = request.getParameter("mois");
		String annee = request.getParameter("annee");
		String sexe = request.getParameter("gender");
		String dpt = request.getParameter("dpt");
		String instrumentPrincipal = request.getParameter("instrument-principal");
		String niveauInstrument = request.getParameter("niv-instrument");
		String jourApprenti = request.getParameter("jour-apprenti");
		String moisApprenti = request.getParameter("mois-apprenti");
		String anneeApprenti = request.getParameter("annee-apprenti");

		// Tester si l'ancien password est pas le bon : on redirige sur la même jsp avec erreur !
		
		// Sinon on teste les valeurs et on met à jour
		
		
		
		
//		RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/profil.jsp");
//		dis.forward(request, response);
	}
}