public class HashFactory {

    public static FuncionesHash obtenerHash(int opcion) {
        switch (opcion) {
            case 1:
                return new HashOrganica();
            case 2:
                return new HashMD5();
            case 3:
                return new HashSHA1();
            default:
                throw new IllegalArgumentException("Opción no válida");
        }
    }
}