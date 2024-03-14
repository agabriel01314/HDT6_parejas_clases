import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class HashOrganicaTest {

    @Test
    public void testObtenerHash() {
        HashOrganica hashOrganica = new HashOrganica();
        String input = "";
        assertEquals(input, hashOrganica.obtenerHash(input));
    }
}
