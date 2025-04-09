import java.io.*;
import java.util.*;

public class Ordinateur_Personnalisés extends Commande {

    public String nom;
    public int id;
    public float frais_de_montage;
    public boolean cle_windows;

    public Vector<String> composants = new Vector<>();

    public Ordinateur_Personnalisés() {
        this.nom = "";
        this.id = 1;
        this.frais_de_montage = 1;
        this.cle_windows = true;
    }

    public Ordinateur_Personnalisés(String nom, int id, float frais_de_montage, boolean cle_windows) {
        this.nom = nom;
        this.id = id;
        this.frais_de_montage = frais_de_montage;
        this.cle_windows = cle_windows;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFrais_de_montage(float frais_de_montage) {
        this.frais_de_montage = frais_de_montage;
    }

    public void setCle_windows(boolean cle_windows) {
        this.cle_windows = cle_windows;
    }

    public void addComposant(String composant) {
        this.composants.add(composant);
    }
}