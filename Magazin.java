import java.util.Vector;

public class Magazin {

    // Attributs intrinsèques
    public String nom;
    public String adresse;

    // Vecteur pour les vendeurs et les clients
    public Vector<Vendeur> vendeurs = new Vector<>();
    public Vector<Client> clients = new Vector<>();
    public Vector<Livreur> livreur = new Vector<>();
    public Vector<Composants> composants = new Vector<>();

    // Constructeur
    public Magazin(String nom, String adresse) {
        this.nom = nom;
        this.adresse = adresse;
    }

    // Méthodes pour gérer les vendeurs
    public void addVendeur(Vendeur vendeur) {
        this.vendeurs.add(vendeur);
    }

    public Vector<Vendeur> getVendeurs() {
        return vendeurs;
    }

    // Méthodes pour gérer les clients
    public void addClient(Client client) {
        this.clients.add(client);
    }

    public Vector<Client> getClients() {
        return clients;
    }
}