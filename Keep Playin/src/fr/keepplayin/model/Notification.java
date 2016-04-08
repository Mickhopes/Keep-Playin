package fr.keepplayin.model ;

import java.util.Date;

import com.googlecode.objectify.Ref;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
public class Notification {
    @Id Long id ;
    Date dateNotification ;
    String message ;
    boolean vu ;

    public Long getId() {
        return id;
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

    public void setId(Long id) {
        this.id = id;
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
