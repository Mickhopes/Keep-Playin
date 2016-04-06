package fr.keepplayin.dao;

import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyFactory;
import com.googlecode.objectify.ObjectifyService;

import fr.keepplayin.model.*;


public class OfyService {
    static {
        factory().register(Utilisateur.class);
        factory().register(Commentaire.class);
        factory().register(DemandeAmi.class);
        factory().register(Instrument.class);
        factory().register(Notification.class);
        factory().register(Publication.class);
        factory().register(StyleMusical.class);
    }

    public static ObjectifyFactory factory() {
        return ObjectifyService.factory();
    }

    public static Objectify ofy() {
        return ObjectifyService.ofy();
    }
}