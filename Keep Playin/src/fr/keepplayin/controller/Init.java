package fr.keepplayin.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.UnknownHostException;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
public class Init extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Init() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init() throws ServletException {
    	// Charger les object Objectify
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* Redirection vers la jsp */
		RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/index.jsp");
		HttpSession session = request.getSession();
		Utilisateur user = (Utilisateur) session.getAttribute("utilisateur");
		if (user == null) {
			dis.forward(request, response);
		} else {
			response.sendRedirect("Profil");
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
		String prenom = request.getParameter("prenom");
		String nom = request.getParameter("nom");
		String mail = request.getParameter("email");
		String password = request.getParameter("password");
		String jour_birthday = request.getParameter("jour");
		String mois_birthday = request.getParameter("mois");
		String annee_birthday = request.getParameter("annee");
		String genre = request.getParameter("gender");

		if (mail != null && password != null && prenom != null && nom!= null && jour_birthday != null && mois_birthday != null && annee_birthday != null & genre != null) {
			SimpleDateFormat formatter = new SimpleDateFormat("dd/mm/yyyy");
			String birthday;
			if(Integer.parseInt(jour_birthday) < 10){
				birthday = "0"+jour_birthday+"/"+mois_birthday+"/"+annee_birthday;
			}
			else{
				birthday = jour_birthday+"/"+mois_birthday+"/"+annee_birthday;
			}
			try{
				Date birthdayDate = formatter.parse(birthday);
				UtilisateurDao userDao = new UtilisateurDao();
				System.out.println(userDao.chercherEmail(mail));
				if (userDao.chercherEmail(mail) == null){
					Utilisateur user = new Utilisateur(nom,prenom,null,mail,password,birthdayDate,genre);
					userDao.put(user);
					response.sendRedirect("profil?etat=succes");
				}
				else{
					response.sendRedirect("Init?erreur=utilise");
				}
				
			}catch(ParseException e){
				e.printStackTrace();
			}
		}
	}
}