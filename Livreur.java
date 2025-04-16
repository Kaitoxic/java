import java.util.Vector;

public class Livreur {

    // Attributs intrinsèques
    public String transporteur;
    public boolean est_tracquable;

    // Vecteur pour les commandes livrees
    public Vector<Commande> commandesLivrees = new Vector<>();
    public Vector<Magazin> magazin = new Vector<>();

    // Constructeur
    public Livreur(String transporteur, boolean est_tracquable, Magazin magazin) {
        this.transporteur = transporteur;
        this.est_tracquable = est_tracquable;
        this.magazin.add(magazin);
    }

    // Methodes pour gerer les commandes livrees
    public void addCommandeLivree(Commande commande) {
        this.commandesLivrees.add(commande);
    }

    public Vector<Commande> getCommandesLivrees() {
        return commandesLivrees;
    }

    public void addMagazin(Magazin magazin) {
        this.magazin.add(magazin);
    }
    public Vector<Magazin> getMagazin() {
        return magazin;
    }
    public void setMagazin(Vector<Magazin> magazin) {
        this.magazin = magazin;
    }
}