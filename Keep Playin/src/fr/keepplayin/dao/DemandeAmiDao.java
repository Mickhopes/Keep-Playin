package fr.keepplayin.dao;

import java.util.ArrayList;
import java.util.List;

import com.googlecode.objectify.Ref;

import fr.keepplayin.model.DemandeAmi;
import fr.keepplayin.model.Utilisateur;

public class DemandeAmiDao extends BaseDao<DemandeAmi> {
	public DemandeAmiDao() {
		super(DemandeAmi.class);
	}
	
	public boolean estEnAttente(Utilisateur source, Utilisateur cible) {
		List<DemandeAmi> dList = super.getAll();
		
		for(DemandeAmi d : dList) {
			if (d.getSource().getId().equals(source.getId()) && d.getCible().getId().equals(cible.getId())) {
				return !d.isAcceptee();
			}
		}
		
		return false;
	}
	
	public DemandeAmi chercherDemande(Utilisateur source, Utilisateur cible) {
		List<DemandeAmi> dList = super.getAll();
		
		for(DemandeAmi d : dList) {
			if (d.getSource().getId().equals(source.getId()) && d.getCible().getId().equals(cible.getId())) {
				return d;
			}
		}
		
		return null;
	}
	
	public int nombreDemandeAttente(Utilisateur cible) {
		List<DemandeAmi> dList = super.getAll();
		
		int i = 0;
		for(DemandeAmi d : dList) {
			if (d.getCible().getId().equals(cible.getId()) && !d.isAcceptee()) {
				i++;
			}
		}
		
		return i;
	}
	
	public List<DemandeAmi> chercherDemande(Utilisateur cible) {
		List<DemandeAmi> dList = new ArrayList<DemandeAmi>();
		List<DemandeAmi> all = super.getAll();
		
		for(DemandeAmi d : all) {
			if (d.getCible().getId().equals(cible.getId()) && !d.isAcceptee()) {
				dList.add(d);
			}
		}
		
		return dList;
	}
}
