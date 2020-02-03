import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class LRUCache {
    int capacity;
    int countElements;
    int counter;
    boolean DEBUG = true;
    HashMap<Integer,Integer> values;
    HashMap<Integer,Integer> calls;

    class Node {
        int value;
        Node prev;
        Node next;
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
    }

    public LRUCache(int capacity) {
        this.capacity=capacity;
        countElements=0;
        counter=0;
        values = new HashMap();
        calls = new HashMap();
    }

    public int get(int key) {
//        counter++;
        if(!values.containsKey(key)) return -1;
        else {

            increment(key);
            return values.get(key);
        }
    }

    public void put(int key, int value) {
        if(values.containsKey(key)) {
//            increment(key);
        }
        else if(countElements >= capacity) {
            //evict
            evict(key);
        }
        else if(countElements < capacity) {
            countElements++;
        }

        //should always put k,v, so it's outside the conditionals
        if(DEBUG) System.out.println("returns "+key + DEBUG());
        increment(key);
        values.put(key,value);
    }

    private String DEBUG() {
        return ", calls: "+counter+", elements: "+countElements;
    }

    private void increment(int key) {
        counter++;
        calls.put(key, counter);
    }

    private void evict(int key) {
        //get lowest value from calls
        int min = Integer.MAX_VALUE;
        int target = 0;

        //Set<Map.Entry<Integer,Integer>> entries = values.entrySet();

        for(Map.Entry<Integer,Integer> entry : calls.entrySet()) {
            int callCount = entry.getValue();
            if(callCount < min) {
                min = callCount;
                target = entry.getKey();
            }
        }

        values.remove(target);
        calls.remove(target);
        --counter;
        if(DEBUG) System.out.println("evicts key "+target+" to insert "+key+DEBUG());

        //iterate over entrySet until K,V s.t. eS(V) == C(V)
        //remove K
    }
}
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */