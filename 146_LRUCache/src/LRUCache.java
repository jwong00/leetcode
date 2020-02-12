import java.util.HashMap;

public class LRUCache {
    boolean DEBUG = true;
    int capacity;
    HashMap<Integer,Node> map; //maps key to Node
    DLL dll;

    public void printList() {
        dll.print();
    }

    class DLL {
        Node head,tail;
        int capacity;
        int elements;

        public DLL(int _capacity) {
            this.capacity = _capacity;
            this.head = this.tail = null;
        }
        public int evict() {
            return remove(head);
        }
        public void print() {
            Node cur = head;
            while(cur!=null) {
                System.out.printf("(%d,%d) ",cur.key,cur.value);
                cur = cur.next;
            }
            System.out.printf("\n");
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
            if(head == null) { //0 elements
                head =  node;
            }
            else {
                node.prev = tail;
                 node.prev.next = node;
                node.next = null;
            }
            tail = node;
        }
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

    public LRUCache(int capacity) {
        if(DEBUG) System.out.printf("LRU cache with capacity %d allocated...\n", capacity) ;
        this.capacity=capacity;
        map = new HashMap<>(capacity);
        dll = new DLL(capacity);
    }

    public int get(int key) {

        if(DEBUG) System.out.printf("cache.get(%d) //returns ",key);
        Node node = map.get(key);
        if(node == null) {
            if(DEBUG) System.out.println("-1");
            return -1;
        }
        else {
            dll.remove(node);
            dll.moveToEnd(node);
            if(DEBUG) System.out.println(node.value);
            return node.value;
        }
    }

    public void put(int key, int value) {
        Node node = map.get(key);

        if(DEBUG) System.out.printf("cache.put(%d,%d) ",key,value);

        if(node != null) { //update key, doesn't change number of keys
            //remove key from current location
//            cur = values.get(key);
            node.value = value;
            dll.remove(node);
        }
        else {
            if (map.size() >= capacity) {
                int r = dll.evict();
                map.remove(r);
                if(DEBUG) System.out.printf("// evicts key %d", r);

            }
            if(DEBUG) System.out.printf("\n");
            node = new Node(key, value);
            map.put(key, node);

        }
        dll.moveToEnd(node);
    }
}
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */