import java.util.Vector;

public class Critere {

    // Attributs intrinsèques
    public String nom;
    public int valeur;

    // Vecteur pour les critères associés
    public Vector<Composants> composant = new Vector<>();

    // Constructeur
    public Critere(String nom, int valeur, Composants composant) {
        this.nom = nom;
        this.valeur = 0;
        this.composant.add(composant);
    }

    // Méthodes pour gérer les composants
    public void addComposant(Composants composant) {
        this.composant.add(composant);
    }
    public Vector<Composants> getComposant() {
        return composant;
    }
    public void setComposant(Vector<Composants> composant) {
        this.composant = composant;
    }
}