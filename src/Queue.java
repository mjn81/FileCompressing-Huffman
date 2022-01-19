class Queue {
    private int front, rear, size;
    private Tree[] dataList;

    public Queue() {
        this(50);
    }

    public Queue(int size) {
        front = rear = 0;
        this.size = size;
        dataList = new Tree[size];
    }

    public void enqueue(Tree data) throws Exception {
        if (isFull()) {
            throw new Exception("queue is full");
        } else {
            dataList[rear] = data;
            rear++;
        }
        sort();
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public boolean isFull() {
        return size == rear;
    }

    public Tree dequeue() {
        if (isEmpty()) {
            return null;
        }
        Tree data = dataList[front];
        for (int i = front; i < rear - 1; i++) {
            dataList[i] = dataList[i + 1];
        }
        if (rear < size)
            dataList[rear] = null;
        rear--;
        return data;
    }

    void sort() {
        boolean isSorted = false;
        for (int i = front; i < rear - 1 && !isSorted; i++) {
            isSorted = true;
            for (int j = front; j < rear - 1 - i; j++) {
                if (dataList[j].getRoot().repeat > dataList[j + 1].getRoot().repeat) {
                    isSorted = false;
                    Tree temp = dataList[j];
                    dataList[j] = dataList[j + 1];
                    dataList[j + 1] = temp;
                }
            }
        }
    }
}