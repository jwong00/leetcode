import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.maxResult(new int[] {1,-1,-2,4,-7,3},2));
    }
    public int maxResult(int[] nums, int k) {
        if(nums==null || k==0) return 0;
        int[] dp = new int[nums.length];
        int n = nums.length;

        Arrays.fill(dp,Integer.MIN_VALUE);
        dp[n-1] = nums[n-1];

        return helperNaive(0,k,nums,dp);
    }

    //passes 57/65 test cases, fails due to TLE
    public int helperNaive(int i,int k,int[] nums, int[] dp) {
        if(dp[i]!=Integer.MIN_VALUE) return dp[i];

        //dp i+1 --> i+k

        for(int j=i+1; j<=i+k && j<=nums.length-1; j++) {
            dp[i] = Math.max(dp[i], nums[i]+helperNaive(j,k,nums,dp));
        }

        return dp[i];
    }

    


}
