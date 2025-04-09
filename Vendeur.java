import java.util.Vector;

public class Vendeur {

    // Attributs intrinsèques
    public String nom;
    public int id;

    // Vecteur pour les clients associés
    public Vector<Client> clients = new Vector<>();

    // Constructeur
    public Vendeur(String nom, int id) {
        this.nom = nom;
        this.id = id;
    }

    // Méthodes pour gérer les clients
    public void addClient(Client client) {
        this.clients.add(client);
    }

    public Vector<Client> getClients() {
        return clients;
    }
}