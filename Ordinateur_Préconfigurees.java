import java.util.Vector;

public class Ordinateur_Préconfigurées extends Commande {

    // Attributs intrinsèques
    public String nom;
    public float prix;
    public int id;
    public String article_offert;
    public String description;

    // Vecteur pour les accessoires ou options
    public Vector<String> accessoires = new Vector<>();

    // Constructeurs
    public Ordinateur_Préconfigurées() {
        super(0, null, null);
        this.nom = "";
        this.prix = 1;
        this.id = 1;
        this.article_offert = "";
        this.description = "";
    }

    public Ordinateur_Préconfigurées(int id_commande, Date date_de_livraison, Date date_commande, String nom, float prix, int id, String article_offert, String description) {
        super(id_commande, date_de_livraison, date_commande);
        this.nom = nom;
        this.prix = prix;
        this.id = id;
        this.article_offert = article_offert;
        this.description = description;
    }

    // Méthodes pour gérer les accessoires
    public void addAccessoire(String accessoire) {
        this.accessoires.add(accessoire);
    }

    public Vector<String> getAccessoires() {
        return accessoires;
    }
}