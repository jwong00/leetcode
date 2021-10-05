import java.util.HashMap;

/**
 * Created by Glamdring on 3/31/2017.
 * Given an array of integers and an integer k, find out whether there are two
 * distinct indices i and j in the array such that nums[i] = nums[j] and the
 * absolute difference between i and j is at most k.
 *
 * Find two elements of equal value that are at most k apart
 */
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] a = {1,2,3,4,7,4,8,9};
        int[] b = {1,2,1,44,1,1,1,1,44,1,1,12};
        System.out.println(s.containsNearbyDuplicate(a, 1));
        System.out.println(s.containsNearbyDuplicate(a, 2));
        System.out.println(s.containsNearbyDuplicate(a, 3));
    }
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap();
        for(int i=0;i<nums.length;i++) {
            if(!hm.containsKey(nums[i])) hm.put(nums[i],i);
            else if(hm.get(nums[i]) >= i-k) return true; //same elem at most k away
            else hm.put(nums[i],i);
        }
        return false;
    }
}
