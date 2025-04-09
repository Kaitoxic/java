import java.io.*;
import java.util.*;

/**
 * Classe représentant un ordinateur simple avec ses attributs.
 */
public class Ordinateur {

    // Attributs
    public String nom;
    public float prix;
    public int id;

    // Constructeur par défaut avec valeurs par défaut
    public Ordinateur() {
        this.nom = "";
        this.prix = 1;
        this.id = 1;
    }

    // Constructeur avec tous les paramètres
    public Ordinateur(String nom, float prix, int id) {
        this.nom = nom;
        this.prix = prix;
        this.id = id;
    }

    // Setters
    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public void setId(int id) {
        this.id = id;
    }
}
