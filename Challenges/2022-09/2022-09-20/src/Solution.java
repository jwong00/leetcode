import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.findLength(new int[]{1,2,3,2,1},new int[]{3,2,1,4,7}));
    }
    public int findLength(int[] nums1, int[] nums2) {
        int ans = 0;
        int[][] dp = new int[nums1.length+1][nums2.length+1];

        for(int i=nums1.length-1;i>=0;i--) {
            for(int j=nums2.length-1;j>=0;j--) {
                if(nums1[i]==nums2[j]) dp[i][j] = dp[i+1][j+1]+1;
                ans = Math.max(ans,dp[i][j]);
                System.out.println(Arrays.deepToString(dp));
            }
            System.out.println();
//            System.out.println(nums1[i]+" "+nums2[j]);
        }
        return ans;
    }
}
