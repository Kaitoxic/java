import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Date;

public class BoutiqueUI extends JFrame {
    private CardLayout cardLayout;
    private JPanel centerContentPanel;
    private JLabel titleLabel;
    private Ordinateur_Preconfigurees ordi1;
    private Ordinateur_Preconfigurees ordi2;
    private Ordinateur_Preconfigurees ordi3;
    public int prix_total = 0;
    private JButton panierButton;
    private Magazin magasin;
    private Map<String, List<Composants>> composantsParType;
    

    private final Color BG_LIGHT = new Color(245, 248, 250);
    private final Color ACCENT = new Color(52, 152, 219);
    private final Color BTN_HOVER = new Color(41, 128, 185);
    private final Color BORDER_GRAY = new Color(200, 200, 200);

    public BoutiqueUI(Magazin magasin, Ordinateur_Preconfigurees ordi1, Ordinateur_Preconfigurees ordi2, Ordinateur_Preconfigurees ordi3) {
        this.magasin = magasin;
        this.ordi1 = ordi1;
        this.ordi2 = ordi2;
        this.ordi3 = ordi3;

        organiserComposantsParType();

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
        setResizable(false);
        setLayout(new BorderLayout());

        try {
            ImageIcon icon = new ImageIcon("images/logo.png");
            setIconImage(icon.getImage());
        } catch (Exception e) {
            System.err.println("Erreur lors du chargement du logo: " + e.getMessage());
        }

        add(buildLeftPanel(), BorderLayout.WEST);
        add(buildCenterPanel(), BorderLayout.CENTER);
    }
    
    private void organiserComposantsParType() {
        composantsParType = new HashMap<>();
        
        String[] categories = {"GPU", "CPU", "Alimentation", "Carte Mère", "RAM", "Disque Dur", "Boitier"};
        for (String categorie : categories) {
            composantsParType.put(categorie, new ArrayList<>());
        }
        
        if (magasin != null && magasin.getComposants() != null) {
            for (Composants comp : magasin.getComposants()) {
                String type = comp.getType();
                
                if (composantsParType.containsKey(type)) {
                    composantsParType.get(type).add(comp);
                } else {
                    composantsParType.putIfAbsent(type, new ArrayList<>());
                    composantsParType.get(type).add(comp);
                }
            }
        }
    }
    
    private JPanel buildLeftPanel() {
        JPanel leftPanel = new JPanel(new BorderLayout());
        leftPanel.setPreferredSize(new Dimension(150, getHeight()));
        leftPanel.setBackground(BG_LIGHT);

        JPanel logoPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        logoPanel.setBackground(BG_LIGHT);
        logoPanel.setBorder(new EmptyBorder(20, 5, 10, 0));

        try {
            ImageIcon logoIcon = new ImageIcon("images/logo.png");
            Image img = logoIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
            JLabel logoLabel = new JLabel(new ImageIcon(img));
            logoPanel.add(logoLabel);
            
            JLabel boutiqueNameLabel = new JLabel("Config&Co ®");
            boutiqueNameLabel.setFont(new Font("Segoe UI", Font.BOLD, 15));
            boutiqueNameLabel.setForeground(ACCENT);
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
        JLabel gestionLabel = menuItem("🔐 Gestion");

        for (JLabel lbl : new JLabel[]{boutiqueLabel, configurateurLabel, gestionLabel}) {
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

        gestionLabel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                cardLayout.show(centerContentPanel, "gestion");
                titleLabel.setText("<html><u><b>Gestion</b></u></html>");
            }
        });

        menuPanel.add(boutiqueLabel);
        menuPanel.add(Box.createVerticalStrut(20));
        menuPanel.add(configurateurLabel);
        menuPanel.add(Box.createVerticalStrut(20));
        menuPanel.add(gestionLabel);

        JPanel bottom = new JPanel(new BorderLayout());
        bottom.setBackground(BG_LIGHT);
        bottom.add(linkLabel("© 2025"), BorderLayout.SOUTH);

