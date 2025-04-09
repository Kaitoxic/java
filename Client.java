
import java.io.*;
import java.util.*;

/**
 * 
 */
public class Client {

    /**
     * Default constructor
     */
    public Client(String nom, String email, int id) {
        this.nom = nom;
        this.email = email;
        this.id = id;
    }

    /**
     * 
     */
    public String nom;

    /**
     * 
     */
    protected String email;

    /**
     * 
     */
    public int id;
    
    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public String getEmail() {
        return email;
    }

    public int getId() {
        return id;
    }
}