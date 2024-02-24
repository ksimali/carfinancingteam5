import view.LoginView;
import view.RegisterView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {
    private CardLayout cardLayout = new CardLayout();
    private JPanel cardPanel = new JPanel(cardLayout);
    private JPanel mainPanel = new JPanel(new FlowLayout());
    private LoginView loginView = new LoginView();
    private RegisterView registerView = new RegisterView();

    public Main() {
        //Setting up JFrame
        setTitle("Financement Automobile charExpress");
        setSize(600, 400);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // centre la fenêtre au centre de l'écran

        // Creation des boutons 'Connexion' et 'Inscription'
        JButton loginButton = new JButton("Connexion");
        JButton registerButton = new JButton("Inscription");

        mainPanel.add(loginButton);
        mainPanel.add(registerButton);

        cardPanel.add(mainPanel, "Main");
        //cardPanel.add(loginView, "Login");
        //cardPanel.add(registerView, "Register");

        add(cardPanel);

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "Login");
            }
        });

        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "Register");
            }
        });
    }

    //  Main method
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Main frame = new Main();
                frame.setVisible(true);
            }
        });
    }
}
