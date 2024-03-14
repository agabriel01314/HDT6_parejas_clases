

public class HashSHA1Test {

    @Test
    public void testObtenerHash() {
        HashSHA1 hashSHA1 = new HashSHA1();
        String input = "";
        assertEquals("aaf4c61ddcc5e8a2dabede0f3b482cd9aea9434d", hashSHA1.obtenerHash(input));
    }

    private void assertEquals(String string, String obtenerHash) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'assertEquals'");
    }
}
