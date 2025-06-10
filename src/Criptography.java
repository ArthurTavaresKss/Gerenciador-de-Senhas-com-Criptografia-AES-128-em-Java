import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class Criptography {
    // Método para gerar uma chave AES-128
    
    // Chave fixa (16 bytes = 128 bits)
    private static final byte[] chaveFixa = "myKeyForMe123456".getBytes(); 

    // Método para obter a chave
    public static SecretKey getKey() { // Criptography.getKey()
        return new SecretKeySpec(chaveFixa, "AES");
    }

    // Método para criptografar
    public static String encrypt(String plaintext, SecretKey key) throws Exception { // Criptography.encrypt()
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding"); // ECB ou CBC
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedBytes = cipher.doFinal(plaintext.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    // Método para descriptografar
    public static String decrypt(String ciphertext, SecretKey key) throws Exception { // Criptography.decrypt()
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(ciphertext));
        return new String(decryptedBytes);
    }
}