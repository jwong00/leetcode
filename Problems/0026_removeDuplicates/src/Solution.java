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
        int[] a2 = {0,1,1,1,1,1,10};
        System.out.println(Arrays.toString(a2));
        System.out.println(s.removeDuplicates(a2));
        System.out.println(Arrays.toString(a2));
    }
    public int removeDuplicates(int[] nums) {
        if(nums.length==0) return 0;
        int curMin=nums[0];
        int newLength=1;
        for(int i=1;i<nums.length;i++) {
            if(nums[i]<=curMin) {
                for(int j=i+1;j<nums.length;j++) {
                    if(nums[j]>curMin) {
                        nums[i]=nums[j];
                        curMin=nums[j];
                        newLength++;
                        break;
                    }
                }
            }
            else {
                curMin=nums[i];
                newLength++;
            }
        }
        return newLength;

    }
}
