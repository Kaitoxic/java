public class Main {
    public static void main(String[] args) {
        
        Magazin magasin = new Magazin("Magasin de PC", "123 Rue de la Technologie");
        Vendeur vendeur = new Vendeur("Jean", 1);
        Client client = new Client("Thomas", "thomas@gmail.com" , 1);
        Composant gpu = new Composant("NVIDIA GeForce RTX 3080", 699.99f, "GPU", 1);
    }
    
}