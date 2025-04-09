import java.io.*;
import java.util.*;

/**
 * 
 */
public class Magazin {

    /**
     * Default constructor
     */
    public Magazin() {
    }

    /**
     * Nom du magasin
     */
    private String Nom;

    /**
     * Liste des produits (par exemple)
     */
    private List<String> produits = new ArrayList<>();

    /**
     * Méthode pour ajouter un produit à la liste
     */
    public void addProduit(String produit) {
        this.produits.add(produit);
    }

    /**
     * Méthode pour définir le nom du magasin
     */
    public void setNom(String nom) {
        this.Nom = nom;
    }

    /**
     * Méthode pour obtenir le nom du magasin
     */
    public String getNom() {
        return this.Nom;
    }
}