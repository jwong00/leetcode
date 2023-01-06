import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;

class RandomizedSet {
    public static void main(String[] args) {
        RandomizedSet rs = new RandomizedSet();
        System.out.println(rs.insert(1));
//        System.out.println(rs.remove(2));
//        System.out.println(rs.insert(2));
        System.out.println(rs.getRandom());
//        System.out.println(rs.remove(1));
//        System.out.println(rs.insert(2));
        System.out.println(rs.getRandom());
    }

    HashMap<Integer,Integer> virtual_set;
    ArrayList<Integer> list;
    int max;

    public RandomizedSet() {
        virtual_set = new HashMap<>();
        list = new ArrayList<>();
    }

    public boolean insert(int val) {
        if(virtual_set.containsKey(val)) return false;
        list.add(val);
        virtual_set.put(val,list.size());

        return true;
    }

    public boolean remove(int val) {
        if(!virtual_set.containsKey(val)) return false;

        int j = list.get(list.size()-1);
        int i = virtual_set.get(val);

        list.set(i,j);
        virtual_set.put(j,i);

        list.remove(list.size()-1);
        virtual_set.remove(val);

        return true;
    }

    public int getRandom() {
        return list.get((int)(Math.random()*(list.size())));

    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
