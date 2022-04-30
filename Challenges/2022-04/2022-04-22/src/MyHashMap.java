import java.util.Arrays;
import java.util.LinkedList;

class MyHashMap {

    static final int M = 68917;
    static final int TABLE_SZ = M+1;
//    static final int M = 999983;

    LinkedList<>[] map;

    public MyHashMap() {
        map = new LinkedList<>[TABLE_SZ];
//        Arrays.fill(map,-1);
    }

    public int hash(int key) {
        return key % M;
    }

    public void put(int key, int value) {
        map[key] = value;
    }

    public int get(int key) {
        return map[key];
    }

    public void remove(int key) {
        map[key] = -1;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
