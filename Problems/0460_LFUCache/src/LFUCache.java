import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * Created by Glamdring on 11/23/2016.
 */


public class LFUCache {
    public static void main(String[] args) {
        LFUCache c = new LFUCache(2);
        c.set(1,1);
        c.set(2,2);
        System.out.println(c.get(1));
        c.set(3,3);
        System.out.println(c.get(2));
        System.out.println(c.get(3));
        c.set(4,4);
        System.out.println(c.get(1));
        System.out.println(c.get(3));
        System.out.println(c.get(4));
        LFUCache r = new LFUCache(0);
        r.set(0,0);
        r.get(0);
    }
    private class Element implements Comparable<Element> {
        public Element(int k, int v) {
//            System.out.println(load+"/"+capacity);
            this.key=k;
            this.val=v;
            this.age=calls;
        }

        public int compareTo(Element e) {
            if(this.freq<e.freq) return -1;
            else if(this.freq>e.freq) return 1;
            else if(this.age<e.age) return -1;
            else /*if(this.age>e.age)*/ return 1;
            //else return 0; //should never happen
        }
        public String toString() {
           return "K=" + key + " V=" + val + " A=" + age + " F=" + freq;
        }
        public void print() {
            System.out.println(toString());
        }
        int key;
        int age;
        int val;
        int freq=0;
    }
    /*
     * calls is incremented whenever the LFU gets or sets
     * is used to break ties in the case that two keys have been called equally frequently
     * guarantees ages of elements are unique
     */
    public int calls = 0;
    public int capacity = 0;
    public int load = 0;
    public boolean OUTPUT=false;
    public boolean DEBUG=false;

    public PriorityQueue<Element> frequencyQueue;
    public HashMap<Integer,Element> cache;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        frequencyQueue = new PriorityQueue<>();
    }

    public int get(int key) {
        if(capacity==0) return -1;
        if(OUTPUT) System.out.println("Setting "+key);

        ++calls;
        Element e=cache.get(key);
        if(e!=null) {
            e.freq++;
            if(DEBUG) e.print();
            return e.val;
        }
        else return -1;
    }

    /*
     * Attempts to set the value, and increment frequency for an element if it exists
     * if it does not, the element E is created, age is set to calls, and frequency is set to 1
     */
    public void set(int k, int v) { //key.val++
        if(capacity==0) return;
        if(OUTPUT) System.out.println("Setting "+k);
        ++calls;
        Element e=cache.get(k);
        if(e!=null) { //element exists
            e.freq++;
            e.val=v;
        }
        else {
            e=new Element(k,v);
            e.freq++;
            if(load>=capacity) { //evict one
                Element t=frequencyQueue.poll();
                System.out.println("Evicting " +t.key);
                cache.remove(t.key);
                load--;
            }
            load++; //place new cache element
            cache.put(e.key,e);
            frequencyQueue.add(e);
        }
        if(DEBUG) e.print();
    }

}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.set(key,value);
 */