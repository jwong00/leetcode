import java.util.*;

class RandomizedSet {

    Map<Integer,Integer> dict;
    List<Integer> list;
    Random rand = new Random();

    public RandomizedSet() {
        dict = new HashMap<>();
        list = new ArrayList<>();
    }

    public boolean insert(int val) {
        if(dict.containsKey(val)) return false;

        dict.put(val,list.size());
        list.add(list.size(),val);

        return true;
    }

    public boolean remove(int val) {
        if(!dict.containsKey(val)) return false;

        int j = list.get(list.size()-1);
        int i = dict.get(val);

        list.set(i,j);
        dict.put(j,i);

        list.remove(list.size()-1);
        dict.remove(val);

        return true;
    }

    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}
