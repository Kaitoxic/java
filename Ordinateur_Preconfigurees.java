import java.util.Vector;
import java.util.Date;

public class Ordinateur_Preconfigurees extends Commande {

    // Attributs intrinsèques
    public String nom;
    public float prix;
    public int id;
    public String article_offert;
    public String description;

    public Vector<Vendeur> vendeur = new Vector<>();

    public Ordinateur_Preconfigurees(String nom, float prix, int id, int id_commande, Date date_de_livraison, Date date_commande, Client client, Livreur livreur, Vendeur vendeur, String article_offert, String description) {
        super(id_commande, date_de_livraison, date_commande, client, livreur);
        this.nom = nom;
        this.prix = prix;
        this.id = id;
        this.article_offert = article_offert;
        this.description = description;
        this.vendeur.add(vendeur);
    }

    // Méthodes pour gérer les vendeurs
    public void addVendeur(Vendeur vendeur) {
        this.vendeur.add(vendeur);
    }
    public Vector<Vendeur> getVendeur() {
        return vendeur;
    }
    public void setVendeur(Vector<Vendeur> vendeur) {
        this.vendeur = vendeur;
    }
    // Méthodes pour gérer les prix
    public void setPrix(float prix) {
        this.prix = prix;
    }
    public float getPrix() {
        return prix;
    }
    // Méthodes pour gérer les articles offerts
    public void setArticleOffert(String article_offert) {
        this.article_offert = article_offert;
    }
    public String getArticleOffert() {
        return article_offert;
    }
    // Méthodes pour gérer les descriptions
    public void setDescription(String description) {
        this.description = description;
    }
    public String getDescription() {
        return description;
    }
    // Méthodes pour gérer les noms
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getNom() {
        return nom;
    }
    // Méthodes pour gérer les IDs
    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }
    // Méthodes pour gérer les commandes
    public void setId_commande(int id_commande) {
        this.id_commande = id_commande;
    }
    public int getId_commande() {
        return id_commande;
    }
    // Méthodes pour gérer les dates de livraison
    public void setDate_de_livraison(Date date_de_livraison) {
        this.date_de_livraison = date_de_livraison;
    }
    public Date getDate_de_livraison() {
        return date_de_livraison;
    }
    // Méthodes pour gérer les dates de commande
    public void setDate_commande(Date date_commande) {
        this.date_commande = date_commande;
    }
    public Date getDate_commande() {
        return date_commande;
    }
}