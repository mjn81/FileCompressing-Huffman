import java.util.HashMap;

public abstract class CD {
    protected String text;
    HashMap<Character, Integer> counts;
    HashMap<Character, String> codes;
    protected Queue queue;

    protected void makeQueue() {
        queue = new Queue(counts.size());
        counts.forEach((k, v) -> {
            try {
                queue.enqueue(new Tree(new Node(k.toString(), v)));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    protected void readTree(Node root, String code) {
        if (root.right == null && root.left == null) {
            codes.put(root.data.charAt(0), code);
        }
        if (root.right != null) {
            readTree(root.right, code + "1");
        }
        if (root.left != null) {
            readTree(root.left, code + "0");
        }
    }

    protected void makeCodes() throws Exception {
        makeQueue();
        while (queue.getSize() > 1) {
            Tree one = queue.dequeue();
            Tree two = queue.dequeue();
            Tree merged = new Tree(one.getRoot(), two.getRoot());
            queue.enqueue(merged);
        }
        Tree res = queue.dequeue();
        readTree(res.getRoot(), "");
    }
}
