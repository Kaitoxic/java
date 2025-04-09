
import java.io.*;
import java.util.*;

/**
 * 
 */
public class Composants {

    /**
     * Default constructor
     */
    public Composants(String nom, int gpu_id, int cm_id, int ram_id, int DD_id, int alimentation_id, int boitier_id, float prix) {
        this.nom = nom;
        this.gpu_id = gpu_id;
        this.cm_id = cm_id;
        this.ram_id = ram_id;
        this.DD_id = DD_id;
        this.alimentation_id = alimentation_id;
        this.boitier_id = boitier_id;
        this.prix = prix;
    }

    /**
     * 
     */
    public String nom;

    /**
     * 
     */
    public int gpu_id;

    /**
     * 
     */
    public int cm_id;

    /**
     * 
     */
    public int ram_id;

    /**
     * 
     */
    public int DD_id;

    /**
     * 
     */
    public int alimentation_id;

    /**
     * 
     */
    public int boitier_id;

    /**
     * 
     */
    public float prix;

    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public void setGpu_id(int gpu_id) {
        this.gpu_id = gpu_id;
    }

    public void setCm_id(int cm_id) {
        this.cm_id = cm_id;
    }

    public void setRam_id(int ram_id) {
        this.ram_id = ram_id;
    }

    public void setDD_id(int DD_id) {
        this.DD_id = DD_id;
    }

    public void setAlimentation_id(int alimentation_id) {
        this.alimentation_id = alimentation_id;
    }
    
    public void setBoitier_id(int boitier_id) {
        this.boitier_id = boitier_id;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public String getNom() {
        return nom;
    }

    public int getGpu_id() {
        return gpu_id;
    }

    public int getCm_id() {
        return cm_id;
    }

    public int getRam_id() {
        return ram_id;
    }

    public int getDD_id() {
        return DD_id;
    }

    public int getAlimentation_id() {
        return alimentation_id;
    }

    public int getBoitier_id() {
        return boitier_id;
    }

    public float getPrix() {
        return prix;
    }

}