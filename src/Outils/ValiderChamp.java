package Outils;

import javax.swing.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValiderChamp {
    // Validation du mot de passe
    private static boolean validerMotDePasse(String password) {
        Pattern pattern = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$");
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

    public static boolean validerInscription(JPasswordField pfPassword, JPasswordField pfConfirmPassword, JDialog parent, JTextField... fields) {
        String password = new String(pfPassword.getPassword());
        String confirmPassword = new String(pfConfirmPassword.getPassword());

        // Verification que aucun champ n'est vide
        for (JTextField field : fields) {
            if (field.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(parent, "Tous les champs doivent être remplis.");
                return false;
            }
        }

        // Vérifier que les champs de mot de passe correspondent
        if (!password.equals(confirmPassword)) {
            JOptionPane.showMessageDialog(parent, "Les mots de passe ne correspondent pas.");
            return false;
        }

        // Verification de la longueur du mot de passe et des caractères requis
        if (!validerMotDePasse(password)) {
            JOptionPane.showMessageDialog(parent, "Le mot de passe doit contenir plus de 7 caractères, incluant un caractère spécial, une lettre majuscule, et un chiffre.");
            return false;
        }

        return true; // Toutes les validations ont réussi
    }
}
