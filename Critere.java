import java.util.Vector;

public class Critere {

    // Attributs intrinsèques
    public String nom;
    public int valeur;

    // Vecteur pour les critères associés
    public Vector<Composant> composant = new Vector<>();

    // Constructeur
    public Critere(String nom, int valeur, Composant composant) {
        this.nom = nom;
        this.valeur = "";
        this.composant.add(composant);
    }

    public void addCritere(Critere critere) {
        this.criteres.add(critere);
    }

    public Vector<Critere> getCriteres() {
        return criteres;
    }
}