import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.findPairs(new int[]{3,1,4,1,5},2));
        System.out.println(s.findPairs(new int[]{1,2,3,4,5},1));
        System.out.println(s.findPairs(new int[]{1,3,1,5,4},0));
    }
    public int findPairs(int[] nums, int k) {

        HashSet<Integer> nums_hash = new HashSet<>();

        for(int i=0;i<nums.length;i++) {
            nums_hash.add(nums[i]);
        }

        int count_pairs = 0;

        HashSet<ArrayList<Integer>> pairs = new HashSet<>();

        for(int i : nums_hash) {

            if(nums_hash.contains(i-k)) {
                pairs.add(new ArrayList(Arrays.asList(Math.min(i-k,i),Math.max(i-k,i))));
            }

            if(nums_hash.contains(i+k)) {
                pairs.add(new ArrayList(Arrays.asList(Math.min(i+k,i),Math.max(i+k,i))));
            }

        }


        return pairs.size();
    }
}
