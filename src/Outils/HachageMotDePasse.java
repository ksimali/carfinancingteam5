package Outils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class HachageMotDePasse {
    // Generer un sel aleatoire
    private static byte[] recupererSel() throws NoSuchAlgorithmException {
        SecureRandom secureRandom = SecureRandom.getInstanceStrong();
        byte[] sel = new byte[16];
        secureRandom.nextBytes(sel);
        return sel;
    }

    // Hachage du mot de passe a partir du sel generer
    private static String hachMotPasse(String password, byte[] sel) throws NoSuchAlgorithmException {
        // SHA-256
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        messageDigest.update(sel);
        byte[] motDePasseHache = messageDigest.digest(password.getBytes());

        // Conversion de byte a string
        StringBuilder motDePasse = new StringBuilder();
        for (byte b : motDePasseHache) {
            motDePasse.append(String.format("%02x", b));
        }
        return motDePasse.toString();
    }

}
