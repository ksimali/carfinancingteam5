package view;

import Outils.ValiderChamp;
import model.Client;
import model.Investor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

public class RegisterView extends JDialog {
    private final JComboBox<String> cbChoisirRole;
    private final JPanel registerPanel;
    private final GridBagConstraints gbc;
    private final ArrayList<Component> dynamicComponents = new ArrayList<Component>();
    private JComboBox<String> cbMaritalStatut;
    private JComboBox<String> cbRiskLevel;
    private JComboBox<String> cbEduLevel;

    JTextField tfName, tfEmail, tfPhone, tfEmploy, tfRevenu, tfBanque, tfDetailsBanque;
    JTextField tfCreditScore, tfBirthday, tfMaritalStatut, tfResidencyPeriod;
    JPasswordField pfPassword, pfConfirmPassword;

    public RegisterView(){
        setTitle("S'inscrire");
        setSize(550, 550);
        setLocationRelativeTo(null);
        setResizable(false); // windows not resizable
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
        gbc.gridy = 12;
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
        gbc.gridy = 12;
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
        if (cbChoisirRole.getSelectedItem().equals("Client"))
        {
            System.out.println(cbChoisirRole.getSelectedItem());
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

            // Label pour "Note de Credit"
            gbc.gridx = 0;
            gbc.gridy = 8;
            gbc.gridwidth = 1;
            gbc.fill = GridBagConstraints.NONE;
            JLabel lblCreditScore = new JLabel("Note de Credit");
            registerPanel.add(lblCreditScore, gbc);
            dynamicComponents.add(lblCreditScore);

            // Textfield pour "Note de Credit"
            gbc.gridx = 1;
            gbc.gridwidth = 2;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            tfCreditScore = new JTextField(15);
            registerPanel.add(tfCreditScore, gbc);
            dynamicComponents.add(tfCreditScore);

            // Label pour "Date de Naissance"
            gbc.gridx = 0;
            gbc.gridy = 9;
            gbc.gridwidth = 1;
            gbc.fill = GridBagConstraints.NONE;
            JLabel lblDateNaissance = new JLabel("Date de Naissance");
            registerPanel.add(lblDateNaissance, gbc);
            dynamicComponents.add(lblDateNaissance);

            // Textfield pour "Date de Naissance"
            gbc.gridx = 1;
            gbc.gridwidth = 2;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            tfBirthday = new JTextField(15);
            registerPanel.add(tfBirthday, gbc);
            dynamicComponents.add(tfBirthday);

            // Label pour "Statut Marital"
            gbc.gridx = 0;
            gbc.gridy = 10;
            gbc.gridwidth = 1;
            gbc.fill = GridBagConstraints.NONE;
            JLabel lblStatutMarital = new JLabel("Statut Marital");
            registerPanel.add(lblStatutMarital, gbc);
            dynamicComponents.add(lblStatutMarital);

            // TextField pour " Statut Marital"
            gbc.gridx = 1;
            gbc.gridwidth = 2;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            // Initialisation et ajout de la liste deroulante
            String[] martialStatut = {"Célibataire", "marié(e)"};
            cbMaritalStatut = new JComboBox<>(martialStatut);
            registerPanel.add(cbMaritalStatut, gbc);
            dynamicComponents.add(cbMaritalStatut);
            cbMaritalStatut.setSelectedItem("Célibataire");

            // Label pour la durée de vie au Canada : "Etabli au Canada depuis"
            gbc.gridx = 0;
            gbc.gridy = 11;
            gbc.gridwidth = 1;
            gbc.fill = GridBagConstraints.NONE;
            JLabel lblSejourCanada = new JLabel("Etabli au Canada depuis (en mois)");
            registerPanel.add(lblSejourCanada, gbc);
            dynamicComponents.add(lblSejourCanada);

            // TextField pour la durée de vie au Canada : "Etabli au Canada depuis"
            gbc.gridx = 1;
            gbc.gridwidth = 2;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            tfResidencyPeriod = new JTextField(15);
            registerPanel.add(tfResidencyPeriod, gbc);
            dynamicComponents.add(tfResidencyPeriod);

        }else if (cbChoisirRole.getSelectedItem().equals("Investisseur"))
        {
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

            // LabelField pour "Details Banque"
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

            // LabelField pour "Niveau de risque souhaité"
            gbc.gridx = 0;
            gbc.gridy = 8;
            gbc.gridwidth = 1;
            gbc.fill = GridBagConstraints.NONE;
            JLabel lblRiskLevel = new JLabel("Niveau de risque souhaité");
            registerPanel.add(lblRiskLevel, gbc);
            dynamicComponents.add(lblRiskLevel);

            // TextField pour "Niveau de risque"
            gbc.gridx = 1;
            gbc.gridwidth = 2;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            // Initialisation et ajout de la liste deroulante
            String[] riskLevel = {"peu de risque", "risqué","très risqué"};
            cbRiskLevel = new JComboBox<>(riskLevel);
            registerPanel.add(cbRiskLevel, gbc);
            dynamicComponents.add(cbRiskLevel);
            cbRiskLevel.setSelectedItem("peu de risque");

            // LabelField pour "Niveau d'Etude en Investissement"
            gbc.gridx = 0;
            gbc.gridy = 9;
            gbc.gridwidth = 1;
            gbc.fill = GridBagConstraints.NONE;
            JLabel lblEduLevel = new JLabel("Niveau d'étude en Investissement");
            registerPanel.add(lblEduLevel, gbc);
            dynamicComponents.add(lblEduLevel);

            // TextField pour "Niveau d'Etude en Investissement'"
            gbc.gridx = 1;
            gbc.gridwidth = 3;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            // Initialisation et ajout de la liste deroulante
            String[] eduLevel = {"peu", "moyen","beaucoup"};
            cbEduLevel = new JComboBox<>(eduLevel);
            registerPanel.add(cbEduLevel, gbc);
            dynamicComponents.add(cbEduLevel);
            cbEduLevel.setSelectedItem("peu");
        }
        registerPanel.revalidate();
        registerPanel.repaint();
    }

