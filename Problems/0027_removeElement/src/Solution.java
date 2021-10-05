import java.util.Arrays;

/**
 * Created by Glamdring on 11/3/2016.
 */
public class Solution {

    public static boolean DEBUG=false;

    public static void main(String[] args) {

        Solution s = new Solution();
        int[] array1 = {1,2,5,1,2,5,2,2,7,23,7,4,8,9,4,10,8,2};
        System.out.println(s.removeElement(array1,2));
        System.out.println(Arrays.toString(array1));
    }
    public int removeElement(int[] nums, int val) {
        int length=nums.length;

        int count=0;
        for(int i=0;i<length;i++) {
            if(nums[i]==val) count++;
        }

        //for any element i, find an element i+k s.t. k>0
        int temp=0;
        for(int i=0;i<length;i++) {
            if(nums[i]==val) {
                for (int k = i + 1; k < length; k++) {
                    if (nums[k] != val) {
                        temp = nums[i];
                        nums[i] = nums[k];
                        nums[k] = temp;
                    }
                }
            }
        }
        if(DEBUG) System.out.println(count + " instances of " + val);
        return length-count;
    }
}
