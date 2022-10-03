import java.util.LinkedList;

class MyCircularQueue {

    int capacity;
    int node_count;
    LinkedList<Integer> queue;

    public MyCircularQueue(int k) {
        capacity = k;
        node_count = 0;
        queue = new LinkedList<>();
    }

    public boolean enQueue(int value) {
        if(node_count<capacity) {
            queue.add(value);
            queue.add(node_count%capacity,value);
            node_count++;
            return true;
        }
        else return false;

    }

    public boolean deQueue() {
        if(node_count>0) {
            queue.removeFirst();
            return true;
        }
        else return false;

    }

    public int Front() {
        if(node_count==0) return -1;
        else return queue.getFirst();

    }

    public int Rear() {
        if(node_count==0) return -1;
        else return queue.getLast();

    }

    public boolean isEmpty() {
        return node_count==0;

    }

    public boolean isFull() {
        return node_count==capacity;

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
