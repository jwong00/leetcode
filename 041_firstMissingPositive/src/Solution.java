class Solution {
    public int firstMissingPositive(int[] nums) {
        if(nums.length==0) return 0;
        int min = nums[0];
        int max = nums[0];

        for(int i=0;i<nums.length;i++) {
            if(nums[i] < min) min = nums[i];
            if(nums[i] > max) max = nums[i];
        }

        if(min > 1 || max < 1) return 1;






    }
}
