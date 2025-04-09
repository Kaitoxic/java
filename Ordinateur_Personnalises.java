import java.util.Vector;

public class Ordinateur_Personnalises extends Commande {

    // Attributs intrinsèques
    public String nom;
    public int id;
    public float frais_de_montage;
    public boolean cle_windows;

    // Vecteur pour les composants
    public Vector<Composant> composants = new Vector<>();

    public Ordinateur_Personnalises(int id_commande, Date date_de_livraison, Date date_commande, String nom, int id, float frais_de_montage, boolean cle_windows) {
        super(id_commande, date_de_livraison, date_commande);
        this.nom = nom;
        this.id = id;
        this.frais_de_montage = frais_de_montage;
        this.cle_windows = cle_windows;
    }

    // Methodes pour gerer les composants
    public void addComposant(String composant) {
        this.composants.add(composant);
    }

    public Vector<String> getComposants() {
        return composants;
    }
}