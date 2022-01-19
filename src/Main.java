public class Main {
    public static void main(String[] args) throws Exception {

        Compressor c = new Compressor("abacabcabcdaabcde");
        Decompressor decompressor = new Decompressor(c.compress());
        System.out.println(decompressor.decompress());

    }
}
