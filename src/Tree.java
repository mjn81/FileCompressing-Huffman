public class Tree {
    private final Node root;

    public Tree(Node root) {
        this.root = root;
    }

    public Tree(Node first, Node second) {
        if (first.repeat > second.repeat) {
            root = new Node(first.data.concat(second.data), first.repeat + second.repeat);
            root.left = second;
            root.right = first;
        }
        else if(first.repeat == second.repeat){
            root = new Node(second.data.concat(first.data), first.repeat + second.repeat);
            root.left = first;
            root.right = second;
        }
        else {
            root = new Node(second.data.concat(first.data), first.repeat + second.repeat);
            root.left = first;
            root.right = second;
        }
    }

    public Node getRoot() {
        return root;
    }

    @Override
    public String toString() {
        return root.toString();
    }
}
