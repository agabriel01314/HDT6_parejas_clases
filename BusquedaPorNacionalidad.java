import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BusquedaPorNacionalidad {
    
    public static List<Estudiante> buscarPorNacionalidad(Map<String, Estudiante> estudiantes, String nacionalidad) {
        List<Estudiante> estudiantesPorNacionalidad = new ArrayList<>();
        for (Estudiante estudiante : estudiantes.values()) {
            if (estudiante.getNacionalidad().equals(nacionalidad)) {
                estudiantesPorNacionalidad.add(estudiante);
            }
        }
        return estudiantesPorNacionalidad;
    }
}