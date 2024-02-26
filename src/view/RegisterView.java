package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterView extends JDialog {
    private final JComboBox<String> cbChoisirRole;
    private final JPanel registerPanel;
    private final GridBagConstraints gbc;

    public RegisterView(){
        setTitle("S'inscrire");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        GridBagLayout gbl = new GridBagLayout();
        registerPanel = new JPanel(gbl);
        setLayout(gbl);

        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Marge externe pour chaque composant

        // Label comboBox
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel("Choisir l'utilisateur"), gbc);

        gbc.gridx = 1;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        // Initialisation et ajout de la liste deroulante
        String[] typeUtilisateur = {"Client", "Investisseur"};
        cbChoisirRole = new JComboBox<>(typeUtilisateur);
        add(cbChoisirRole, gbc);
        cbChoisirRole.addActionListener(this::changerUtilisateur);
        cbChoisirRole.setSelectedItem("Client");
    }

    private void changerUtilisateur(ActionEvent e) {

        // Commun à tous les utilisateurs
        // Label "Name"
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;
        add(new JLabel("Name"), gbc);

        // TextField pour "Name"
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(new JTextField(15), gbc);

        // Label "Email"
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;
        add(new JLabel("Email"), gbc);

        // TextField pour "Email"
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(new JTextField(15), gbc);

        // Label "Phone"
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;
        add(new JLabel("Phone"), gbc);

        // TextField pour "Phone"
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(new JTextField(15), gbc);

        // Label "Password"
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;
        add(new JLabel("Password"), gbc);

        // PasswordField pour "Password"
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(new JPasswordField(15), gbc);

        // Label "Confirm Password"
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;
        add(new JLabel("Confirm Password"), gbc);

        // PasswordField pour "Confirm Password"
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(new JPasswordField(15), gbc);

        // Bouton "Register"
        gbc.gridx = 1;
        gbc.gridy = 8;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(new JButton("Inscription"), gbc);

        // Champs spécifiques au type d'utilisateur
        if (cbChoisirRole.getSelectedItem().equals("Client")) {
            gbc.gridx = 0;
            gbc.gridy = 6;
            gbc.gridwidth = 1;
            gbc.fill = GridBagConstraints.NONE;
            add(new JLabel("Informations sur l'Emploi"), gbc);

            // TextField pour "EmploymentInfoField"
            gbc.gridx = 1;
            gbc.gridwidth = 2;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            add(new JTextField(15), gbc);

            gbc.gridx = 0;
            gbc.gridy = 7;
            gbc.gridwidth = 1;
            gbc.fill = GridBagConstraints.NONE;
            add(new JLabel("Revenu Annuel"), gbc);

            // TextField pour "Name"
            gbc.gridx = 1;
            gbc.gridwidth = 2;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            add(new JTextField(15), gbc);
        } else if (cbChoisirRole.getSelectedItem().equals("Investisseur")) {
            gbc.gridx = 0;
            gbc.gridy = 6;
            gbc.gridwidth = 1;
            gbc.fill = GridBagConstraints.NONE;
            add(new JLabel("Nom de la Banque"), gbc);

            // TextField pour "EmploymentInfoField"
            gbc.gridx = 1;
            gbc.gridwidth = 2;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            add(new JTextField(15), gbc);

            gbc.gridx = 0;
            gbc.gridy = 7;
            gbc.gridwidth = 1;
            gbc.fill = GridBagConstraints.NONE;
            add(new JLabel("Détails du Compte Bancaire"), gbc);

            // TextField pour "Name"
            gbc.gridx = 1;
            gbc.gridwidth = 2;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            add(new JTextField(15), gbc);
        }
        registerPanel.revalidate();
        registerPanel.repaint();
    }
}
