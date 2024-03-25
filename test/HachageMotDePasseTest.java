import Outils.HachageMotDePasse;
import org.junit.Test;
import static org.junit.Assert.*;

import java.security.NoSuchAlgorithmException;

public class HachageMotDePasseTest {

    @Test
    public void testRecupererSel() throws NoSuchAlgorithmException {
        // Appeler la méthode pour récupérer le sel
        byte[] sel = HachageMotDePasse.recupererSel();

        // Vérifier que le sel n'est pas nul
        assertNotNull(sel);
        // Vérifier que la longueur du sel est de 16
        assertEquals(16, sel.length);
    }

    @Test
    public void testHachMotPasse() throws NoSuchAlgorithmException {
        // Sel de test
        byte[] sel = "abcdefghijklmnop".getBytes();
        // Mot de passe de test
        String password = "password";

        // Appeler la méthode pour hacher le mot de passe
        String hashedPassword = HachageMotDePasse.hachMotPasse(password, sel);

        // Vérifier que le mot de passe haché n'est pas nul
        assertNotNull(hashedPassword);
        // Vérifier que la longueur du mot de passe haché est de 64 (SHA-256)
        assertEquals(64, hashedPassword.length());
    }

    @Test
    public void testByteToString() {
        // Bytes de test
        byte[] bytes = {0x48, 0x65, 0x6c, 0x6c, 0x6f}; // "Hello" en ASCII

        // Appeler la méthode pour convertir les bytes en chaîne de caractères
        String result = HachageMotDePasse.byteToString(bytes);

        // Vérifier que la chaîne résultante est correcte
        assertEquals("48656c6c6f", result);
    }

    @Test
    public void testStringToByte() {
        // Chaîne de test
        String str = "48656c6c6f"; // "Hello" en ASCII

        // Appeler la méthode pour convertir la chaîne en bytes
        byte[] result = HachageMotDePasse.stringToByte(str);

        // Vérifier que le tableau de bytes résultant est correct
        byte[] expected = {0x48, 0x65, 0x6c, 0x6c, 0x6f}; // "Hello" en ASCII
        assertArrayEquals(expected, result);
    }
}
