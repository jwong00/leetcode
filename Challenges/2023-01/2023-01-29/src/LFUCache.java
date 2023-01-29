import java.util.*;

class LFUCache {
    public static void main(String[] args) {
        LFUCache cache = new LFUCache(2);
        cache.put(1,1);
        cache.put(2,2);
        System.out.println(cache.get(1));
        cache.put(3,3);
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
        cache.put(4,4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }

    /*
        maps k->e
        e[0] : key
        e[1] : value
        e[2] : freq
        e[3] : time

        an entry might look more like this:
    */
    HashMap<Integer,Integer[]> entries;
    PriorityQueue<Integer[]> order;

    int capacity;
    int time;

    public LFUCache(int capacity) {

        this.capacity = capacity;
        this.time = 0;

        entries = new HashMap<>();

        /* Sort on frequency. Break ties with time stamp. */
        order = new PriorityQueue<Integer[]>(new Comparator<Integer[]>() {
            public int compare(Integer[] a, Integer[] b) {
                if(a[2]-b[2]==0) return a[3]-b[3];
                else return a[2]-b[2];
            }
        });

    }

    public int get(int key) {

        if(capacity==0) return -1;
        if(!entries.containsKey(key)) return -1;

        time++;

        Integer[] entry = entries.get(key);
        entry[2]++;
        entry[3] = time;
        order.remove(entry);
        order.offer(entry);

        return entries.get(key)[1];

    }

    public void put(int key, int value) {

        if(capacity==0) return;

        time++;

        if(!entries.containsKey(key)) {

            if(entries.size()>=capacity && order.size()>=capacity) {
                assert order.peek() != null;
                entries.remove(order.peek()[0]);
                order.remove();
            }
            entries.put(key,new Integer[]{key,value,1,time});
            order.offer(entries.get(key));
            return;

        }

        Integer[] entry = entries.get(key);
        entry[1] = value;
        entry[2]++;
        entry[3] = time;

        order.remove(entry);
        order.offer(entry);

    }

}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
