import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.subarraySum(new int[]{1,1,1},2));
        System.out.println(s.subarraySum(new int[]{1,2,3},3));
    }
    public int subarraySum(int[] nums, int k) {
        if(nums==null || nums.length==0) return 0;

        for(int i=1;i<nums.length;i++) {
            nums[i] += nums[i-1];
        }

        int ans = 0;
        for(int i=0;i<nums.length;i++) {
            if(nums[i]==k) ans++;
            for(int j=i+1;j<nums.length;j++) {
                if(nums[j] - nums[i]==k) ans++;
            }
        }
        return ans;

    }
}
