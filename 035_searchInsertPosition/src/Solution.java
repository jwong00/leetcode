/**
 * Created by Glamdring on 1/20/2017.
 */
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] k = {1,2,3,4,5,6,9,11};
        System.out.println(s.searchInsert(k, 12));
        System.out.println(s.searchInsert(k, 0));
    }
    public int searchInsert(int[] nums, int target) {
        if(target>nums[nums.length-1]) return nums.length;
        int i=0;
        while(i<nums.length && target>nums[i] ) {
            i++;
        }
        return i;
    }
}
