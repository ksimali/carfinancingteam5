import view.LoginView;
import view.RegisterView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    // class attributes
    private JFrame frame;
    private JPanel mainPanel;
    private JPanel descriptionPanel;
    private JButton loginButton;
    private JButton registerButton;
    private  JLabel descriptionLabel;
    private JLabel contactLabel;
    private CardLayout cardLayout;
    private JPanel cardPanel;
    private LoginView loginView;
    private RegisterView registerView;

    // constructor for the Main class
    public Main(){
        frame = new JFrame();
        mainPanel = new JPanel();
        descriptionPanel = new JPanel();
        loginButton = new JButton("Connexion");
        registerButton = new JButton("Inscription");
        descriptionLabel = new JLabel("Financement de votre futur véhicule à un taux inférieur à 5%");
        contactLabel = new JLabel(" Numéro de téléphone: +514 267-6789");
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);
        loginView = new LoginView();
        registerView =  new RegisterView();
    }
    public void setUpMain() {
        //Setting up JFrame
        frame.setTitle("Financement Automobile charExpress");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 600);
        frame.setVisible(true);
        frame.setResizable(false); // windows not resizable
        frame.setLocationRelativeTo(null); // to center the window in the center of the screen

        // Set a background for JFrame
        frame.setContentPane(new JLabel(new ImageIcon("./src/images/autopic.jpeg")));
        // Set some Layout
        frame.setLayout(new FlowLayout());

        //Setting up mainPanel, description panel
        mainPanel.setBounds(40,150,220,35);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        mainPanel.setBackground(new Color(0,0,0,0)); // background transparent
        frame.add(mainPanel); //Add mainPanel to JFrame

        descriptionPanel.setBounds(100,250,300,35);
        descriptionPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        descriptionPanel.setBackground(new Color(0,0,0,65)); // background transparent
        frame.add( descriptionPanel);

        // Setting up 'Connexion' button
        mainPanel.add(loginButton); //Add button to the main panel

        // Setting up 'Inscription' button
        mainPanel.add(registerButton); //Add button to the main panel

        // Setting up descriptionLabel
        descriptionLabel.setBounds(40,250,220,35);
        descriptionPanel.add(descriptionLabel);

        // Set up JLabel contact Label
        contactLabel.setBounds(100,400,220,35);
        mainPanel.add(contactLabel);

        cardPanel.add(mainPanel, "Main");
        //cardPanel.add(loginView, "Login");
        //cardPanel.add(registerView, "Register");

        frame.add(cardPanel);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("the button is clicked!");
                cardLayout.show(cardPanel, "Login");
            }
        });

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("the button is clicked!");
                registerView.setVisible(true);
                cardLayout.show(cardPanel, "Register");
            }
        });
    }

    //  Main method
    public static void main(String[] args) throws Exception {
        Runnable initFrame = new Runnable(){
            @Override
            public void run(){
                Main start = new Main();
                start.setUpMain();
            }
        };

        SwingUtilities.invokeAndWait(initFrame);
    }
}
