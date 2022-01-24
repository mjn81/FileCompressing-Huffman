import java.util.HashMap;

public class Decompressor extends CD {

    HashMap<String, Character> codes;

    public Decompressor(String encoded, HashMap<Character, Integer> counts) {
        this.text = encoded;
        this.counts = counts;
        codes = new HashMap<>();
    }

    @Override
    protected void readTree(Node root, String code) {
        if (root.right == null && root.left == null) {
            codes.put(code, root.data.charAt(0));
        }
        if (root.right != null) {
            readTree(root.right, code + "1");
        }
        if (root.left != null) {
            readTree(root.left, code + "0");
        }
    }

    public String decompress() throws Exception {
        makeCodes();
        String temp = "";
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            temp += text.charAt(i);
            if (codes.containsKey(temp)) {
                res.append(codes.get(temp));
                temp = "";
            }
        }
        return res.toString();
    }
}
