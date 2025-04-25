import java.util.Date;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        
        Magazin magazin = new Magazin("Magasin de PC", "123 Rue de la Technologie");
        Vendeur vendeur = new Vendeur("Jean", 1, magazin, null);
        Livreur livreur = new Livreur("Pierre", true, magazin);
        Client client = new Client("Thomas", "thomas@gmail.com" , 1, magazin);
        Composants gpu = new Composants("NVIDIA GeForce RTX 3080", 699.99f);
        Critere gpuCritere = new Critere("Hertz", 1440, gpu);
        Commande commande = new Commande(1, new Date(), new Date(), client, livreur);
        Ordinateur_Personnalises ordiperso = new Ordinateur_Personnalises("Ordinateur Gamer", 1, 50.0f, 1, new Date(), new Date(), client, livreur, true);
        Ordinateur_Preconfigurees ordinateur1 = new Ordinateur_Preconfigurees("Ordinateur Gamer", 1500, 1, 1, new Date(), new Date(),client, livreur, vendeur, "Souris", "Ordinateur gamer avec carte graphique RTX 3080");
        Ordinateur_Preconfigurees ordinateur2 = new Ordinateur_Preconfigurees("Ordinateur Bureautique", 800, 2, 1, new Date(), new Date(), client, livreur, vendeur, "Clavier", "Ordinateur bureautique avec processeur i5");

        ordiperso.addComposant(gpu);
        //magasin.addOrdinateur(ordinateur1);
        magazin.addClient(client);
        magazin.addVendeur(vendeur);
        magazin.addLivreur(livreur);
        magazin.addComposant(gpu);
        System.out.println(vendeur.nom);
        
        // Afficher l'interface graphique
        SwingUtilities.invokeLater(() -> {
            BoutiqueUI ui = new BoutiqueUI(magazin, client, ordinateur1, ordinateur2, null);
            ui.setVisible(true);
        });
    }
}