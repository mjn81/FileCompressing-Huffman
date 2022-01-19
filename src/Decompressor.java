import java.util.HashMap;

public class Decompressor {
    private String encoded;
    HashMap<String, Character> codes;

    public Decompressor(String encoded) {
        this.encoded = encoded;
        codes = new HashMap<>();
    }

    private void makeCodeTable() {
        String[] codesData = encoded.split("\n")[0].split(",");
        for (String code : codesData) {
            String[] temp = code.split("=");
            codes.put(temp[1], temp[0].charAt(0));
        }
    }

    public String decompress() {
        makeCodeTable();
        StringBuilder result = new StringBuilder();
        String context = encoded.split("\n")[1];
        String temp = "";
        for (int i = 0; i < context.length(); i++) {
            temp += context.charAt(i);
            if (codes.containsKey(temp)) {
                result.append(codes.get(temp));
                temp = "";
            }
        }
        return result.toString();
    }
}
