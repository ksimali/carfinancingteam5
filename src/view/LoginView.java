package view;

import Dao.DonneesArrayList;
import Outils.HachageMotDePasse;
import Outils.ValiderChamp;
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

        gbc.gridx = 1;
        gbc.gridy = 2;
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
            System.out.println("Email: " + tfEmail.getText() + "\nMot de passe: " + new String(pfPassword.getPassword()));
            User user = validateConnexion(tfEmail.getText(), new String(pfPassword.getPassword()));
            if(user != null) {
                user.afficherDetails();
                JOptionPane.showMessageDialog(this, "User " + tfEmail.getText() + " connecte avec succes.");
                effacer();
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Les informations entrees sont incorrectes.");
            }
        }
    }

    private void effacer(){
        tfEmail.setText("");
        pfPassword.setText("");
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
