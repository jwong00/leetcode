import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.lengthOfLIS(new int[]{0,3,1,6,2,2,7}));
        System.out.println(s.lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
        System.out.println(s.lengthOfLIS(new int[]{1,2}));
        System.out.println(s.lengthOfLIS(new int[]{1,0}));
    }
    public int lengthOfLIS(int[] nums) {
        int[] memo = new int[nums.length];

        Arrays.fill(memo,1);

        int max = 1;
        for(int i=1;i<nums.length;i++) {
            for(int j=0;j<i;j++) {
               if(nums[j]<nums[i]) memo[i] = Math.max(memo[i],memo[j]+1);
            }
            max = Math.max(max,memo[i]);
        }
        return max;

    }

}
