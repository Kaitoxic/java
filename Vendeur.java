import java.util.Vector;

public class Vendeur {

    // Attributs intrinsèques
    public String nom;
    public int id;

    // Vecteur pour les clients associes
    public Vector<Client> clients = new Vector<>();
    public Vector<Magazin> magazin = new Vector<>();
    public Vector<Ordinateur_Preconfigurees> ordinateur = new Vector<>();

    // Constructeur
    public Vendeur(String nom, int id, Magazin magazin, Ordinateur_Preconfigurees ordinateur) {
        this.nom = nom;
        this.id = id;
        this.magazin.add(magazin);
        this.ordinateur.add(ordinateur);
    }

    // Methodes pour gerer les clients
    public void addClient(Client client) {
        this.clients.add(client);
    }

    public Vector<Client> getClients() {
        return clients;
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