package fr.keepplayin.dao;

import java.util.ArrayList;
import java.util.List;

import fr.keepplayin.model.Niveau;
import fr.keepplayin.model.TypeInstrument;
import fr.keepplayin.model.Utilisateur;
import static fr.keepplayin.dao.OfyService.ofy;

public class UtilisateurDao extends BaseDao<Utilisateur>{
	public UtilisateurDao() {
		super(Utilisateur.class);
	}
	
	public Utilisateur chercherEmail(String email) {
		return query().filter("email ==", email).first().now();
	}
	
	public List<Utilisateur> chercherUtilisateur(String field, String value) {
		return query().filter(field + " >=", value).filter(field + " <", value + "\uFFFD").list();
	}
	
	public List<Utilisateur> chercherUtilisateur(String recherche) {
		List<Utilisateur> uList = new ArrayList<Utilisateur>();
		List<Utilisateur> all = super.getAll();
		
		for(Utilisateur u : all) {
			if ((u.getPrenom() + " " + u.getNom()).toLowerCase().startsWith(recherche.toLowerCase())) {
				uList.add(u);
			}
		}
		
		return uList;
	}
	
	public List<Utilisateur> chercherUtilisateur(String recherche, TypeInstrument type, Niveau niveau) {
		List<Utilisateur> uList = new ArrayList<Utilisateur>();
		List<Utilisateur> all = super.getAll();
		
		for(Utilisateur u : all) {
			if ((u.getPrenom() + " " + u.getNom()).toLowerCase().startsWith(recherche.toLowerCase())) {
				if (type == null) {
					uList.add(u);
				} else {
					if (u.getInstrumentPrincipal() != null && u.getInstrumentPrincipal().getType() == type) {
						if (niveau == null) {
							uList.add(u);
						} else {
							if (u.getNiveauInstrumentPrincipal() != null && u.getNiveauInstrumentPrincipal() == niveau) {
								uList.add(u);
							}
						}
					}
				}
			}
		}
		
		return uList;
	}
}
