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
import fr.keepplayin.model.Commentaire;
import fr.keepplayin.model.Publication;
import fr.keepplayin.model.Utilisateur;

public class Comm extends HttpServlet {
	private static final long serialVersionUID = 1L;

   /**
    * Default constructor. 
    */
   public Comm() {
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
		Long id_publi = Long.parseLong(request.getParameter("id_publi"));
		
		if(auteur != null){
			Commentaire comm = new Commentaire(msg, auteur);
			PublicationDao publiDao = new PublicationDao();
			Publication p = publiDao.get(id_publi);
			p.ajouterCommentaire(comm);
			publiDao.put(p);
		}
		
		if(id.equals(auteur.getId())){
			response.sendRedirect("/profil");
		}
		else{
			response.sendRedirect("/profil?id="+id);
		}
			
	}
}
