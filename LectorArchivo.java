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
        // Implementar la lógica para obtener un objeto Estudiante a partir de una línea del archivo.
    }

    public Map<String, Estudiante> getEstudiantes() {
        return estudiantes;
    }
}
