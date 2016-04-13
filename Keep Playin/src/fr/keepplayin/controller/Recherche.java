package fr.keepplayin.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;

import fr.keepplayin.dao.UtilisateurDao;
import fr.keepplayin.model.Niveau;
import fr.keepplayin.model.TypeInstrument;
import fr.keepplayin.model.Utilisateur;

/**
 * Servlet implementation class Init
 */
public class Recherche extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Recherche() {
        // TODO Auto-generated constructor stub
    }
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String recherche = request.getParameter("recherche");
		String type = request.getParameter("type");
		String niveau = request.getParameter("niveau");
		TypeInstrument t = null;
		Niveau n = null;
		
		if (type != null && !type.equals("")) {
			t = TypeInstrument.values()[Integer.parseInt(type)];
		}
		
		if (niveau != null && !niveau.equals("")) {
			n = Niveau.values()[Integer.parseInt(niveau)];
		}
		
		// todo : recherche utilisateur
		UtilisateurDao userDao = new UtilisateurDao();
		List<Utilisateur> listeUsers = userDao.chercherUtilisateur(recherche, t, n);
		
		request.setAttribute("resultats", listeUsers);
		RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/recherche.jsp");
		dis.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}