package view;

import javax.swing.*;

public class StatusView extends JDialog {
    JLabel brand;
    JLabel model;
    JLabel year;
    JLabel km;
    public StatusView(JFrame parent) {
        super(parent, "STATUT DE LA DEMANDE DE FINANCEMENT", true);

        setSize(400, 300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(parent);

        JLabel titleLabel = new JLabel("Information concernant le véhicule : ");
        brand = new JLabel("Marque du véhicule : NISSAN");
        model = new JLabel("Modele du véhicule : JUKE");
        year = new JLabel("Année du véhicule : 2020");
        km = new JLabel("Kilométrage du véhicule : 65000");
        JLabel statusLabel = new JLabel("Statut: En Cours");
        JProgressBar progressBar = new JProgressBar();
        progressBar.setValue(20);
        JButton retourButton = new JButton("Retour");
        JButton modifierButton = new JButton("Modifier la demande");
        modifierButton.setEnabled(false);

        JPanel contentPane = new JPanel();
        contentPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
        contentPane.add(titleLabel);
        contentPane.add(brand);
        contentPane.add(model);
        contentPane.add(year);
        contentPane.add(km);
        contentPane.add(statusLabel);
        contentPane.add(progressBar);
        contentPane.add(Box.createVerticalStrut(10));
        contentPane.add(modifierButton);
        contentPane.add(retourButton);

        setContentPane(contentPane);

        retourButton.addActionListener(e -> dispose());
    }
}
