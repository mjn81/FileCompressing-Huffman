public class Node {
    String data;
    int repeat;
    Node left, right;

    public Node(String data, int repeat) {
        this.data = data;
        this.repeat = repeat;
        this.left = null;
        this.right = null;
    }

    @Override
    public String toString() {
        return data;
    }
}
