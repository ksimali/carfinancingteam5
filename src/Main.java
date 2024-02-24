import view.LoginView;
import view.RegisterView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {
    private CardLayout cardLayout = new CardLayout();
    private JPanel cardPanel = new JPanel(cardLayout);
    private LoginView loginView = new LoginView();
    private RegisterView registerView = new RegisterView();

    public Main() {
        //Setting up JFrame
        super("Financement Automobile charExpress");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000, 600);
        setVisible(true);
        setResizable(false); // windows not resizable
        setLocationRelativeTo(null); // to center the window in the center of the screen

        // Set a background for JFrame
        setContentPane(new JLabel(new ImageIcon("/Users/ksim/Desktop/autopic.jpeg")));
        // Set some Layout
        setLayout(new FlowLayout());

        //Setting up mainPanel
        JPanel mainPanel = new JPanel();
        //mainPanel.setBounds(40,150,220,70);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        mainPanel.setBackground(new Color(0,0,0,0)); // background transparent
        add(mainPanel); //Add mainPanel to JFrame

        // Setting up 'Connexion' button
        JButton loginButton = new JButton("Connexion");
        mainPanel.add(loginButton); //Add button to the main panel

        // Setting up 'Inscription' button
        JButton registerButton = new JButton("Inscription");
        mainPanel.add(registerButton); //Add button to the main panel

        // Set up
        cardPanel.add(mainPanel, "Main");
        //cardPanel.add(loginView, "Login");
        //cardPanel.add(registerView, "Register");

        add(cardPanel);

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
                cardLayout.show(cardPanel, "Register");
            }
        });
    }

    //  Main method
    public static void main(String[] args) throws Exception {
        Runnable initFrame = new Runnable(){
            @Override
            public void run(){
                new Main();
            }
        };

        SwingUtilities.invokeAndWait(initFrame);
    }
}
