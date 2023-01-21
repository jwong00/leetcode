import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.subarraysDivByK(new int[]{4,5,0,-2,-3,1},5));
        System.out.println(s.subarraysDivByK(new int[]{5},9));
    }
    public int subarraysDivByK(int[] nums, int k) {
        int[] prefix = new int[nums.length+1];
        for(int i=1;i<nums.length+1;i++) {
            prefix[i] = prefix[i-1] + nums[i-1];
        }
        System.out.println(Arrays.toString(prefix));

        int count = 0;
        for(int l=0;l<nums.length+1;l++) {
            for(int r=l+1;r<nums.length+1;r++) {
                if((prefix[r]-prefix[l])%k==0) count++;
            }
        }
        return count;
    }
}
