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
import fr.keepplayin.dao.InstrumentDao;
import fr.keepplayin.dao.PublicationDao;
import fr.keepplayin.dao.UtilisateurDao;
import fr.keepplayin.model.Instrument;
import fr.keepplayin.model.Publication;
import fr.keepplayin.model.Utilisateur;
import fr.keepplayin.model.Niveau;
import fr.keepplayin.model.TypeInstrument;

public class ModifInstrument extends HttpServlet {
	private static final long serialVersionUID = 1L;

   /**
    * Default constructor. 
    */
   public ModifInstrument() {
   	super();
       // TODO Auto-generated constructor stub
   }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UtilisateurDao dao = new UtilisateurDao();
		HttpSession session = request.getSession();
		Utilisateur u = (Utilisateur) session.getAttribute("utilisateur");
		
		if (u != null) {
			// On refresh l'utilisateur en session
			session.setAttribute("utilisateur", dao.get(u.getId()));
			
			RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/modif-instrument.jsp");
			dis.forward(request, response);
		} else {
			response.sendRedirect("/index");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// On récupère tous les paramètres à changer
		String instrumentPrincipal = request.getParameter("instrument-principal");
		String niveauInstrument = request.getParameter("niv-instrument");
		String jourApprenti = request.getParameter("jour-apprenti");
		String moisApprenti = request.getParameter("mois-apprenti");
		String anneeApprenti = request.getParameter("annee-apprenti");
		

		HttpSession session = request.getSession();
		UtilisateurDao daoU = new UtilisateurDao();
		InstrumentDao daoI = new InstrumentDao();
		Utilisateur user = (Utilisateur) session.getAttribute("utilisateur");
		
		if (instrumentPrincipal != null && !instrumentPrincipal.equals("")) {
			Instrument i = daoI.chercherInstrumentPrincipal(user);
			Instrument select = daoI.chercherInstrument(TypeInstrument.values()[Integer.parseInt(instrumentPrincipal)]);

			if (i != null && i.getType() != select.getType()) {
				i.supprimerPratiquantPrincipal(user);
				daoI.put(i);
			}

			select.ajouterPratiquantPrincipal(user);
			daoI.put(select);
			
			user.setInstrumentPrincipal(select);
			user.setNiveauInstrumentPrincipal(Niveau.values()[Integer.parseInt(niveauInstrument)]);
			
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			String naissance;
			if(Integer.parseInt(jourApprenti) < 10){
				naissance = "0"+jourApprenti+"/"+moisApprenti+"/"+anneeApprenti;
			}
			else{
				naissance = jourApprenti+"/"+moisApprenti+"/"+anneeApprenti;
			}
			try{
				Date apprentissageDate = formatter.parse(naissance);
				user.setDebutApprentissage(apprentissageDate);
			}catch(ParseException e){
				e.printStackTrace();
			}
			daoU.put(user);
			
		} else {
			Instrument i = daoI.chercherInstrumentPrincipal(user);
			if (i != null) {
				i.supprimerPratiquantPrincipal(user);
				user.setInstrumentPrincipal(null);
			}
		}
		
		response.sendRedirect("/profil");
	}
}