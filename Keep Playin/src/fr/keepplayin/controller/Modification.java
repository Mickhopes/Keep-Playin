package fr.keepplayin.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.keepplayin.dao.DemandeAmiDao;
import fr.keepplayin.dao.PublicationDao;
import fr.keepplayin.dao.UtilisateurDao;
import fr.keepplayin.model.Departement;
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
		UtilisateurDao dao = new UtilisateurDao();
		DemandeAmiDao daoD = new DemandeAmiDao();
		HttpSession session = request.getSession();
		Utilisateur u = (Utilisateur) session.getAttribute("utilisateur");
		
		if (u != null) {
			// On refresh l'utilisateur en session
			session.setAttribute("utilisateur", dao.get(u.getId()));
			session.setAttribute("nombreDemande", daoD.nombreDemandeAttente(u));
			
			RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/modif-profil.jsp");
			dis.forward(request, response);
		} else {
			response.sendRedirect("/index");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// On r�cup�re tous les param�tres � changer
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

		// Tester si l'ancien password est pas le bon : on redirige sur la m�me jsp avec erreur !
		HttpSession session = request.getSession();
		UtilisateurDao dao = new UtilisateurDao();
		Utilisateur user = (Utilisateur) session.getAttribute("utilisateur");
		if (oldPassword != null && !oldPassword.equals("")) {
			if (!user.getMdp().equals(oldPassword)) {
				response.sendRedirect("/modif?erreur=mauvaismdp");
				return;
			} else {
				if (oldPassword.equals(password)) {
					response.sendRedirect("/modif?erreur=mememdp");
					return;
				} else {
					if (password != null && !password.equals("")) {
						user.setMdp(password);
					}
				}
			}
		} else {
			if (password != null && !password.equals("")) {
				response.sendRedirect("/modif?erreur=ancienmdp");
				return;
			}
		}
		
		// Sinon on teste les valeurs et on met � jour
		if (prenom != null && !prenom.equals("")) {
			user.setPrenom(prenom);
		}
		
		if (nom != null && !nom.equals("")) {
			user.setNom(nom);
		}
		
		if (nomDeScene != null && !nomDeScene.equals("")) {
			user.setNomDeScene(nomDeScene);
		}
		
		if (sexe != null && !sexe.equals("")) {
			user.setSexe(sexe);
		}
		
		if (dpt != null && !dpt.equals("")) {
			user.setDpt(Departement.values()[Integer.parseInt(dpt)]);
		}
		
		String naissance;
		if (jour != null && mois != null && annee != null) {
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			if(Integer.parseInt(jour) < 10){
				naissance = "0"+jour+"/"+mois+"/"+annee;
			}
			else{
				naissance = jour+"/"+mois+"/"+annee;
			}
			try{
				Date naissanceDate = formatter.parse(naissance);
				user.setDateDeNaissance(naissanceDate);
			}catch(ParseException e){
				e.printStackTrace();
			}
		}
		
		// On sauvegarde l'utilisateur
		dao.put(user);
		
		RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/profil.jsp");
		dis.forward(request, response);
	}
}