public class Main {
    public static void main(String[] args) throws Exception {

        Node[] sa = new Node[5];
        sa[0] = new Node("a" , 6);
        sa[1] = new Node("b" , 4);
        sa[2] = new Node("c" , 4);
        sa[3] = new Node("d" , 2);
        sa[4] = new Node("e" , 1);
        Tree[] ta = new Tree[5];
        for (int i = 0; i < 5; i++) {
            ta[i] = new Tree(sa[i]);
        }
        Queue q = new Queue();
        for (int i = 0; i < 5; i++) {
            q.enqueue(ta[i]);
        }
        for (int i = 0; i < 5; i++) {
            Tree smp = q.dequeue();
            System.out.println(smp);
        }

    }
}
