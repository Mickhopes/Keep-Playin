package fr.keepplayin.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.keepplayin.dao.InstrumentDao;
import fr.keepplayin.dao.PublicationDao;
import fr.keepplayin.dao.StyleMusicalDao;
import fr.keepplayin.dao.UtilisateurDao;
import fr.keepplayin.model.Commentaire;
import fr.keepplayin.model.Instrument;
import fr.keepplayin.model.Publication;
import fr.keepplayin.model.Style;
import fr.keepplayin.model.StyleMusical;
import fr.keepplayin.model.TypeInstrument;
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
    	// Créer nos instrument si ils n'existent pas
    	InstrumentDao daoI = new InstrumentDao();
    	List<Instrument> listI = daoI.getAll();
    	
    	for(TypeInstrument t : TypeInstrument.values()) {
    		Instrument i = new Instrument(t);
    		if (!listI.contains(i)) {
    			daoI.put(i);
    		}
    	}
    	
    	// Créer nos styles si ils n'existent pas
    	StyleMusicalDao daoS = new StyleMusicalDao();
    	List<StyleMusical> listS = daoS.getAll();
    	
    	for(Style s : Style.values()) {
    		StyleMusical st = new StyleMusical(s);
    		if (!listS.contains(st)) {
    			daoS.put(st);
    		}
    	}
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
			response.sendRedirect("/profil");
		}
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
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
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
					HttpSession session = request.getSession();
					session.setAttribute("utilisateur", user);
					response.sendRedirect("/profil");
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