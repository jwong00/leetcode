import java.util.HashMap;

public class LRUCache {
    int capacity;
    HashMap<Integer,Node> map; //maps key to Node
    DLL dll;

    public LRUCache(int capacity) {
        this.capacity=capacity;
        map = new HashMap<>(capacity);
        dll = new DLL(capacity);
    }

    public static void main(String args[]) {
        LRUCache cache = new LRUCache( 2 /* capacity */ );

        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // returns 1
        cache.put(3, 3);    // evicts key 2
        cache.get(2);       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        cache.get(1);       // returns -1 (not found)
        cache.get(3);       // returns 3
        cache.get(4);       // returns 4

        cache = new LRUCache(1);
        cache.put(2,1);
        cache.printList();
        cache.get(2);
        cache.printList();
        cache.put(3,2);
        cache.printList();
        cache.get(2);
        cache.printList();
        cache.get(3);
    }

    class Node {
        int key;
        int value;
        Node prev, next;

        public Node(int key,int value) {
            this.key = key;
            this.value = value;
            this.next = null;
            this.prev = null;
        }
    }

    class DLL {
        Node head,tail;
        int capacity;

        public DLL(int _capacity) {
            this.capacity = _capacity;
            this.head = this.tail = null;
        }

        public void print() {
            Node cur = head;
            while(cur!=null) {
                cur = cur.next;
            }
        }
        public int remove(Node node) {
            if(head == tail) {
                head = null;
                tail = null;
            }
            else if(node == head) {
                head = head.next;
                head.prev = null;
            }
            else if(node == tail) {
                tail = tail.prev;
                tail.next = null;
            }
            else {
                node.prev.next = node.next;
                node.next.prev = node.prev;
            }
            return node.key;
        }

        public void moveToEnd(Node node) {
            if(head == null) {
                head =  node;
            }
            else {
                node.prev = tail;
                 node.prev.next = node;
                node.next = null;
            }
            tail = node;
        }

        public int evict() {
            return remove(head);
        }
    }

    public int get(int key) {
        Node node = map.get(key);
        if(node == null) return -1;
        else {
            dll.remove(node);
            dll.moveToEnd(node);
            return node.value;
        }
    }

    public void put(int key, int value) {
        Node node = map.get(key);

        if(node != null) { //update key, doesn't change number of keys
            node.value = value;
            dll.remove(node);
        }
        else {
            if (map.size() >= capacity) {
                int r = dll.evict();
                map.remove(r);
            }
            node = new Node(key, value);
            map.put(key, node);
        }
        dll.moveToEnd(node);
    }

    public void printList() {
        dll.print();
    }
}
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */