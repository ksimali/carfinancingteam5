package view;

import Dao.ClientDAOImpl;
import Dao.DonneesArrayList;
import Dao.InvestorDAOImpl;
import Outils.HachageMotDePasse;
import Outils.ValiderChamp;
import model.Client;
import model.Investor;
import model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class LoginView extends JDialog {
    private final JPanel loginPanel;
    private final GridBagConstraints gbc;
    private final JComboBox<String> cbChoisirRole;
    private JTextField tfEmail;
    private JPasswordField pfPassword;

    public LoginView() {
        setTitle("Se connecter");
        setSize(500, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        GridBagLayout gbl = new GridBagLayout();
        loginPanel = new JPanel(gbl);
        setLayout(gbl);
        add(loginPanel);

        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Marge externe pour chaque composant

        // Label "Email"
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;
        JLabel lblEmail = new JLabel("Email");
        loginPanel.add(lblEmail, gbc);

        // TextField pour "Email"
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        tfEmail = new JTextField(15);
        loginPanel.add(tfEmail, gbc);

        // Label "Password"
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;
        JLabel lblPassword = new JLabel("Mot de passe");
        loginPanel.add(lblPassword, gbc);

        // PasswordField pour "Password"
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        pfPassword = new JPasswordField(15);
        loginPanel.add(pfPassword, gbc);

        // LabelField pour "TypeUtilisateur"
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;
        JLabel lblType = new JLabel("Type utilisateur");
        loginPanel.add(lblType, gbc);

        // TextField pour "Niveau de risque"
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        // Initialisation et ajout de la liste deroulante
        String[] typeUtilisateur = {"Client", "Investisseur"};
        cbChoisirRole = new JComboBox<>(typeUtilisateur);
        loginPanel.add(cbChoisirRole, gbc);
        cbChoisirRole.setSelectedItem("Client");

        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        JButton btnConnexion = new JButton("Connexion");
        loginPanel.add(btnConnexion, gbc);

        btnConnexion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                seConnecter();
            }
        });
    }

    private void seConnecter(){
        boolean valid = ValiderChamp.validerConnexion(pfPassword, tfEmail, this);
        if(valid){
            String motDePasse = new String(pfPassword.getPassword());
            System.out.println("Email: " + tfEmail.getText() + "\nMot de passe: " + motDePasse);

            if (cbChoisirRole.getSelectedItem().equals("Client")) {
                ClientDAOImpl clientDAO = new ClientDAOImpl();
                Client client = clientDAO.getClientByEmail(tfEmail.getText());
                if(client!=null) {
                    boolean isValid = validateUserConnexion(client, motDePasse);
                    if(isValid){
                        client.afficherDetails();
                        JOptionPane.showMessageDialog(this, "User " + client.getName() + " connecte avec succes.");
                        effacer();
                        this.dispose();
                    } else {
                        JOptionPane.showMessageDialog(this, "Le mot de passe est incorrecte");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Aucun utilisateur trouve");
                }
            } else if (cbChoisirRole.getSelectedItem().equals("Investisseur")) {
                InvestorDAOImpl investorDAO = new InvestorDAOImpl();
                Investor investor = investorDAO.getInvestorByEmail(tfEmail.getText());
                if(investor!=null) {
                    boolean isValid = validateUserConnexion(investor, motDePasse);
                    if(isValid){
                        investor.afficherDetails();
                        JOptionPane.showMessageDialog(this, "User " + investor.getName() + " connecte avec succes.");
                        // afficher la fenetre des investissement
                        InvestmentView invstment = new InvestmentView();
                        invstment.setVisible(true);
                        effacer();
                        this.dispose();
                    } else {
                        JOptionPane.showMessageDialog(this, "Le mot de passe est incorrecte");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Aucun utilisateur trouve");
                }
            }
        }
    }

    private void effacer(){
        tfEmail.setText("");
        pfPassword.setText("");
    }

    private boolean validateUserConnexion(User user, String passsword) {
        try {
             byte[] sel = HachageMotDePasse.stringToByte(user.getSel());
             String motDePasseHache = HachageMotDePasse.hachMotPasse(passsword, sel);
             if(user.getPassword().equals(motDePasseHache)){
                 return true;
             }
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    private User validateConnexion(String email, String password) {
        ArrayList<User> users = new ArrayList<>();
        DonneesArrayList.users.forEach(user -> {
            if(user.getEmail().equalsIgnoreCase(email)){
                users.add(user);
            }
        });

        User user = null;
        if(!users.isEmpty()){
            try {
                user = users.get(0);
                byte[] sel = user.getSel().getBytes();
                String motDePasseHache = HachageMotDePasse.hachMotPasse(password, sel);
                if(user.getPassword().equals(motDePasseHache)){
                    return user;
                }
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }
        }
        return user;
    }
}
