import javax.swing.*;
import java.awt.*;

public class pageConnexion {
    public pageConnexion() {
        // Creation d'un nouvel objet JFrame
        JFrame frame = new JFrame("Connexion");

        // Creation d'un nouvel objet JTextField
        JTextField textFieldUsername = new JTextField(20); // Username
        JTextField textFieldPassword = new JTextField(20);  // Password

        // Creation d'un nouvel objet JButton
        JButton button = new JButton("Login");
        button.addActionListener(e -> System.out.println(""));

        // Ajout des composants au frame
        frame.add(textFieldUsername);
        frame.add(textFieldPassword);
        frame.setLayout(new FlowLayout());
        frame.add(button);

        // Permet d'ajouter le bouton 'fermer'
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        // Pour activer la visibilite du composant
        frame.setVisible(true);
        // Pour modifier le width et le height
        frame.setSize(400, 500);
        // Permet d'aligner verticallement les composants
        frame.setLayout(new BoxLayout(frame, BoxLayout.Y_AXIS));

    }

}





