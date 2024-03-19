import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashSHA1 implements FuncionesHash {

    @Override
    public String obtenerHash(String dato) {
        try {
            return obtenerSHA1(dato);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "";
        }
    }

    private static String obtenerSHA1(String cadena) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-1");
        md.update(cadena.getBytes());
        byte[] digest = md.digest();

        // Convertir el arreglo de bytes a una representación hexadecimal
        StringBuilder sb = new StringBuilder();
        for (byte b : digest) {
            sb.append(String.format("%02x", b & 0xff));
        }
        return sb.toString();
    }
}
