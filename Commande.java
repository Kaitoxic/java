import java.io.*;
import java.util.*;

/**
 * 
 */
public class Commande {

    /**
     * Default constructor
     */
    public Commande(int id_commande, Date date_de_livraison, Date date_commande) {
        this.id_commande = id_commande;
        this.date_de_livraison = date_de_livraison;
        this.date_commande = date_commande;
        this.produits = new Vector<>();
    }

    /**
     * 
     */
    public int id_commande;

    /**
     * 
     */
    public Date date_de_livraison;

    /**
     * 
     */
    public Date date_commande;

    /**
     * Liste des produits associés à la commande
     */
    public Vector<String> produits;

    public void setId_commande(int id_commande) {
        this.id_commande = id_commande;
    }
    
    public void setDate_de_livraison(Date date_de_livraison) {
        this.date_de_livraison = date_de_livraison;
    }

    public void setDate_commande(Date date_commande) {
        this.date_commande = date_commande;
    }

    public int getId_commande() {
        return id_commande;
    }

    public Date getDate_de_livraison() {
        return date_de_livraison;
    }

    public Date getDate_commande() {
        return date_commande;
    }

    /**
     * Ajoute un produit à la liste des produits
     */
    public void addProduit(String produit) {
        this.produits.add(produit);
    }

    /**
     * Définit la liste complète des produits
     */
    public void setProduits(Vector<String> produits) {
        this.produits = produits;
    }

    /**
     * Retourne la liste des produits
     */
    public Vector<String> getProduits() {
        return produits;
    }
}