import java.io.*;
import java.util.*;

/**
 * Classe représentant un ordinateur préconfiguré avec ses attributs.
 */
public class Ordinateur_Préconfigurées extends Commande {

    // Attributs
    public String nom;
    public float prix;
    public int id;
    public String article_offert;
    public String description;

    // Constructeur par défaut avec valeurs par défaut
    public Ordinateur_Préconfigurées() {
        this.nom = "";
        this.prix = 1;
        this.id = 1;
        this.article_offert = "";
        this.description = "";
    }

    // Constructeur avec tous les paramètres
    public Ordinateur_Préconfigurées(String nom, float prix, int id, String article_offert, String description) {
        this.nom = nom;
        this.prix = prix;
        this.id = id;
        this.article_offert = article_offert;
        this.description = description;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setArticle_offert(String article_offert) {
        this.article_offert = article_offert;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}