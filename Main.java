import java.util.Date;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        
        Magazin magasin = new Magazin("Magasin de PC", "123 Rue de la Technologie");
        Vendeur vendeur = new Vendeur("Jean", 1, magasin, null);
        Livreur livreur = new Livreur("Pierre", true, magasin);
        Client client = new Client("Thomas", "thomas@gmail.com" , 1, magasin);
        Composants gpu = new Composants("NVIDIA GeForce RTX 3080", 699.99f);
        Critere gpuCritere = new Critere("Hertz", 1440, gpu);
        Commande commande = new Commande(1, new Date(), new Date(), client, livreur);
        Ordinateur_Personnalises ordiperso = new Ordinateur_Personnalises("Ordinateur Gamer", 1, 50.0f, 1, new Date(), new Date(), client, livreur, true);
        Ordinateur_Preconfigurees ordinateur1 = new Ordinateur_Preconfigurees("Ordinateur Gamer", 1500.0f, 1, 1, new Date(), new Date(),client, livreur, vendeur, "Souris", "Ordinateur gamer avec carte graphique RTX 3080");
        Ordinateur_Preconfigurees ordinateur2 = new Ordinateur_Preconfigurees("Ordinateur Bureautique", 800.0f, 2, 1, new Date(), new Date(), client, livreur, vendeur, "Clavier", "Ordinateur bureautique avec processeur i5");

        ordiperso.addComposant(gpu);
        //magasin.addOrdinateur(ordinateur1);
        magasin.addClient(client);
        magasin.addVendeur(vendeur);
        magasin.addLivreur(livreur);
        magasin.addComposant(gpu);
        System.out.println(vendeur.nom);
        
        // Afficher l'interface graphique
        SwingUtilities.invokeLater(() -> {
            BoutiqueUI ui = new BoutiqueUI();
            ui.setVisible(true);
        });
    }
}