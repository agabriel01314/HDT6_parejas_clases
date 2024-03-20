import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ProgramaPrincipal {

    @SuppressWarnings("resource")
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Selección de implementación de Mapa
        System.out.println("Seleccione la implementación de mapa a utilizar:");
        System.out.println("1. HashMap");
        System.out.println("2. TreeMap");
        System.out.println("3. LinkedHashMap");
        int opcionMapa = scanner.nextInt();

        Map<String, Estudiante> mapaEstudiantes = MapFactory.obtenerMap(opcionMapa);

        // Selección de función hash
        System.out.println("Seleccione la función hash a utilizar para las claves:");
        System.out.println("1. Orgánica");
        System.out.println("2. MD5");
        System.out.println("3. SHA1");
        int opcionHash = scanner.nextInt();

        FuncionesHash funcionHash = HashFactory.obtenerHash(opcionHash);

        // Lectura de estudiantes desde el archivo JSON
        try {
            LectorArchivo lector = new LectorArchivo("estudiantes.json", funcionHash);
            lector.leerEstudiantes();
            mapaEstudiantes = lector.getEstudiantes();
        } catch (IOException e) {
            System.out.println("Error al leer el archivo JSON de estudiantes.");
            e.printStackTrace();
            return;
        }

        // Menú principal
        while (true) {
            System.out.println("\nMenú Principal:");
            System.out.println("1. Buscar estudiante por clave");
            System.out.println("2. Buscar estudiantes por nacionalidad");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            int opcionMenu = scanner.nextInt();

            switch (opcionMenu) {
                case 1:
                    scanner.nextLine(); // Consumir la nueva línea pendiente
                    System.out.print("Ingrese la clave del estudiante a buscar: ");
                    String clave = scanner.nextLine();
                    Estudiante estudiante = mapaEstudiantes.get(clave);
                    if (estudiante != null) {
                        System.out.println("Estudiante encontrado:");
                        System.out.println(estudiante);
                    } else {
                        System.out.println("Estudiante no encontrado.");
                    }
                    break;
                case 2:
                    scanner.nextLine(); // Consumir la nueva línea pendiente
                    System.out.print("Ingrese la nacionalidad de los estudiantes a buscar: ");
                    String nacionalidad = scanner.nextLine();
                    List<Estudiante> estudiantesPorNacionalidad = BusquedaPorNacionalidad.buscarPorNacionalidad(mapaEstudiantes, nacionalidad);
                    if (!estudiantesPorNacionalidad.isEmpty()) {
                        System.out.println("Estudiantes encontrados con nacionalidad " + nacionalidad + ":");
                        for (Estudiante e : estudiantesPorNacionalidad) {
                            System.out.println(e);
                        }
                    } else {
                        System.out.println("No se encontraron estudiantes con nacionalidad " + nacionalidad + ".");
                    }
                    break;
                case 3:
                    System.out.println("Saliendo del programa...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        }
    }
}
