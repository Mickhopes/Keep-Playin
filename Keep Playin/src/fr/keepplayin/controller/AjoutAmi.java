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
import fr.keepplayin.model.Commentaire;
import fr.keepplayin.model.DemandeAmi;
import fr.keepplayin.model.Publication;
import fr.keepplayin.model.Utilisateur;

public class AjoutAmi extends HttpServlet {
	private static final long serialVersionUID = 1L;

   /**
    * Default constructor. 
    */
   public AjoutAmi() {
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
		HttpSession session = request.getSession();
		Utilisateur cible = (Utilisateur)session.getAttribute("utilisateur");
		Long id = Long.parseLong(request.getParameter("id"));
		Long id_demande = Long.parseLong(request.getParameter("id_demande"));
		String choix = request.getParameter("choix");
		
		if(cible != null){
			DemandeAmiDao daoD = new DemandeAmiDao();
			
			if (choix.equals("accepter")) {
				DemandeAmi d = daoD.get(id_demande);
				d.setAcceptee(true);
				daoD.put(d);
				
				UtilisateurDao daoU = new UtilisateurDao();
				Utilisateur source = daoU.get(id);
				cible.ajouterAmi(source);
				source.ajouterAmi(cible);
				daoU.put(cible);
				daoU.put(source);
			} else {
				daoD.delete(id_demande);
			}
			
			response.sendRedirect("/demandeAmi");
		} else {
			response.sendRedirect("/index");
		}
	}
}
