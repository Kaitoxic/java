import java.util.Vector;

public class Livreur {

    // Attributs intrinsèques
    public String transporteur;
    public boolean est_tracquable;

    // Vecteur pour les commandes livrées
    public Vector<Commande> commandesLivrees = new Vector<>();

    // Constructeur
    public Livreur(String transporteur, boolean est_tracquable) {
        this.transporteur = transporteur;
        this.est_tracquable = est_tracquable;
    }

    // Méthodes pour gérer les commandes livrées
    public void addCommandeLivree(Commande commande) {
        this.commandesLivrees.add(commande);
    }

    public Vector<Commande> getCommandesLivrees() {
        return commandesLivrees;
    }
}