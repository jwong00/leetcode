import java.util.*;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.deleteAndEarn(new int[]{3,4,2});
        s.deleteAndEarn(new int[]{8,10,4,9,1,3,5,9,4,10});
        s.deleteAndEarn(new int[]{8,7,3,8,1,4,10,10,10,2});

    }
    public int deleteAndEarn(int[] nums) {
        if(nums==null || nums.length==0) return 0;
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        HashMap<Integer,Integer> map_freq = new HashMap<>();

        //gather all elements into map_freq
        // a mapping of element->freq(element)
        for(int i=0;i<nums.length;i++) {
            if(!map_freq.containsKey(nums[i])) {
                map_freq.put(nums[i],1);
//                System.out.println("ADDING: "+nums[i]);
            }
            else map_freq.put(nums[i],map_freq.get(nums[i])+1);
        }

        //determine best elements to pick first
        //i.e. minimize loss from deletion of all n-1 and all n+1
//        int loss = Integer.MAX_VALUE;

        Set<Map.Entry<Integer,Integer>> set = map_freq.entrySet();

        TreeMap<Integer, ArrayList<Integer>> map_loss = new TreeMap<>();

        /*
        * For each unique int n in nums, get all n-1 and n+1,
        * multiply them by their freq and store those in map_loss
        * this value is the total loss incurred by selecting that key from nums
        * */
        for(Map.Entry<Integer,Integer> e : set) {
            int key = e.getKey();


            int loss = 0;
            if(map_freq.containsKey(key-1)) loss += (key-1) * map_freq.get(key-1);
            if(map_freq.containsKey(key+1)) loss += (key+1) * map_freq.get(key+1);
//            System.out.println("LOSS/KEY: "+key+" "+loss);

            if(!map_loss.containsKey(loss)) {
                ArrayList<Integer> t = new ArrayList<>();
                t.add(key);
                map_loss.put(loss,t);
            }
            else map_loss.get(loss).add(key);

        }

        int score = 0;

//        System.out.println("SIZE OF LOSS: "+map_loss.size());
        while(map_loss.size() > 0) {
            int loss = map_loss.firstKey();
            ArrayList<Integer> bucket = map_loss.get(loss);

            //add to score
            for(int key : bucket) {
                if(map_freq.get(key)==0) continue;
                score += key * map_freq.get(key);

                //remove (invalidate) its neighbor keys
                if(map_freq.containsKey(key-1)) {
                    map_freq.put(key-1,0);
                }
                if(map_freq.containsKey(key+1)) {
                    map_freq.put(key+1,0);
                }

            }

            //remove loss from map_loss so loop
            //advances to the next lowest element
            map_loss.remove(loss);
        }

//        System.out.println(score);
        return score;

    }
}
