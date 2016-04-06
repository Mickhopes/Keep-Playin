package fr.keepplayin.model ;

import java.util.Date;

public class Notification {
    int id ;
    Utilisateur cible ;
    Date dateNotification ;
    String message ;
    boolean vu ;

    public int getId() {
        return id;
    }

    public Utilisateur getCible() {
        return cible;
    }

    public Date getDateNotification() {
        return dateNotification;
    }

    public String getMessage() {
        return message;
    }

    public boolean isVu() {
        return vu;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCible(Utilisateur cible) {
        this.cible = cible;
    }

    public void setDateNotification(Date dateNotification) {
        this.dateNotification = dateNotification;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setVu(boolean vu) {
        this.vu = vu;
    }
}
