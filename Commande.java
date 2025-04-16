import java.util.Date;
import java.util.Vector;

public class Commande {

    // Attributs intrinsèques
    public int id_commande;
    public Date date_de_livraison;
    public Date date_commande;

    public Vector<Client> client = new Vector<>();
    public Vector<Livreur> livreur = new Vector<>();

    // Constructeur
    public Commande(int id_commande, Date date_de_livraison, Date date_commande, Client client, Livreur livreur) {
        this.id_commande = id_commande;
        this.date_de_livraison = date_de_livraison;
        this.date_commande = date_commande;
        this.client.add(client);
        this.livreur.add(livreur);
    }

    // Méthodes pour gérer les clients
    public void addClient(Client client) {
        this.client.add(client);
    }
    public Vector<Client> getClient() {
        return client;
    }
    public void setClient(Vector<Client> client) {
        this.client = client;
    }
    // Méthodes pour gérer les livreurs
    public void addLivreur(Livreur livreur) {
        this.livreur.add(livreur);
    }
    public Vector<Livreur> getLivreur() {
        return livreur;
    }
    public void setLivreur(Vector<Livreur> livreur) {
        this.livreur = livreur;
    }
    
}