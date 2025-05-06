import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ControllePreconfig extends MouseAdapter {
    private JPanel box;
    private JPanel bottom;
    private int priceValue;
    private String name;
    private String price;
    private JButton panierButton;
    private BoutiqueUI boutiqueUI;

    public ControllePreconfig(JPanel box, JPanel bottom, int priceValue, String name, String price, JButton panierButton, BoutiqueUI boutiqueUI) {
        this.box = box;
        this.bottom = bottom;
        this.priceValue = priceValue;
        this.name = name;
        this.price = price;
        this.panierButton = panierButton;
        this.boutiqueUI = boutiqueUI;
    }

	public void incrementerPrixTotal(int montant) {
        boutiqueUI.prix_total += montant;
    }

    public int getPrixTotal() {
        return boutiqueUI.prix_total;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        incrementerPrixTotal(priceValue); // Mise à jour de prix_total via BoutiqueUI
        updatePanierButton();
        JOptionPane.showMessageDialog(box,
            name + " ajouté au panier pour " + price,
            "Produit ajouté",
            JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        bottom.setBackground(new Color(240, 240, 240));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        bottom.setBackground(new Color(250, 250, 250));
    }

    private void updatePanierButton() {
        if (panierButton != null) {
            panierButton.setText("Commander : " + getPrixTotal() + "€");
        }
    }
}