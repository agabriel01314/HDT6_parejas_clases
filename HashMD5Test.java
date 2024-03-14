
public class HashMD5Test {

    @Test
    public void testObtenerHash() {
        HashMD5 hashMD5 = new HashMD5();
        String input = "hello";
        assertEquals("5d41402abc4b2a76b9719d911017c592", hashMD5.obtenerHash(input));
    }
}
