
import java.io.*;
import java.util.*;

/**
 * 
 */
public class Critere {

    /**
     * Default constructor
     */
    public Critere(String nom, String valeur) {
        this.nom = nom;
        this.valeur = valeur;
    }

    /**
     * 
     */
    public String nom;

    /**
     * 
     */
    public String valeur;

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setValeur(String valeur) {
        this.valeur = valeur;
    }

    public String getNom() {
        return nom;
    }

    public String getValeur() {
        return valeur;
    }
}