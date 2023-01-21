import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        //iterate over nums, find and list nonDecreasing intervals
        int last_idx=0;
        int last_val = nums[0];
        ArrayList<Integer[]> intervals = new ArrayList<>();
        for(int i=1;i<nums.length;i++) {
            //if cur < prev elem
            //add new interval
            // (last_idx,prev_idx)
            //then set last_idx to i
        }

        //
        System.out.println(intervals);

        return null;
    }
}
