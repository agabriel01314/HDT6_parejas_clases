import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashOrganica implements FuncionesHash{

    @Override
    public String obtenerHash(String dato) {
        try{
            return dato;
            
        }
        catch(Exception e){
            return "";
        }
    }
}
