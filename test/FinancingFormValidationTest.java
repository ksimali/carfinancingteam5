import Outils.FinancingFormValidation;
import org.junit.*;
import javax.swing.*;
import static org.junit.Assert.*;

public class FinancingFormValidationTest {
    @Test
    public void testValidateFields_WithValidInput() {
        // Créer des champs textuels valides pour les tests
        JTextField tfName = new JTextField("John");
        JTextField tfEmail = new JTextField("john.doe@example.com");
        JTextField tfPhone = new JTextField("1234567890");
        JTextField tfVin = new JTextField("12345678901234567");
        JTextField tfMontant = new JTextField("1000");
        JTextField tfDuree = new JTextField("12");
        JTextField tfKm = new JTextField("50000");

        // Appeler la méthode de validation
        boolean result = FinancingFormValidation.validateFields(tfName, tfEmail, null, tfPhone, tfVin, tfMontant, tfDuree, tfKm);

        // Vérifier que la validation réussit
        assertTrue(result);
    }

    @Test
    public void testValidateFields_WithInvalidName() {
        // Créer un champ textuel avec un nom invalide
        JTextField tfName = new JTextField("123");

        // Appeler la méthode de validation
        boolean result = FinancingFormValidation.validateFields(tfName, new JTextField(), null, new JTextField(), new JTextField(), new JTextField(), new JTextField(), new JTextField());

        // Vérifier que la validation échoue
        assertFalse(result);
    }

    @Test
    public void testValidateFields_WithInvalidEmail() {
        // Créer un champ textuel avec un email invalide
        JTextField tfEmail = new JTextField("invalid_email");

        // Appeler la méthode de validation
        boolean result = FinancingFormValidation.validateFields(new JTextField("John"), tfEmail, null, new JTextField(), new JTextField(), new JTextField(), new JTextField(), new JTextField());

        // Vérifier que la validation échoue
        assertFalse(result);
    }
}
