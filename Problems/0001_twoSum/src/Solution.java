import java.util.Arrays;
import java.util.HashMap;
//import java.util.HashSet;

/**
 * Created by Glamdring on 9/29/2016.
 *
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 *
 * You may assume that each input would have exactly one solution.
 *
 *  Example:
 *   Given nums = [2, 7, 11, 15], target = 9,
 *   Because nums[0] + nums[1] = 2 + 7 = 9,
 *   return [0, 1].
 *
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums={2,7,11,15};
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.twoSum(nums,9)));
    }

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> cache = new HashMap<>();

        for(int i=0;i<nums.length;i++) {
            if(cache.containsKey(target-nums[i])) return new int[]{cache.get(target-nums[i]),i};
            else cache.put(nums[i],i);
        }

        //System.out.println("No solution");
        return new int[]{};
    }
}