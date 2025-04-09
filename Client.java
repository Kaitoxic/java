import java.io.*;
import java.util.*;

/**
 * 
 */
public class Client {

    /**
     * Default constructor
     */
    public Client(String nom, String email, int id) {
        this.nom = nom;
        this.email = email;
        this.id = id;
    }

    /**
     * Nom du client
     */
    public String nom;

    /**
     * Email du client
     */
    protected String email;

    /**
     * Identifiant du client
     */
    public int id;

    /**
     * Liste des commandes associées au client
     */
    private Vector<String> commandes = new Vector<>();

    // Méthodes pour gérer les attributs

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public String getEmail() {
        return email;
    }

    public int getId() {
        return id;
    }

    // Méthode pour ajouter une commande
    public void addCommande(String commande) {
        this.commandes.add(commande);
    }

    // Méthode pour définir la liste des commandes
    public void setCommandes(Vector<String> commandes) {
        this.commandes = commandes;
    }

    // Méthode pour récupérer la liste des commandes
    public Vector<String> getCommandes() {
        return commandes;
    }
}