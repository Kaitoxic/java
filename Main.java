public class Main {
    public static void main(String[] args) {
        
        Magazin magasin = new Magazin();
        Vendeur vendeur = new Vendeur();
        Client client = new Client("Thomas", "thomas@gmail.com" , 1);
        Composants composants = new Composants("Composants Pc préconfigurée", 1, 1, 1, 1, 1, 1, 1500);
    }
    
}