import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.productExceptSelf(new int[]{1,2,3,4})));
        System.out.println(Arrays.toString(s.productExceptSelf(new int[]{-1,1,0,-3,3})));

    }
    public int[] productExceptSelf(int[] nums) {
        if(nums==null || nums.length==0) return new int[]{};
        int n = nums.length;

        int mult = 1;

        int[] fromLeft = new int[n];
        for(int i=0;i<n;i++) {
            fromLeft[i] = mult;
            mult*=nums[i];
        }

        mult = 1;
        int[] fromRight = new int[n];
        for(int i=n-1;i>=0;i--) {
            fromRight[i] = mult;
            mult*=nums[i];
        }

        int[] ans = new int[n];

        for(int i=0;i<n;i++) {
            ans[i] = fromLeft[i] * fromRight[i];
        }

        return ans;
    }
}
