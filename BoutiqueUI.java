import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BoutiqueUI extends JFrame {
    private CardLayout cardLayout;
    private JPanel centerContentPanel;
    private JLabel titleLabel;
    private Ordinateur_Preconfigurees ordi1;
    private Ordinateur_Preconfigurees ordi2;
    private Ordinateur_Preconfigurees ordi3;
    private int prix_total = 0;
    private JButton panierButton;
    private Magazin magasin; // Référence au magasin
    private Map<String, List<Composants>> composantsParType; // Pour organiser les composants
    

    // COULEURS MODERNES
    private final Color BG_LIGHT = new Color(245, 248, 250);
    private final Color ACCENT = new Color(52, 152, 219);
    private final Color BTN_HOVER = new Color(41, 128, 185);
    private final Color BORDER_GRAY = new Color(200, 200, 200);

    public BoutiqueUI(Magazin magasin, Ordinateur_Preconfigurees ordi1, Ordinateur_Preconfigurees ordi2, Ordinateur_Preconfigurees ordi3) {
        this.magasin = magasin;
        this.ordi1 = ordi1;
        this.ordi2 = ordi2;
        this.ordi3 = ordi3;

        // Appeler la méthode pour organiser les composants par type
        organiserComposantsParType();

        // Look and feel système + polices modernisées
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            UIManager.put("Label.font", new Font("Segoe UI", Font.PLAIN, 14));
            UIManager.put("Button.font", new Font("Segoe UI", Font.PLAIN, 14));
        } catch (Exception e) {
            e.printStackTrace();
        }

        setTitle("Config&Co");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1200, 700);
        setLocationRelativeTo(null);
         // Bloquer le redimensionnement de la fenêtre
        setResizable(false);
        setLayout(new BorderLayout());

        try {
            // Remplacez "logo.png" par le chemin vers votre image
            ImageIcon icon = new ImageIcon("images/logo.png");
            setIconImage(icon.getImage());
        } catch (Exception e) {
            System.err.println("Erreur lors du chargement du logo: " + e.getMessage());
        }

        add(buildLeftPanel(), BorderLayout.WEST);
        add(buildCenterPanel(), BorderLayout.CENTER);
    }
    
    // Méthode pour organiser les composants par type
    private void organiserComposantsParType() {
        composantsParType = new HashMap<>();
        
        // Initialiser les catégories
        String[] categories = {"GPU", "CPU", "Alimentation", "Carte Mère", "RAM", "Disque Dur", "Boitier"};
        for (String categorie : categories) {
            composantsParType.put(categorie, new ArrayList<>());
        }
        
        // Si le magasin existe et a des composants
        if (magasin != null && magasin.getComposants() != null) {
            for (Composants comp : magasin.getComposants()) {
                // Utiliser directement le type du composant
                String type = comp.getType();
                
                // Vérifier si la catégorie existe
                if (composantsParType.containsKey(type)) {
                    composantsParType.get(type).add(comp);
                } else {
                    // Si le type n'est pas dans nos catégories prédéfinies, créer une nouvelle catégorie
                    composantsParType.putIfAbsent(type, new ArrayList<>());
                    composantsParType.get(type).add(comp);
                }
            }
        }
    }
    
    // ========== PANNEAU GAUCHE ==========
    private JPanel buildLeftPanel() {
        JPanel leftPanel = new JPanel(new BorderLayout());
        leftPanel.setPreferredSize(new Dimension(150, getHeight()));
        leftPanel.setBackground(BG_LIGHT);
        //leftPanel.setBorder(BorderFactory.createLineBorder(BORDER_GRAY));

        // Logo en haut à gauche
        JPanel logoPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0)); // Changer CENTER par LEFT et ajouter des marges
        logoPanel.setBackground(BG_LIGHT);
        logoPanel.setBorder(new EmptyBorder(20, 5, 10, 0)); // Ajuster les marges pour mieux positionner

        try {
            ImageIcon logoIcon = new ImageIcon("images/logo.png");
            // Redimensionner le logo à une taille appropriée
            Image img = logoIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH); // Légèrement plus petit
            JLabel logoLabel = new JLabel(new ImageIcon(img));
            logoPanel.add(logoLabel);
            
            // Ajouter le nom de la boutique à côté du logo
            JLabel boutiqueNameLabel = new JLabel("Config&Co ®");
            boutiqueNameLabel.setFont(new Font("Segoe UI", Font.BOLD, 15));
            boutiqueNameLabel.setForeground(ACCENT); // Utiliser la couleur d'accent pour le nom
            logoPanel.add(boutiqueNameLabel);
            
        } catch (Exception e) {
            System.err.println("Erreur lors du chargement du logo d'affichage: " + e.getMessage());
            JLabel fallbackLabel = new JLabel("Boutique PC");
            fallbackLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
            fallbackLabel.setForeground(ACCENT);
            logoPanel.add(fallbackLabel);
        }

        JPanel clientInfo = new JPanel();
        clientInfo.setLayout(new BoxLayout(clientInfo, BoxLayout.Y_AXIS));
        clientInfo.setBorder(new EmptyBorder(10, 10, 10, 10));
        clientInfo.setBackground(BG_LIGHT);
        clientInfo.add(linkLabel(magasin.getClients().get(0).getNom()));
        clientInfo.add(linkLabel(magasin.getClients().get(0).getEmail()));
        clientInfo.add(linkLabel(magasin.getClients().get(0).getId() + ""));

        // Ajouter le logo au-dessus des infos client
        JPanel topSection = new JPanel(new BorderLayout());
        topSection.setBackground(BG_LIGHT);
        topSection.add(logoPanel, BorderLayout.NORTH);
        topSection.add(clientInfo, BorderLayout.CENTER);

        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));
        menuPanel.setBorder(new EmptyBorder(60, 10, 10, 10));
        menuPanel.setBackground(BG_LIGHT);

        JLabel boutiqueLabel = menuItem("🖥️ Boutique");
        JLabel configurateurLabel = menuItem("🛠️ Configurateur");

        // Effets de survol
        for (JLabel lbl : new JLabel[]{boutiqueLabel, configurateurLabel}) {
            lbl.addMouseListener(new MouseAdapter() {
                public void mouseEntered(MouseEvent e) {
                    lbl.setForeground(ACCENT);
                }

                public void mouseExited(MouseEvent e) {
                    lbl.setForeground(Color.BLACK);
                }
            });
        }

        boutiqueLabel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                cardLayout.show(centerContentPanel, "boutique");
                titleLabel.setText("<html><u><b>Ordinateurs préconfigurés</b></u></html>");
            }
        });

        configurateurLabel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                cardLayout.show(centerContentPanel, "configurateur");
                titleLabel.setText("<html><u><b>Configurateur</b></u></html>");
            }
        });

        menuPanel.add(boutiqueLabel);
        menuPanel.add(Box.createVerticalStrut(20));
        menuPanel.add(configurateurLabel);

        JPanel bottom = new JPanel(new BorderLayout());
        bottom.setBackground(BG_LIGHT);
        bottom.add(linkLabel("© 2025"), BorderLayout.SOUTH);

        leftPanel.add(topSection, BorderLayout.NORTH);
        leftPanel.add(menuPanel, BorderLayout.CENTER);
        leftPanel.add(bottom, BorderLayout.SOUTH);
        return leftPanel;
    }

    // ========== PANNEAU CENTRE ==========
    private JPanel buildCenterPanel() {
        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.setBackground(BG_LIGHT);

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBackground(BG_LIGHT);
        topPanel.setBorder(new EmptyBorder(10, 20, 10, 20));

        titleLabel = new JLabel("<html><u><b>Ordinateurs préconfigurés</b></u></html>", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));

        panierButton = new JButton("Commander : "+ prix_total + "€");
        panierButton.setPreferredSize(new Dimension(190, 45));
        panierButton.setFocusPainted(false);
        panierButton.setBackground(ACCENT);
        panierButton.setForeground(Color.WHITE);
        panierButton.setBorder(new EmptyBorder(10, 20, 10, 20));
        panierButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        panierButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        panierButton.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                panierButton.setBackground(BTN_HOVER);
            }

            public void mouseExited(MouseEvent e) {
                panierButton.setBackground(ACCENT);
            }
        });

        panierButton.addActionListener(e -> {
            cardLayout.show(centerContentPanel, "panier");
            titleLabel.setText("<html><u><b>Mon Panier</b></u></html>");
        });

        topPanel.add(titleLabel, BorderLayout.CENTER);
        topPanel.add(panierButton, BorderLayout.EAST);

        cardLayout = new CardLayout();
        centerContentPanel = new JPanel(cardLayout);
        centerContentPanel.add(buildBoutiquePanel(), "boutique");
        centerContentPanel.add(buildConfigPanel(), "configurateur");
        centerContentPanel.add(buildPanierPanel(), "panier");

        centerPanel.add(topPanel, BorderLayout.NORTH);
        centerPanel.add(centerContentPanel, BorderLayout.CENTER);
        return centerPanel;
    }

    // ========== VUE BOUTIQUE ==========
    private JPanel buildBoutiquePanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 80, 80));
        panel.setBackground(BG_LIGHT);
        panel.setBorder(new EmptyBorder(20, 10, 20, 10));
        panel.add(productBox(ordi1.getNom(), ordi1.getPrix() + "€", "images/pc_basique.jpg"));
        panel.add(productBox(ordi2.getNom(), ordi2.getPrix() + "€", "images/pc_goat.jpg"));
        panel.add(productBox(ordi3.getNom(), ordi3.getPrix() + "€", "images/pc_ultime.jpg"));
        return panel;
    }

    
    // ========== VUE CONFIGURATEUR ==========
