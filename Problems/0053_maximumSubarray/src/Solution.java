/**
 * Created by Glamdring on 1/25/2017.
 */
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] k = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(s.maxSubArray(k));

    }
    public int maxSubArray(int[] nums) {
        int max=nums[0];
        int sum=0;
        for(int i=0; i<nums.length; i++) {
            if(sum+nums[i] > nums[i]) sum+=nums[i];
            else sum=nums[i];
            if(sum>max) max=sum;
        }
        return max;
    }
}
