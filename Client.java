import java.util.Vector;

public class Client {

    // Attributs intrinsèques
    public String nom;
    protected String email;
    public int id;

    // Vecteur pour les commandes associées
    private Vector<Commande> commandes = new Vector<>();

    // Constructeur
    public Client(String nom, String email, int id) {
        this.nom = nom;
        this.email = email;
        this.id = id;
    }

    // Méthodes pour gérer les commandes
    public void addCommande(Commande commande) {
        this.commandes.add(commande);
    }

    public Vector<Commande> getCommandes() {
        return commandes;
    }
}