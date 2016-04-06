package fr.keepplayin.model ;

import java.util.List;

public class StyleMusical {
    int id ;
    Style style ;
    List<Utilisateur> amateurs ;

    public int getId() {
        return id;
    }

    public Style getStyle() {
        return style;
    }

    public List<Utilisateur> getAmateurs() {
        return amateurs;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStyle(Style style) {
        this.style = style;
    }

    public void setAmateurs(List<Utilisateur> amateurs) {
        this.amateurs = amateurs;
    }
}
