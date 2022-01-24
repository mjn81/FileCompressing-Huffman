import java.util.HashMap;

public class Compressor extends CD {

    public Compressor(String text) {
        this.text = text;
        counts = new HashMap<>();
        codes = new HashMap<>();
    }

    private void findCounts() {
        for (int i = 0; i < text.length(); i++) {
            char temp = text.charAt(i);
            if (!counts.containsKey(temp)) {
                counts.put(temp, 0);
            }
            counts.replace(temp, counts.get(temp) + 1);
        }
    }

    @Override
    protected void makeQueue() {
        findCounts();
        super.makeQueue();
    }

    private String convertText() {
        String result = "";
        for (int i = 0; i < text.length(); i++) {
            result = result.concat(codes.get(text.charAt(i)));
        }
        return result;
    }

    public String compress() throws Exception {
        makeCodes();
        return convertText();
    }

}
