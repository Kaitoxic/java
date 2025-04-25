import java.util.Vector;

public class Client {

    // Attributs intrinsèques
    public String nom;
    protected String email;
    public int id;

    // Vecteur pour les commandes associées
    private Vector<Commande> commandes = new Vector<>();
    private Vector<Magazin> magazin = new Vector<>();

    // Constructeur
    public Client(String nom, String email, int id, Magazin magazin) {
        this.nom = nom;
        this.email = email;
        this.id = id;
        this.magazin.add(magazin);
    }

    // Méthodes pour gérer les commandes
    public void addCommande(Commande commande) {
        this.commandes.add(commande);
    }

    public Vector<Commande> getCommandes() {
        return commandes;
    }

    // Méthodes pour gérer les magasins
    public void addMagazin(Magazin magazin) {
        this.magazin.add(magazin);
    }

    public Vector<Magazin> getMagazin() {
        return magazin;
    }

    public void setMagazin(Vector<Magazin> magazin) {
        this.magazin = magazin;
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
    public void setNom(String nom) {
        this.nom = nom;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setId(int id) {
        this.id = id;
    }
}