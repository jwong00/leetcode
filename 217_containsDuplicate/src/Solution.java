import java.util.HashSet;

/**
 * Created by Glamdring on 3/29/2017.
 */
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] k = {1,2,3,4,5};
        System.out.println(s.containsDuplicate(k));
    }
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> hs = new HashSet<Integer>();
        for(int i=0;i<nums.length;i++) {
            if(!hs.contains(nums[i])) hs.add(nums[i]);
            else return true;
        }
        return false;

    }
}
