import java.util.HashMap;

public class Compressor {
    private String text;
    HashMap<Character, Integer> counts;
    private Queue queue;

    public Compressor(String text) {
        this.text = text;
        counts = new HashMap<>();
    }

    private void findCounts(){
        for (int i = 0; i < text.length(); i++) {
            char temp = text.charAt(i);
            if(!counts.containsKey(temp)){
                counts.put(temp, 0);
            }
            counts.replace(temp, counts.get(temp) + 1);
        }
    }

    public void compress(){
        findCounts();
        queue = new Queue(counts.size());
        for (int i = 0; i < counts.size(); i++) {
            queue.enqueue(new Tree(new Node(counts.)));
        }
    }


}
