import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

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

    /*
    * This method should remove the specified value, but also maintain
    * consistency of the hashmap for the purposes of selecting elements
    * at random.
    * */
    public boolean remove(int val) {
        if(!valKey.containsKey(val)) return false;

        int key = valKey.get(val);
        int size = keyVal.size();

        //if not last keyed element, rotate
        if(key < size-1) {

            //preserve elements at the "end" of hashmap
            int keyLast = valKey.get(size-1);
            int valLast = keyVal.get(keyLast);

            //remove the last elements
            keyVal.remove(keyLast);
            valKey.remove(valLast);

            //remove val
            keyVal.remove(key);
            valKey.remove(val);

            //patch the "hole" with the elements from end
            keyVal.put(key,valLast);
            valKey.put(valLast,key);

        }
        else {
            keyVal.remove(key);
            valKey.remove(val);
        }

        return true;
    }

    /*
    * Returns a random value from the set.
    *
    * Does not check to see if set has any elements.
    * */
    public int getRandom() {
        int rand = ThreadLocalRandom.current().nextInt(0,keyVal.size());

        return keyVal.get(rand);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */