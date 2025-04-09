
import java.io.*;
import java.util.*;

/**
 * 
 */
public class Livreur {

    /**
        * Default constructor
        */
        public Livreur() {
            public Livreur(String transporteur, boolean est_tracquable) {
           this.transporteur = transporteur;
           this.est_tracquable = est_tracquable;
        }
        }

        /**
        * 
        */
        public String transporteur;

        /**
        * 
        */
        public boolean est_tracquable;

        public String getTransporteur() {
           return transporteur;
        }

        public void setTransporteur(String transporteur) {
           this.transporteur = transporteur;
        }

        public boolean isEst_tracquable() {
           return est_tracquable;
        }

        public void setEst_tracquable(boolean est_tracquable) {
           this.est_tracquable = est_tracquable;
        }
}