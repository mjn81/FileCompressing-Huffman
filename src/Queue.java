class Queue {
    private static int front, rear, size;
    private static Tree dataList[];
    public Queue(){
        this(50);
    }
    public Queue(int size)
    {
        front = rear = 0;
        this.size = size;
        dataList = new Tree[size];
    }

    public void enqueue(Tree data) throws Exception {
        if(isFull()){
            throw new Exception("queue is full");
        }
        else {
            dataList[rear] = data;
            rear++;
        }
    }

    public boolean isEmpty(){
        return front == rear;
    }
    public boolean isFull(){
        return size == rear;
    }

    public Tree dequeue() {
        if (isEmpty()) {
            return null;
        }
        Tree data  = dataList[front];
        for (int i = front; i < rear - 1; i++) {
            dataList[i] = dataList[i + 1];
        }
        if (rear < size)
            dataList[rear] = null;
        rear--;
        return data;
    }


}