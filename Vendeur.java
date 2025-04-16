import java.util.Vector;

public class Vendeur {

    // Attributs intrinsèques
    public String nom;
    public int id;

    // Vecteur pour les magasins et ordinateurs préconfigurés associés
    public Vector<Magazin> magazin = new Vector<>();
    public Vector<Ordinateur_Preconfigurees> ordinateur = new Vector<>();

    // Constructeur
    public Vendeur(String nom, int id, Magazin magazin, Ordinateur_Preconfigurees ordinateur) {
        this.nom = nom;
        this.id = id;
        this.magazin.add(magazin);
        this.ordinateur.add(ordinateur);
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

    // Méthodes pour gérer les ordinateurs préconfigurés
    public void addOrdinateur(Ordinateur_Preconfigurees ordinateur) {
        this.ordinateur.add(ordinateur);
    }

    public Vector<Ordinateur_Preconfigurees> getOrdinateur() {
        return ordinateur;
    }

    public void setOrdinateur(Vector<Ordinateur_Preconfigurees> ordinateur) {
        this.ordinateur = ordinateur;
    }
}