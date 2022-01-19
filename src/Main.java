public class Main {
    public static void main(String[] args) throws Exception {
        String inp = FileHandler.readFile("");
        Compressor c = new Compressor(inp);
        Decompressor decompressor = new Decompressor(inp);
        System.out.println(c.compress());


    }
}
