import java.util.Vector;

public class Composants {

    // Attributs intrinsèques
    public String nom;
    public String type;
    public float prix;
    

    public Vector<Ordinateur_Personnalises> ordinateurs = new Vector<>();

    // Constructeur
    public Composants(String nom, float prix, String type) {
        this.nom = nom;
        this.prix = prix;
        this.type = type;
    }    

    public String getNom() {
        return nom;
    }

    public float getPrix() {
        return prix;
    }

    public String getType() {
        return type;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    public void setPrix(float prix) {
        this.prix = prix;
    }
    public void setType(String type) {
        this.type = type;
    }
}