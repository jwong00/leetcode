import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.runningSum(new int[] {1,2,3,4})));
    }
    public int[] runningSum(int[] nums) {
        if(nums==null || nums.length==0) return new int[] {};

        int[] result = new int[nums.length];

        result[0]=nums[0];

        for(int i=1;i<result.length;i++) {
            result[i] = nums[i]+result[i-1];
        }

        return result;
    }
}
