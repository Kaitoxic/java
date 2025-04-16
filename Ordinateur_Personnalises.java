import java.util.Vector;
import java.util.Date;


public class Ordinateur_Personnalises extends Commande {

    // Attributs intrinsèques
    public String nom;
    public int id;
    public float frais_de_montage;
    public boolean cle_windows;

    // Vecteur pour les composants
    public Vector<Composants> composants = new Vector<>();

    public Ordinateur_Personnalises(String nom, int id, float frais_de_montage, int id_commande, Date date_de_livraison, Date date_commande, Client client, Livreur livreur, boolean cle_windows) {
        super(id_commande, date_de_livraison, date_commande, client, livreur);
        this.nom = nom;
        this.id = id;
        this.frais_de_montage = frais_de_montage;
        this.cle_windows = cle_windows;
    }

    // Methodes pour gerer les composants
    public void addComposant(Composants composant) {
        this.composants.add(composant);
    }

    public Vector<Composants> getComposants() {
        return composants;
    }
}