    private void sInscrire() {
        boolean valid = false;
        if (cbChoisirRole.getSelectedItem().equals("Client")) {
            valid = ValiderChamp.validerInscription(pfPassword, pfConfirmPassword, tfEmail, this, tfEmploy, tfRevenu, tfName, tfPhone);
            if(valid){
                Client client = new Client(tfName.getText(), tfEmail.getText(), new String(pfPassword.getPassword()), tfPhone.getText(), tfEmploy.getText(), BigDecimal.valueOf(Double.parseDouble(tfRevenu.getText())),Integer.parseInt(tfCreditScore.getText()), LocalDate.parse(tfBirthday.getText()), tfMaritalStatut.getText(), Integer.parseInt(tfResidencyPeriod.getText()));
                client.afficherDetails();
                effacer();
                JOptionPane.showMessageDialog(this, "Client " + tfName.getText() + " cree avec succes.");
                this.dispose();
            }
        } else if (cbChoisirRole.getSelectedItem().equals("Investisseur")) {
            valid = ValiderChamp.validerInscription(pfPassword, pfConfirmPassword, tfEmail, this, tfBanque, tfDetailsBanque, tfName, tfPhone);
            if(valid){
                Investor investor = new Investor(tfName.getText(), tfEmail.getText(), new String(pfPassword.getPassword()), tfPhone.getText(), tfBanque.getText(), tfDetailsBanque.getText(), cbRiskLevel.getSelectedItem().toString(),cbEduLevel.getSelectedItem().toString() );
                investor.afficherDetails();
                effacer();
                JOptionPane.showMessageDialog(this, "Investisseur " + tfName.getText() + " cree avec succes.");
                this.dispose();
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
