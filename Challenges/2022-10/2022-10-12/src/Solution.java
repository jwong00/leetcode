import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.largestPerimeter(new int[]{2,1,2}));
        System.out.println(s.largestPerimeter(new int[]{1,1,2}));
    }
    public int largestPerimeter(int[] nums) {
        if(nums.length<3) return 0;
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));

        for(int i=nums.length-1;i>=2;i--) {
            if(nums[i-2]+nums[i-1]>nums[i]) return nums[i-2]+nums[i-1]+nums[i];
        }

        return 0;
    }
}
