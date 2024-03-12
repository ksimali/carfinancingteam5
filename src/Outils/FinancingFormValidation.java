package Outils;

import javax.swing.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FinancingFormValidation{

    public static boolean validateFields(JTextField tfName, JTextField tfEmail, JDialog parent, JTextField tfPhone, JTextField tfVin, JTextField tfMontant, JTextField tfDuree, JTextField tfKm, JTextField... fields) {

        // Verification que aucun champ n'est vide
        for (JTextField field : fields) {
            if (field.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(parent, "Tous les champs doivent être remplis.");
                return false;
            }
        }

        // Vérification que le nom n'est pas vide
        String namePattern = "^[A-Za-z]{2,20}$";
        if (tfName.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(parent, "Le nom ne peut pas être vide.", "Erreur de validation", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if(!tfName.getText().matches(namePattern)){
            JOptionPane.showMessageDialog(parent, "Le nom n'est pas valide : entre 2 et 20 lettres uniquement", "Erreur de validation", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Vérification du format de l'email
        String emailPattern = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
        if (!tfEmail.getText().matches(emailPattern)) {
            JOptionPane.showMessageDialog(parent, "L'email n'est pas valide.", "Erreur de validation", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Vérification que le téléphone n'est pas vide
        String phonePattern = "^\\d{10}$";
        if (tfPhone.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(parent, "Le numéro de téléphone ne peut pas être vide.", "Erreur de validation", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if(!tfPhone.getText().matches(phonePattern)){
            JOptionPane.showMessageDialog(parent, "Le numéro de téléphone doit avoir 10 chiffres : 2343456345", "Erreur de validation", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Vérification de la longueur du VIN (doit être de 17 caractères)
        if (tfVin.getText().length() != 17) {
            JOptionPane.showMessageDialog(parent, "Le VIN doit contenir exactement 17 caractères.", "Erreur de validation", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Vérification que le montant n'est pas vide et est un nombre
        try {
            Double.parseDouble(tfMontant.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(parent, "Le montant doit être un nombre.", "Erreur de validation", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Vérification que la durée n'est pas vide et est un entier
        try {
            Integer.parseInt(tfDuree.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(parent, "La durée doit être un entier représentant le nombre de mois.", "Erreur de validation", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Vérification que le kilométrage n'est pas vide et est un nombre
        try {
            Double.parseDouble(tfKm.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(parent, "Le kilométrage doit être un nombre.", "Erreur de validation", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Si toutes les validations passent
        return true;
    }


}
