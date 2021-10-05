import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by Glamdring on 1/21/2017.
 */
public class Solution {
    public boolean PRINT = true;
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] k = {5,4,3,2};
        int[] j = {1,3,2,1};
        s.nextPermutation(k);
        s.nextPermutation(j);
    }
    /*
        Scan from cur to 0 for int < cur int
        insert there,
        and shift every thing +1

    * */
    public void nextPermutation(int[] nums) {
        if(PRINT) System.out.println("Pre:  "+Arrays.toString(nums));
        for(int i=nums.length-2;i>=0;i--) {
            int t = nums.length-1; //store rightmost digit
            System.out.println(nums[nums.length - 1]);
            System.out.println(nums[i]);
            if(nums[nums.length-1]>=nums[i]) { //pull list forward.
                t=nums[nums.length-1];
                for(int j=nums.length-1;j>i;j--) {
                    System.out.println(nums[j]);
                    nums[j]=nums[j-1];
                }
                nums[i]=t;
                if(PRINT) System.out.println("Post: "+Arrays.toString(nums));
                return;
            }
        }
        for(int i=0;i<nums.length/2;i++) {
            int t=nums[i];
            nums[i]=nums[nums.length-i-1];
            nums[nums.length-i-1]=t;

        }
        if(PRINT) System.out.println("Post: "+Arrays.toString(nums));

    }
}
