import java.util.*;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.minSetSize(new int[] {3,3,3,3,5,5,5,2,2,7}));
        System.out.println(s.minSetSize(new int[] {1,2,3,4,5,6,7,8,9,10}));
    }
    public int minSetSize(int[] arr) {
        LinkedHashMap<Integer,Integer> freq = new LinkedHashMap<>();

        for(int i=0;i<arr.length;i++) {
            if(freq.containsKey(arr[i])) freq.put(arr[i],freq.get(arr[i])+1);
            else freq.put(arr[i],1);
        }

        TreeMap<Integer,List<Integer>> keys = new TreeMap<>();

        Set<Integer> keySet = freq.keySet();
        for(Integer key : keySet) {
            int f = freq.get(key);
            if(!keys.containsKey(f)) keys.put(f,new ArrayList<Integer>());
            keys.get(f).add(key);
        }

        System.out.println(keys.toString());
        int size=0, removed=0;

        keySet = keys.descendingKeySet();
        ArrayList<Integer> debug = new ArrayList<> () ;
        for(Integer f : keySet) {
            for(Integer k : keys.get(f)) {
                removed+=f;
                size++;
                debug.add(k);
                if(removed>=arr.length/2) break;
            }
            if(removed>=arr.length/2) break;
        }


        /*
        int size=0;
        int removed=0;
        Set<Integer> keys = freq.keySet();
        ArrayList<Integer> debug = new ArrayList<>();

        while(removed<arr.length/2) {

            //greedily select highest-frequency int
            int max_freq = -1;
            int max_key = -1;

            for(Integer key : keys) {
               if(freq.get(key) > max_freq) {
                   max_freq = freq.get(key);
                   max_key = key;
               }
            }

            if(max_key > -1 && max_freq> -1  ) {
                //add to set of final results
                size++;
                removed+=max_freq;
                //remove from initial set
                keys.remove(max_key);
            }

        }*/

        return size;
    }
}
