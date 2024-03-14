public class HashFunctionFactory {
    public static HashFunction createOrganicHash() {
        return new OrganicHash();
    }

    public static HashFunction createMD5Hash() {
        return new MD5Hash();
    }

    public static HashFunction createSHA1Hash() {
        // You can implement this method in a similar way to createMD5Hash
        throw new UnsupportedOperationException();
    }
}