import javax.swing.*;

public class Main extends JFrame { /* extends JFrame class pour utiliser les methode de la classe */

    public Main(){
        setTitle("Financement Auto");
        setSize(650, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
    public static void main(String[] args) {

        Main frame = new Main();
        frame.setVisible(true);

    }
}