import java.io.*;
import java.util.*;

/**
 * Classe représentant un vendeur associé à un produit.
 */
public class Vendeur {

    // Attribut
    public int id_produit;

    // Constructeur par défaut avec valeur par défaut
    public Vendeur() {
        this.id_produit = 1;
    }

    // Constructeur avec paramètre
    public Vendeur(int id_produit) {
        this.id_produit = id_produit;
    }

    // Setter
    public void setId_produit(int id_produit) {
        this.id_produit = id_produit;
    }
}