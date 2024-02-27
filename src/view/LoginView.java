package view;

import javax.swing.*;
import java.awt.*;

public class LoginView extends JDialog {
    public LoginView() {

        this.setTitle("Connexion");

        // Creation d'objets de type JLabel
        JLabel labelUsername = new JLabel("Username: ");
        JLabel labelPassword = new JLabel("Password: ");

        // Creation d'objets de type JTextField
        JTextField textFieldUsername = new JTextField(20); // Username
        JTextField textFieldPassword = new JTextField(20);  // Password

        // Permet de modifier les dimensions des champs de texte
        textFieldUsername.setPreferredSize(new Dimension(200, 30));
        textFieldPassword.setPreferredSize(new Dimension(200, 30));

        // Creation d'un objet JButton
        JButton button = new JButton("Login");

        // Ajout des composants au pane
        Container contentPane = this.getContentPane();
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));

        contentPane.add(labelUsername);
        contentPane.add(textFieldUsername);
        contentPane.add(labelPassword);
        contentPane.add(textFieldPassword);
        contentPane.add(button);

        // Permet de fermer la fenetre en cliquand sur le bouton 'X'
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        // Modification des dimensions du JDialog
        this.setSize(400, 200);

        // Make the dialog visible
        // this.setVisible(true);
    }
}
