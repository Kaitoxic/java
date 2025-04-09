import java.util.Date;
import java.util.Vector;

public class Commande {

    // Attributs intrinsèques
    public int id_commande;
    public Date date_de_livraison;
    public Date date_commande;

    // Constructeur
    public Commande(int id_commande, Date date_de_livraison, Date date_commande) {
        this.id_commande = id_commande;
        this.date_de_livraison = date_de_livraison;
        this.date_commande = date_commande;
    }

    // Méthodes pour gérer les produits
    public void addProduit(String produit) {
        this.produits.add(produit);
    }