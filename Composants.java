
public class Composants {

    // Attributs intrinsèques
    public String nom;
    public float prix;

    public Vector<Critere> criteres = new Vector<>();


    // Constructeur
    public Composants(String nom, float prix) {
        this.nom = nom;
        this.prix = prix;
    }

    
}