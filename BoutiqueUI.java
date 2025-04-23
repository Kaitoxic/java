import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class BoutiqueUI extends JFrame {
    private CardLayout cardLayout;
    private JPanel centerContentPanel;
    private JLabel titleLabel;

    // COULEURS MODERNES
    private final Color BG_LIGHT = new Color(245, 248, 250);
    private final Color ACCENT = new Color(52, 152, 219);
    private final Color BTN_HOVER = new Color(41, 128, 185);
    private final Color BORDER_GRAY = new Color(200, 200, 200);

    public BoutiqueUI() {
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
        clientInfo.add(linkLabel("Nom client"));
        clientInfo.add(linkLabel("Prénom"));
        clientInfo.add(linkLabel("ID"));

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

        JButton panierButton = new JButton("Panier");
        panierButton.setPreferredSize(new Dimension(130, 45));
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
        panel.add(productBox("Entrée de gamme", "500€", "images/pc_basique.jpg"));
        panel.add(productBox("GOAT", "1000€", "images/pc_goat.jpg"));
        panel.add(productBox("Ultime", "2000€", "images/pc_ultime.jpg"));
        return panel;
    }

    // ========== VUE CONFIGURATEUR ==========
    private JPanel buildConfigPanel() {
        JPanel panel = new JPanel(new GridLayout(2, 3, 30, 20));
        panel.setBackground(BG_LIGHT);
        panel.setBorder(new EmptyBorder(40, 40, 40, 40));
        String[] composants = {"GPU", "CPU", "Alimentation", "Carte Mère", "RAM", "Disque Dur", "Boitier"};
        for (String c : composants) panel.add(configButton(c));
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

        return box;
    }

    // ========== MAIN ==========
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new BoutiqueUI().setVisible(true));
    }
}
