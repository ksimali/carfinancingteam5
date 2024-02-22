import javax.swing.*;

public class Main extends JFrame { /* extends JFrame class pour utiliser les methode de la classe */

    // Créer un panel pour ajouter des boutons
    static JPanel panel = new JPanel();
    public Main(){

        // création de la fenetre principale
        setTitle("Financement Auto");
        setSize(850, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // centre la fenêtre au centre de l'écran

        // Creation des boutons 'Se connecter' et 'S'enregistrer'
        JButton loginButton = new JButton("Se connecter");
        JButton registerButton = new JButton("S'enregistrer");

        // Ajout des boutons au panel via la methode add()
        panel.add(loginButton);
        panel.add(registerButton);

    }
    public static void main(String[] args) {

        Main frame = new Main();
        //Ajout du panel au Frame
        frame.add(panel);
        // rendre visible le Frame
        frame.setVisible(true);

    }
}