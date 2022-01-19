import java.util.HashMap;

public class Compressor {
    private String text;
    HashMap<Character, Integer> counts;
    HashMap<Character, String> codes;
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

    private void makeQueue(){
        findCounts();
        queue = new Queue(counts.size());
        counts.forEach((k,v)->{
            try {
                queue.enqueue(new Tree(new Node(k.toString() , v)));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    private void readTree(Node root , String code){
        if(root.right==null&&root.left==null){
            codes.put(root.data.charAt(0) , code);
        }
        if (root.right!=null){
            readTree(root.right , code+"1");
        }
        if (root.left!=null) {
            readTree(root.left , code+"0");
        }
    }

    public void compress() throws Exception {
        makeQueue();
        while (queue.getSize()>1){
            Tree one = queue.dequeue();
            Tree two = queue.dequeue();
            Tree merged = new Tree(one.getRoot() , two.getRoot());
            queue.enqueue(merged);
        }
        Tree res = queue.dequeue();
        readTree(res.getRoot() , "");



    }


}
