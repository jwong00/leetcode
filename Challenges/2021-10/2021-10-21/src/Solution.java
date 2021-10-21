import java.util.HashMap;

class RandomizedSet {
    HashMap<Integer,Integer> keyVal;
    HashMap<Integer,Integer> valKey;

    public RandomizedSet() {
        keyVal = new HashMap<>();
        valKey = new HashMap<>();

    }

    public boolean insert(int val) {
        if(valKey.containsKey(val)) return false;

        //ensures each val is keyed with a unique int
        //and all keys are contiguous from 0..set.size
        int key = keyVal.size();
        keyVal.put(key,val);
        valKey.put(val,key);

        return true;


    }

    public boolean remove(int val) {
        if(!valKey.containsKey(val)) return false;

        int key = valKey.get(val);
        int size = keyVal.size();

        //if not last keyed element, rotate
        if(key < size-1) {
            int keyLast = valKey.get(size-1);
            int valLast = keyVal.get(keyLast);
        }



    }

    public int getRandom() {

    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */