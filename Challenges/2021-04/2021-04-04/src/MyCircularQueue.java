class MyCircularQueue {
    public static void main(String[] args) {
        MyCircularQueue q = new MyCircularQueue(3);
        System.out.println(q.enQueue(0));
        System.out.println(q.enQueue(1));
        System.out.println(q.enQueue(2));
        q.printBuffer();
        System.out.println(q.enQueue(3));
        q.printBuffer();
        System.out.println(q.enQueue(4));
//        System.out.println(q.enQueue(5));
        q.printBuffer();
        System.out.println(q.deQueue());
        q.printBuffer();
        System.out.println(q.enQueue(5));
        q.printBuffer();
//        System.out.println(q.deQueue());
//        System.out.println(q.enQueue(5));



    }
    int[] q;
    int head;
    int tail;
    int capacity;

    public MyCircularQueue(int k) {
        q = new int[k+1];
        head = 0;
        tail = 0;
        capacity = k+1;
        System.out.println(q.length);
    }

    public boolean enQueue(int value) {
        if(isFull()) return false;
        // examples of full circ queue
        // k = 10, 0...9/

        //if head 0 tail 9, or head 1 tail 0
        q[tail] = value;

//        System.out.println("Buffer before enqueue is "+head+" to "+tail);
        tail = (tail+1) % (capacity);
//        System.out.println("Buffer after enqueue is "+head+" to "+tail);
        return true;
    }

    public boolean deQueue() {
        if(isEmpty()) return false;

        //just move the head
//        System.out.println("Buffer before dequeue is "+head+" to "+tail);
        head = (head+1) % capacity;
//        System.out.println("Buffer after dequeue is "+head+" to "+tail);

        return true;

    }

    public int Front() {

        if(isEmpty()) return -1;
        else return q[head];
    }

    public int Rear() {
        if(isEmpty()) return -1;
        else if(tail==0) return q[capacity-1];
        else return q[tail-1];
    }

    public boolean isEmpty() {
        return head==tail;
    }

    public boolean isFull() {
        return (head==0 && tail==capacity-1) || tail+1 == head;
    }

    public void printBuffer() {
        System.out.println("Printing from head to tail:");
        for ( int c = head; c != tail; c = (c+1) % capacity) {
            System.out.printf("%d ",q[c]);
        }
        System.out.println();
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