private JPanel buildConfigPanel() {
    JPanel panel = new JPanel(new BorderLayout());
    panel.setBackground(BG_LIGHT);
    
    // Panneau pour les boutons de catégorie
    JPanel categoriesPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 20));
    categoriesPanel.setBackground(BG_LIGHT);
    categoriesPanel.setBorder(new EmptyBorder(20, 20, 0, 20));
    
    // Panneau pour afficher les composants de la catégorie sélectionnée
    JPanel composantsDisplayPanel = new JPanel();
    CardLayout composantsCardLayout = new CardLayout();
    composantsDisplayPanel.setLayout(composantsCardLayout);
    composantsDisplayPanel.setBackground(BG_LIGHT);
    composantsDisplayPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
    
    // Pour chaque type de composant
    String[] composantTypes = {"GPU", "CPU", "Alimentation", "Carte Mère", "RAM", "Disque Dur", "Boitier"};
    
    for (String type : composantTypes) {
        // Créer le bouton pour ce type
        JButton typeBtn = configButton(type);
        categoriesPanel.add(typeBtn);
        
        // Panneau pour afficher les composants de ce type
        JPanel typePanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
        typePanel.setBackground(BG_LIGHT);
        
        // Ajouter les composants de ce type, s'il y en a
        List<Composants> comps = composantsParType.get(type);
        if (comps != null && !comps.isEmpty()) {
            for (Composants comp : comps) {
                typePanel.add(createComponentPanel(comp));
            }
        } else {
            JLabel emptyLabel = new JLabel("Aucun composant " + type + " disponible");
            emptyLabel.setFont(new Font("Segoe UI", Font.ITALIC, 16));
            typePanel.add(emptyLabel);
        }
        
        // Ajouter ce panneau au CardLayout
        composantsDisplayPanel.add(typePanel, type);
        
        // Action lorsqu'on clique sur le bouton
        typeBtn.addActionListener(e -> {
            composantsCardLayout.show(composantsDisplayPanel, type);
            titleLabel.setText("Configurateur - " + type );
            titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        });
    }
    
    panel.add(categoriesPanel, BorderLayout.NORTH);
    panel.add(composantsDisplayPanel, BorderLayout.CENTER);
    
    return panel;
}

    // Méthode pour créer un panneau pour un composant individuel
    private JPanel createComponentPanel(Composants comp) {
        // Panneau principal avec bordure simple
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createLineBorder(BORDER_GRAY, 1, true));
        panel.setPreferredSize(new Dimension(180, 180));
        
        // Créer un en-tête avec le type de composant
        JLabel typeLabel = new JLabel(comp.getType(), JLabel.CENTER);
        typeLabel.setBackground(ACCENT);
        typeLabel.setForeground(Color.WHITE);
        typeLabel.setOpaque(true);
        typeLabel.setFont(new Font("Segoe UI", Font.BOLD, 12));
        typeLabel.setBorder(new EmptyBorder(5, 0, 5, 0));
        
        // Panneau central avec les infos du composant
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
        infoPanel.setBackground(Color.WHITE);
        infoPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        
        // Nom du composant
        JLabel nameLabel = new JLabel(comp.getNom());
        nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        nameLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        
        // Prix du composant
        JLabel priceLabel = new JLabel(String.format("%.2f€", comp.getPrix()));
        priceLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        priceLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
        priceLabel.setForeground(ACCENT);
        
        // Bouton d'ajout
        JButton addButton = new JButton("Ajouter");
        addButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        addButton.setBackground(ACCENT);
        addButton.setForeground(Color.WHITE);
        addButton.setFocusPainted(false);
        
        // Assembler le panneau d'info
        infoPanel.add(nameLabel);
        infoPanel.add(Box.createVerticalStrut(10));
        infoPanel.add(priceLabel);
        infoPanel.add(Box.createVerticalStrut(15));
        infoPanel.add(addButton);
        
        // Assembler le panneau principal
        panel.add(typeLabel, BorderLayout.NORTH);
        panel.add(infoPanel, BorderLayout.CENTER);
        
        return panel;
    }

    // ========== VUE PANIER ==========
    private JPanel buildPanierPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(BG_LIGHT);
        JLabel label = new JLabel("<html><center><h1>Votre panier est vide</h1></center></html>", SwingConstants.CENTER);
        label.setFont(new Font("Segoe UI", Font.PLAIN, 22));
        panel.add(label, BorderLayout.CENTER);
        return panel;
    }

    // ========== COMPOSANTS UTILES ==========
    private JLabel linkLabel(String text) {
        JLabel label = new JLabel("<html><a href=''>" + text + "</a></html>");
        label.setCursor(new Cursor(Cursor.HAND_CURSOR));
        label.setAlignmentX(Component.LEFT_ALIGNMENT);
        return label;
    }

    private JLabel menuItem(String text) {
        JLabel label = new JLabel("<html><b>" + text + "</b></html>");
        label.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        label.setCursor(new Cursor(Cursor.HAND_CURSOR));
        label.setAlignmentX(Component.LEFT_ALIGNMENT);
        return label;
    }

    private JButton configButton(String text) {
        JButton btn = new JButton("<html><b>" + text + "</b></html>");
        btn.setFocusPainted(false);
        btn.setBackground(Color.WHITE);
        btn.setBorder(new LineBorder(ACCENT, 2, true));
        btn.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));

        btn.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                btn.setBackground(ACCENT);
                btn.setForeground(Color.WHITE);
            }

            public void mouseExited(MouseEvent e) {
                btn.setBackground(Color.WHITE);
                btn.setForeground(Color.BLACK);
            }
        });

        return btn;
    }

    private JPanel productBox(String name, String price, String imagePath) {
        JPanel box = new JPanel(new BorderLayout()) {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                g2.setColor(new Color(0, 0, 0, 20));
                g2.fillRoundRect(5, 5, getWidth() - 10, getHeight() - 10, 20, 20);
            }
        };
        box.setOpaque(false);
        box.setBackground(Color.WHITE);
        box.setPreferredSize(new Dimension(220, 300));
        box.setBorder(new EmptyBorder(10, 10, 10, 10));
        box.setCursor(new Cursor(Cursor.HAND_CURSOR));
    
        // Get price value without the € symbol
        int priceValue = Integer.parseInt(price.replace("€", ""));
    
        ImageIcon icon = new ImageIcon(imagePath);
        Image img = icon.getImage().getScaledInstance(220, 220, Image.SCALE_SMOOTH);
        JLabel imageLabel = new JLabel(new ImageIcon(img));
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        box.add(imageLabel, BorderLayout.CENTER);
    
        JPanel bottom = new JPanel(new GridLayout(2, 1));
        bottom.setBackground(new Color(250, 250, 250));
        JLabel nameLabel = new JLabel("<html><b>" + name + "</b></html>", SwingConstants.CENTER);
        JLabel priceLabel = new JLabel("<html><u>" + price + "</u></html>", SwingConstants.CENTER);
        bottom.add(nameLabel);
        bottom.add(priceLabel);
        box.add(bottom, BorderLayout.SOUTH);
        
        // Add click event to increment the total price
        box.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                prix_total += priceValue;
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
        });
        
        return box;
    }

    private void updatePanierButton() {
        if (panierButton != null) {
            panierButton.setText("Commander : " + prix_total + "€");
        }
    }


}
