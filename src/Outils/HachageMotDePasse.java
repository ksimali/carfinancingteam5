package Outils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class HachageMotDePasse {
    // Generer un sel aleatoire
    public static byte[] recupererSel() throws NoSuchAlgorithmException {
        SecureRandom secureRandom = SecureRandom.getInstanceStrong();
        byte[] sel = new byte[16];
        secureRandom.nextBytes(sel);
        return sel;
    }

    // Hachage du mot de passe a partir du sel generer
    public static String hachMotPasse(String password, byte[] sel) throws NoSuchAlgorithmException {
        // SHA-256
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        messageDigest.update(sel);
        byte[] motDePasseHache = messageDigest.digest(password.getBytes());

        return byteToString(motDePasseHache);
    }

    public static String byteToString (byte[] cByte) {
        // Conversion de byte a string
        StringBuilder sb = new StringBuilder();
        for (byte b : cByte) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    public static byte[] stringToByte(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                    + Character.digit(s.charAt(i+1), 16));
        }
        return data;
    }

}
