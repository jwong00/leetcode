import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.runningSum(new int[]{1,2,3,4})));
        System.out.println(Arrays.toString(s.runningSum(new int[]{1,1,1,1,1})));
        System.out.println(Arrays.toString(s.runningSum(new int[]{3,1,2,10,1})));
    }
    public int[] runningSum(int[] nums) {
        int[] runningSum = new int[nums.length];

        runningSum[0] = nums[0];
        for(int i=1;i<nums.length;i++) {
            runningSum[i] = nums[i] + runningSum[i-1];
        }

        return runningSum;
    }
}
