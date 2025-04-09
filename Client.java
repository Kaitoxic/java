import java.util.Vector;

public class Client {

    // Attributs intrinsèques
    public String nom;
    protected String email;
    public int id;

    // Vecteur pour les commandes associees
    private Vector<Commande> commandes = new Vector<>();
    private Vector<Magazin> magazin = new Vector<>();

    // Constructeur
    public Client(String nom, String email, int id, Magazin magazin) {
        this.nom = nom;
        this.email = email;
        this.id = id;
        this.magasins.add(magazin);
    }

    // Methodes pour gerer les commandes
    public void addCommande(Commande commande) {
        this.commandes.add(commande);
    }

    public Vector<Commande> getCommandes() {
        return commandes;
    }

    public void addMagazin(Magazin magazin) {
        this.magazin.add(magazin);
    }
    public Vector<Magazin> getMagazin() {
        return magazin;
    }
    public void setMagazin(Magazin magazin) {
        this.magazin = magazin;
    }
}