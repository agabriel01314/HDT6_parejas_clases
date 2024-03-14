import java.lang.reflect.Executable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.ExecutionException;

public class HashMD5 implements FuncionesHash{

    @Override
    public String obtenerHash(String dato) {
        try{
            return obtenerMD5(dato);
            
        }
        catch(Exception e){
            return "";
        }
    }
    private static String obtenerMD5(String cadena) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
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
