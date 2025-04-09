public class Main {
    public static void main(String[] args) {
        
        Magazin magasin = new Magazin("Magasin de PC", "123 Rue de la Technologie");
        Vendeur vendeur = new Vendeur("Jean", 1, magasin);
        Livreur livreur = new Livreur("Pierre", 1, magasin);
        Client client = new Client("Thomas", "thomas@gmail.com" , 1, magasin);
        Composant gpu = new Composant("NVIDIA GeForce RTX 3080", 699.99f);
        Critere gpuCritere = new Critere("Hertz", 1440);
        Ordinateur_Personnalises ordiperso = new Ordinateur_Personnalises(1, new Date(), new Date(), "Ordinateur Gamer", 1, 50.0f, true);
        Ordinateur_Preconfigurees ordinateur1 = new Ordinateur_Preconfigurees("Ordinateur Gamer", 1500, 1, "Souris", "Ordinateur gamer avec carte graphique RTX 3080");
        Ordinateur_Preconfigurees ordinateur2 = new Ordinateur_Preconfigurees("Ordinateur Bureautique", 800, 2, "Clavier", "Ordinateur bureautique avec processeur i5");

        ordiperso.addComposant(gpu);
        magasin.addOrdinateur(ordinateur1);
        magasin.addClient(client);
        magasin.addVendeur(vendeur);
        magasin.addLivreur(livreur);
        magasin.addComposant(gpu);
    }
}