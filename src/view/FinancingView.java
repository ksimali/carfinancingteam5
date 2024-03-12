package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Outils.FinancingFormValidation;

public class FinancingView extends JDialog {
    private final JPanel financingPanel;
    private final GridBagConstraints gbc;
    private JTextField tfEmail;
    private JTextField tfName;
    private JTextField tfPhone;
    private JTextField tfVin;
    private JTextField tfMontant;
    private JTextField tfDuree;
    private JTextField tfKm;

    //constructor
    public FinancingView(){
        setTitle("DEMANDE DE FINANCEMENT");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setResizable(false); // windows not resizable
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        GridBagLayout gbl = new GridBagLayout();
        financingPanel = new JPanel(gbl);
        setLayout(gbl);
        add(financingPanel);

        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Marge externe pour chaque composant

        // Label "Name"
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;
        JLabel lblName = new JLabel("Nom");
        financingPanel.add(lblName, gbc);

        // TextField pour "Name"
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        tfName = new JTextField(15);
        financingPanel.add(tfName, gbc);

        // Label "Email"
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;
        JLabel lblEmail = new JLabel("Email");
        financingPanel.add(lblEmail, gbc);

        // TextField pour "Email"
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        tfEmail = new JTextField(15);
        financingPanel.add(tfEmail, gbc);

        // Label "Phone"
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;
        JLabel lblPhone = new JLabel("Telephone");
        financingPanel.add(lblPhone, gbc);

        // TextField pour "Phone"
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        tfPhone = new JTextField(15);
        financingPanel.add(tfPhone, gbc);

        // Label pour "VIN"
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;
        JLabel lblVin = new JLabel("VIN(17 caractères)");
        financingPanel.add(lblVin, gbc);

        // TextField pour "VIN"
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        tfVin = new JTextField(15);
        financingPanel.add(tfVin, gbc);

        // Label pour "Montant du prêt"
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;
        JLabel lblMontant = new JLabel("Montant du prêt désiré");
        financingPanel.add(lblMontant, gbc);

        // TextField pour "Montant du prêt"
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        tfMontant = new JTextField(15);
        financingPanel.add(tfMontant, gbc);

        // Label pour "Durée du prêt"
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;
        JLabel lblDuree = new JLabel("Durée du prêt(mois)");
        financingPanel.add(lblDuree, gbc);

        // TextField pour "Durée du prêt"
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        tfDuree = new JTextField(15);
        financingPanel.add(tfDuree, gbc);

        // Label pour "kilométrage"
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;
        JLabel lblKm = new JLabel("Kilométrage");
        financingPanel.add(lblKm, gbc);

        // TextField pour "kilométrage"
        gbc.gridx = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        tfKm = new JTextField(15);
        financingPanel.add(tfKm, gbc);

        // Bouton "Envoyez"
        gbc.gridx = 1;
        gbc.gridy = 8;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        JButton btnSubmit = new JButton("Envoyer");
        financingPanel.add(btnSubmit, gbc);

        // bouton "Effacer"
        gbc.gridx = 2;
        gbc.gridy = 8;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        JButton btnDelete = new JButton("Effacer");
        financingPanel.add(btnDelete, gbc);

        // Bouton "Retour menu principal"
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        JButton btnRetour = new JButton("Retour");
        financingPanel.add(btnRetour, gbc);

        // btnEnvoyer addActionListener
        btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                submitRequest();
            }
        });
        // btnDelete addActionListener
        btnDelete.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                tfEmail.setText("");
                tfName.setText("");
                tfPhone.setText("");
                tfVin.setText("");
                tfMontant.setText("");
                tfDuree.setText("");
                tfKm.setText("");
            }
        });

        // btnRetour addActionListener
        btnRetour.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
    }
    private void submitRequest(){
        System.out.println("Name: "+ tfName.getText()+ "\nEmail: " + tfEmail.getText()+"\nPhone:"
                + tfPhone.getText()+"\nVIN: "+ tfVin.getText() + "\nMontant: "+ tfMontant.getText()
                +"\nDurée: " + tfDuree.getText() +"\nKm:" + tfKm.getText());
        // appel du FinancingFormValidation
        boolean valid = FinancingFormValidation.validateFields(tfName, tfEmail, this, tfPhone, tfVin, tfMontant, tfDuree, tfKm);
        if(valid){
            JOptionPane.showMessageDialog(this, "Votre demande de financement  pour le véhicule " + tfVin.getText() + " a bien été soumis avec succes.");
        }
    }
}

