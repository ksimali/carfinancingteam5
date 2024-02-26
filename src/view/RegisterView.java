package view;

import Outils.ValiderChamp;
import model.Client;
import model.Investor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;

public class RegisterView extends JDialog {
    private final JComboBox<String> cbChoisirRole;
    private final JPanel registerPanel;
    private final GridBagConstraints gbc;
    private final ArrayList<Component> dynamicComponents = new ArrayList<Component>();

    JTextField tfName, tfEmail, tfPhone, tfEmploy, tfRevenu, tfBanque, tfDetailsBanque;
    JPasswordField pfPassword, pfConfirmPassword;

    public RegisterView(){
        setTitle("S'inscrire");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        GridBagLayout gbl = new GridBagLayout();
        registerPanel = new JPanel(gbl);
        setLayout(gbl);
        add(registerPanel);

        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Marge externe pour chaque composant

        // Label comboBox
        gbc.gridx = 0;
        gbc.gridy = 0;
        registerPanel.add(new JLabel("Choisir l'utilisateur"), gbc);

        gbc.gridx = 1;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        // Initialisation et ajout de la liste deroulante
        String[] typeUtilisateur = {"Client", "Investisseur"};
        cbChoisirRole = new JComboBox<>(typeUtilisateur);
        registerPanel.add(cbChoisirRole, gbc);
        cbChoisirRole.addActionListener(this::changerUtilisateur);
        cbChoisirRole.setSelectedItem("Client");
    }

