package fr.keepplayin.dao;

import java.util.ArrayList;
import java.util.List;

import fr.keepplayin.model.Instrument;
import fr.keepplayin.model.TypeInstrument;
import fr.keepplayin.model.Utilisateur;

public class InstrumentDao extends BaseDao<Instrument>{
	public InstrumentDao() {
		super(Instrument.class);
	}
	
	public Instrument chercherInstrument(TypeInstrument type) {
		List<Instrument> iList = super.getAll();
		
		for(Instrument i : iList) {
			if (i.getType() == type) {
				return i;
			}
		}
		
		return null;
	}
	
	public Instrument chercherInstrumentPrincipal(Utilisateur u) {
		List<Instrument> iList = super.getAll();
		
		for(Instrument i : iList) {
			if (i.jouePrincipalement(u)) {
				return i;
			}
		}
		
		return null;
	}
	
	public List<Instrument> chercherInstrumentSecondaires(Utilisateur u) {
		List<Instrument> all = super.getAll();
		List<Instrument> iList = new ArrayList<Instrument>();
		
		for(Instrument i : all) {
			if (i.joueSecondairement(u)) {
				iList.add(i);
			}
		}
		
		return iList;
	}
}
