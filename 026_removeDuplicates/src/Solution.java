import java.util.Arrays;
import java.util.HashSet;
import java.lang.Integer;

/**
 * Created by Glamdring on 11/5/2016.
 */
public class Solution {
    public static final boolean DEBUG=false;
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] a1 = {0,1,1,2,2,3,3,3,3,4,5,7,8,10};
        int[] a2 = {0,1,1,1,1,1,0};
        System.out.println(Arrays.toString(a1));
        s.removeDuplicates(a1);
        System.out.println(Arrays.toString(a1));
    }
    public int removeDuplicates(int[] nums) {
        HashSet<Integer> numsSet = new HashSet<Integer>();
        int bound=nums[0];
        int lastComp=2;
        int newLength = nums.length;
        for(int i=1; i<nums.length-1; i++) {
            if(nums[i]>bound) bound=nums[i];
            else {
                while(nums[lastComp]<=bound) {
                    lastComp++;
                }
                nums[i]=nums[lastComp];
            }
        }
        return newLength;
    }
}
