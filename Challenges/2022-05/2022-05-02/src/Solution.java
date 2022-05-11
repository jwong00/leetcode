import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(Arrays.toString(s.sortArrayByParity(new int[]{3,1,2,4})));
    }
    public int[] sortArrayByParity(int[] nums) {
        int l = 0, r = nums.length-1;

        while(l<=r) {
            if(nums[l]%2==0) l++;
            else if(nums[r]%2!=0) r--;
            else {
                nums[l] = nums[l] + nums[r];
                nums[r] = nums[l] - nums[r];
                nums[l] = nums[l] - nums[r];
            }
        }

        return nums;
    }
}
