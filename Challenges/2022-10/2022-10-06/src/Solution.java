import java.util.HashMap;
import java.util.TreeMap;

class TimeMap {
    public static void main(String[] args) {
        TimeMap tm = new TimeMap();
        tm.set("foo","bar",1);
        System.out.println(tm.get("foo",1));
        System.out.println(tm.get("foo",3));
        tm.set("foo","bar2",4);
        System.out.println(tm.get("foo",4));
        System.out.println(tm.get("foo",5));
    }

    //map key to treemap
    //treemap maps timestamp to value
    HashMap<String, TreeMap<Integer,String>> map;

    public TimeMap() {
        map = new HashMap<>();

    }

    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)) map.put(key,new TreeMap<>());
        map.get(key).put(timestamp,value);
    }

    public String get(String key, int timestamp) {
        if(map.containsKey(key)) {
            Integer cache = map.get(key).floorKey(timestamp);

            return cache==null ? "" : map.get(key).get(cache);
        }
        else return "";
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
