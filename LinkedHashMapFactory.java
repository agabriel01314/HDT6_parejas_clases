import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapFactory {

    public static Map<String, Estudiante> obtenerMap() {
        return new LinkedHashMap<>();
    }
}
