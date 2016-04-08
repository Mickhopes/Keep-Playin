package fr.keepplayin.dao;

import java.util.List;

import fr.keepplayin.model.Utilisateur;
import static fr.keepplayin.dao.OfyService.ofy;

public class UtilisateurDao extends BaseDao<Utilisateur>{
	public UtilisateurDao() {
		super(Utilisateur.class);
	}
	
	public Utilisateur chercherEmail(String email) {
		return query().filter("email ==", email).first().now();
	}
}
