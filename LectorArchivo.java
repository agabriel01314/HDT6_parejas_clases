import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LectorArchivo {

    private final String rutaArchivo;
    private FuncionesHash funcionHash;
    private Map<String, Estudiante> estudiantes;

    public LectorArchivo(String rutaArchivo, FuncionesHash funcionHash) {
        this.rutaArchivo = rutaArchivo;
        this.funcionHash = funcionHash;
        this.estudiantes = new HashMap<>();
    }

    public void leerEstudiantes() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                Estudiante estudiante = obtenerEstudianteDeLinea(linea);
                String llave = funcionHash.obtenerHash(estudiante.getCodigo());
                estudiantes.put(llave, estudiante);
            }
        }
    }

    private Estudiante obtenerEstudianteDeLinea(String linea) {
        return null;
        // Implementar la lógica para obtener un objeto Estudiante a partir de una línea del archivo.
    }

    public Map<String, Estudiante> getEstudiantes() {
        return estudiantes;
    }
    public static Map<String, List<Estudiante>> guardarPorNacionalidad(Map<String, Estudiante> estudiantes) {
    Map<String, List<Estudiante>> estudiantesPorNacionalidad = new HashMap<>();
    for (Estudiante estudiante : estudiantes.values()) {
        String nacionalidad = estudiante.getNacionalidad();
        List<Estudiante> estudiantesLista = estudiantesPorNacionalidad.getOrDefault(nacionalidad, new ArrayList<>());
        estudiantesLista.add(estudiante);
        estudiantesPorNacionalidad.put(nacionalidad, estudiantesLista);
    }
    return estudiantesPorNacionalidad;
}

}
