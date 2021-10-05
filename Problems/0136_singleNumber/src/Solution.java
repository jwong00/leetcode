import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by Glamdring on 2/25/2017.
 */
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] k = {1,2,1,3,3};
        int[] a = {6,6,2,2,0,0,1,8,1,8};
        System.out.println(s.singleNumber(k));
        System.out.println(s.singleNumber(a));
    }

    public int singleNumber(int[] nums) {
        HashSet<Integer> h = new HashSet<Integer>();
        for(int i=0;i<nums.length;i++) {
            if(h.contains(nums[i])) h.remove(nums[i]);
            else h.add(nums[i]);
        }
        if(h.size()==1) System.out.println("Contains singleton: "+ Arrays.toString(nums));
        else System.out.println("Doesn't contain singleton: "+ Arrays.toString(nums));
        for(Integer i : h) {
            return i;
        }
        return 0;
    }
}