    private void changerUtilisateur(ActionEvent e) {

        for (Component comp : dynamicComponents) {
            registerPanel.remove(comp);
        }
        dynamicComponents.clear();

        // Commun à tous les utilisateurs
        // Label "Name"
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;
        JLabel lblName = new JLabel("Nom");
        registerPanel.add(lblName, gbc);
        dynamicComponents.add(lblName);

        // TextField pour "Name"
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        tfName = new JTextField(15);
        registerPanel.add(tfName, gbc);
        dynamicComponents.add(tfName);

        // Label "Email"
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;
        JLabel lblEmail = new JLabel("Email");
        registerPanel.add(lblEmail, gbc);
        dynamicComponents.add(lblEmail);

        // TextField pour "Email"
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        tfEmail = new JTextField(15);
        registerPanel.add(tfEmail, gbc);
        dynamicComponents.add(tfEmail);

        // Label "Phone"
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;
        JLabel lblPhone = new JLabel("Telephone");
        registerPanel.add(lblPhone, gbc);
        dynamicComponents.add(lblPhone);

        // TextField pour "Phone"
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        tfPhone = new JTextField(15);
        registerPanel.add(tfPhone, gbc);
        dynamicComponents.add(tfPhone);

        // Label "Password"
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;
        JLabel lblPassword = new JLabel("Mot de passe");
        registerPanel.add(lblPassword, gbc);
        dynamicComponents.add(lblPassword);

        // PasswordField pour "Password"
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        pfPassword = new JPasswordField(15);
        registerPanel.add(pfPassword, gbc);
        dynamicComponents.add(pfPassword);

        // Label "Confirm Password"
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;
        JLabel lblConfirmPassword = new JLabel("Confirmer le mot de passe");
        registerPanel.add(lblConfirmPassword, gbc);
        dynamicComponents.add(lblConfirmPassword);

        // PasswordField pour "Confirm Password"
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        pfConfirmPassword = new JPasswordField(15);
        registerPanel.add(pfConfirmPassword, gbc);
        dynamicComponents.add(pfConfirmPassword);

        // Bouton "Inscription"
        gbc.gridx = 1;
        gbc.gridy = 8;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        JButton btnInscription = new JButton("Inscription");
        registerPanel.add(btnInscription, gbc);
        dynamicComponents.add(btnInscription);

        btnInscription.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sInscrire();
            }
        });

        // Bouton "Effacer"
        gbc.gridx = 2;
        gbc.gridy = 8;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        JButton btnEffacer = new JButton("Effacer");
        registerPanel.add(btnEffacer, gbc);
        dynamicComponents.add(btnEffacer);

        btnEffacer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                effacer();
            }
        });

        // Champs spécifiques au type d'utilisateur
        if (cbChoisirRole.getSelectedItem().equals("Client")) {
            gbc.gridx = 0;
            gbc.gridy = 6;
            gbc.gridwidth = 1;
            gbc.fill = GridBagConstraints.NONE;
            JLabel lblEmploy = new JLabel("Informations sur l'Emploi");
            registerPanel.add(lblEmploy, gbc);
            dynamicComponents.add(lblEmploy);

            // TextField pour "Informations emploi"
            gbc.gridx = 1;
            gbc.gridwidth = 2;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            tfEmploy = new JTextField(15);
            registerPanel.add(tfEmploy, gbc);
            dynamicComponents.add(tfEmploy);

            gbc.gridx = 0;
            gbc.gridy = 7;
            gbc.gridwidth = 1;
            gbc.fill = GridBagConstraints.NONE;
            JLabel lblRevenu = new JLabel("Revenu Annuel");
            registerPanel.add(lblRevenu, gbc);
            dynamicComponents.add(lblRevenu);

            // TextField pour "Revenu"
            gbc.gridx = 1;
            gbc.gridwidth = 2;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            tfRevenu = new JTextField(15);
            registerPanel.add(tfRevenu, gbc);
            dynamicComponents.add(tfRevenu);
        } else if (cbChoisirRole.getSelectedItem().equals("Investisseur")) {
            gbc.gridx = 0;
            gbc.gridy = 6;
            gbc.gridwidth = 1;
            gbc.fill = GridBagConstraints.NONE;
            JLabel lblBanque = new JLabel("Nom de la Banque");
            registerPanel.add(lblBanque, gbc);
            dynamicComponents.add(lblBanque);

            // TextField pour "Nom Banque"
            gbc.gridx = 1;
            gbc.gridwidth = 2;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            tfBanque = new JTextField(15);
            registerPanel.add(tfBanque, gbc);
            dynamicComponents.add(tfBanque);

            gbc.gridx = 0;
            gbc.gridy = 7;
            gbc.gridwidth = 1;
            gbc.fill = GridBagConstraints.NONE;
            JLabel lblDetailsBanque = new JLabel("Détails du Compte Bancaire");
            registerPanel.add(lblDetailsBanque, gbc);
            dynamicComponents.add(lblDetailsBanque);

            // TextField pour "Details Banque"
            gbc.gridx = 1;
            gbc.gridwidth = 2;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            tfDetailsBanque = new JTextField(15);
            registerPanel.add(tfDetailsBanque, gbc);
            dynamicComponents.add(tfDetailsBanque);
        }
        registerPanel.revalidate();
        registerPanel.repaint();
    }

    private void sInscrire() {
        boolean valid = false;
        if (cbChoisirRole.getSelectedItem().equals("Client")) {
            valid = ValiderChamp.validerInscription(pfPassword, pfConfirmPassword, this, tfEmploy, tfRevenu, tfName, tfEmail, tfPhone);
            if(valid){
                Client client = new Client(tfName.getText(), tfEmail.getText(), new String(pfPassword.getPassword()), tfPhone.getText(), tfEmploy.getText(), BigDecimal.valueOf(Double.parseDouble(tfRevenu.getText())));
                client.afficherDetails();
            }
        } else if (cbChoisirRole.getSelectedItem().equals("Investisseur")) {
            valid = ValiderChamp.validerInscription(pfPassword, pfConfirmPassword, this, tfBanque, tfDetailsBanque, tfName, tfEmail, tfPhone);
            if(valid){
                Investor investor = new Investor(tfName.getText(), tfEmail.getText(), new String(pfPassword.getPassword()), tfPhone.getText(), tfBanque.getText(), tfDetailsBanque.getText());
                investor.afficherDetails();
            }
        }
    }

    private void effacer() {
        if (cbChoisirRole.getSelectedItem().equals("Client")) {
            cbChoisirRole.setSelectedItem("Client");
        } else if (cbChoisirRole.getSelectedItem().equals("Investisseur")) {
            cbChoisirRole.setSelectedItem("Investisseur");
        }
    }
}
