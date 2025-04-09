import java.util.Vector;

public class Critere {

    // Attributs intrinsèques
    public String nom;
    public int valeur;

    // Vecteur pour les critères associés
    public Vector<String> sousCriteres = new Vector<>();

    // Constructeur
    public Critere(String nom, int valeur) {
        this.nom = nom;
        this.valeur = "";
    }

    public void addCritere(Critere critere) {
        this.criteres.add(critere);
    }

    public Vector<Critere> getCriteres() {
        return criteres;
    }
}