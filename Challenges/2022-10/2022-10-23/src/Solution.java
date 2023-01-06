import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.findErrorNums(new int[]{2,2})));
    }
    public int[] findErrorNums(int[] nums) {
        for(int i=0;i<nums.length;i++) {
            if(nums[i] < 0) return new int[]{nums[i],i+1};
            else {
                nums[nums[i]-1] *= -1;
            }
        }
        return new int[]{};
    }
}