        leftPanel.add(topSection, BorderLayout.NORTH);
        leftPanel.add(menuPanel, BorderLayout.CENTER);
        leftPanel.add(bottom, BorderLayout.SOUTH);
        return leftPanel;
    }

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
    if (prix_total == 0) {
        JOptionPane.showMessageDialog(this, 
            "Votre panier est vide.", 
            "Commande impossible", 
            JOptionPane.WARNING_MESSAGE);
        return;
    }
    
    Client client = magasin.getClients().get(0);
    Livreur livreur = magasin.getLivreur().get(0);
    Date dateCommande = new Date();
    Date dateLivraison = new Date(dateCommande.getTime() + 7 * 24 * 60 * 60 * 1000);
    
    int commandeId = (int)(Math.random() * 10000);
    
    Commande nouvelleCommande = new Commande(commandeId, dateCommande, dateLivraison, client, livreur);
    
    String message = "Détails de votre commande :\n\n" +
                     "N° de commande : " + commandeId + "\n" +
                     "Date : " + dateCommande + "\n" +
                     "Livraison prévue : " + dateLivraison + "\n" +
                     "Client : " + client.getNom() + "\n" +
                     "Prix total : " + prix_total + "€\n\n" +
                     "Merci pour votre commande !";
    
    JOptionPane.showMessageDialog(this, 
        message, 
        "Commande confirmée", 
        JOptionPane.INFORMATION_MESSAGE);
    
        prix_total = 0;
        panierButton.setText("Commander : " + prix_total + "€");
        
        cardLayout.show(centerContentPanel, "panier");
        titleLabel.setText("<html><u><b>Mon Panier</b></u></html>");
    });

        topPanel.add(titleLabel, BorderLayout.CENTER);
        topPanel.add(panierButton, BorderLayout.EAST);

        cardLayout = new CardLayout();
        centerContentPanel = new JPanel(cardLayout);
        centerContentPanel.add(buildBoutiquePanel(), "boutique");
        centerContentPanel.add(buildConfigPanel(), "configurateur");
        centerContentPanel.add(buildPanierPanel(), "panierzer");
        centerContentPanel.add(buildGestionPanel(), "gestion");

        centerPanel.add(topPanel, BorderLayout.NORTH);
        centerPanel.add(centerContentPanel, BorderLayout.CENTER);
        return centerPanel;
    }

    private JPanel buildBoutiquePanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 80, 80));
        panel.setBackground(BG_LIGHT);
        panel.setBorder(new EmptyBorder(20, 10, 20, 10));
        panel.add(productBox(ordi1.getNom(), ordi1.getPrix() + "€", "images/pc_basique.jpg"));
        panel.add(productBox(ordi2.getNom(), ordi2.getPrix() + "€", "images/pc_goat.jpg"));
        panel.add(productBox(ordi3.getNom(), ordi3.getPrix() + "€", "images/pc_ultime.jpg"));
        return panel;
    }

    
    private JPanel buildConfigPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(BG_LIGHT);
        
        JPanel categoriesPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 20));
        categoriesPanel.setBackground(BG_LIGHT);
        categoriesPanel.setBorder(new EmptyBorder(20, 20, 0, 20));
        
        JPanel composantsDisplayPanel = new JPanel();
        CardLayout composantsCardLayout = new CardLayout();
        composantsDisplayPanel.setLayout(composantsCardLayout);
        composantsDisplayPanel.setBackground(BG_LIGHT);
        composantsDisplayPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        
        String[] composantTypes = {"GPU", "CPU", "Alimentation", "Carte Mère", "RAM", "Disque Dur", "Boitier"};
        
        for (String type : composantTypes) {
            JButton typeBtn = configButton(type);
            categoriesPanel.add(typeBtn);
            
            JPanel typePanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
            typePanel.setBackground(BG_LIGHT);
            
            List<Composants> comps = composantsParType.get(type);
            //comps.add(new Composants("azdzazdz " + type + " azdazdaz", 0, type));
            if (comps != null && !comps.isEmpty()) {
                for (Composants comp : comps) {
                    typePanel.add(createComponentPanel(comp));
                }
            } else {
                JLabel emptyLabel = new JLabel("Aucun composant " + type + " disponible");
                emptyLabel.setFont(new Font("Segoe UI", Font.ITALIC, 16));
                typePanel.add(emptyLabel);
            }
            
            composantsDisplayPanel.add(typePanel, type);
            
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

    private JPanel createComponentPanel(Composants comp) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createLineBorder(BORDER_GRAY, 1, true));
        panel.setPreferredSize(new Dimension(180, 180));
        
        JLabel typeLabel = new JLabel(comp.getType(), JLabel.CENTER);
        typeLabel.setBackground(ACCENT);
        typeLabel.setForeground(Color.WHITE);
        typeLabel.setOpaque(true);
        typeLabel.setFont(new Font("Segoe UI", Font.BOLD, 12));
        typeLabel.setBorder(new EmptyBorder(5, 0, 5, 0));
        
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
        infoPanel.setBackground(Color.WHITE);
        infoPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        
        JLabel nameLabel = new JLabel(comp.getNom());
        nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        nameLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        
        JLabel priceLabel = new JLabel(String.format("%.2f€", comp.getPrix()));
        priceLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        priceLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
        priceLabel.setForeground(ACCENT);
        
        JButton addButton = new JButton("Ajouter");
        addButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        addButton.setBackground(ACCENT);
        addButton.setForeground(Color.WHITE);
        addButton.setFocusPainted(false);
        
        infoPanel.add(nameLabel);
        infoPanel.add(Box.createVerticalStrut(10));
        infoPanel.add(priceLabel);
        infoPanel.add(Box.createVerticalStrut(15));
        infoPanel.add(addButton);
        
        panel.add(typeLabel, BorderLayout.NORTH);
        panel.add(infoPanel, BorderLayout.CENTER);
        
        return panel;
    }

    private JPanel buildPanierPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(BG_LIGHT);
        JLabel label = new JLabel("<html><center><h1>Votre panier est vide</h1></center></html>", SwingConstants.CENTER);
        label.setFont(new Font("Segoe UI", Font.PLAIN, 22));
        panel.add(label, BorderLayout.CENTER);
        return panel;
    }

    private void editComp() {
        // Logic to edit a component
        JOptionPane.showMessageDialog(this, "Editer un composant", "Editer", JOptionPane.INFORMATION_MESSAGE);
    }

    private JPanel buildGestionPanel()
    {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(BG_LIGHT);

        JLabel titleLabel = new JLabel("<html><center><h2>Gestion du magasin</h2></center></html>", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 22));
        panel.add(titleLabel, BorderLayout.NORTH);

        // Container panel for buttons with BoxLayout
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.Y_AXIS));
        buttonsPanel.setBackground(BG_LIGHT);
        buttonsPanel.setBorder(new EmptyBorder(20, 50, 20, 50));

        // Define all buttons
        JButton[] buttons = {
            new JButton("Editer un composant"),
            new JButton("Editer un client"),
            new JButton("Editer un livreur"),
            new JButton("Editer une commande"),
        };

        // Add each button with spacing
        for (JButton button : buttons) {
            button.setPreferredSize(new Dimension(190, 45));
            button.setMaximumSize(new Dimension(300, 45));
            button.setAlignmentX(Component.CENTER_ALIGNMENT);
            button.setBackground(ACCENT);
            button.setForeground(Color.BLACK);
            button.setFocusPainted(false);
            button.setCursor(new Cursor(Cursor.HAND_CURSOR));
            
            buttonsPanel.add(button);
            buttonsPanel.add(Box.createVerticalStrut(15)); // Add spacing between buttons
        }

        // Add actions to buttons
        buttons[0].addActionListener(e -> {
            editComp();
        });

        // Add buttons panel to center
        panel.add(buttonsPanel, BorderLayout.CENTER);
        return panel;
    }

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

        box.addMouseListener(new ControllePreconfig(box, bottom, priceValue, name, price, panierButton, this));

        return box;
    }


}
