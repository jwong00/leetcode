import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.subarraysDivByK(new int[]{4,5,0,-2,-3,1},5));
    }
    public int subarraysDivByK(int[] nums, int k) {

        for(int i=1;i<nums.length;i++) {
            nums[i]+=nums[i-1];
        }
        System.out.println(Arrays.toString(nums));
        int count = 0;

        for(int i=0;i<nums.length;i++) {
            if(nums[i]%k==0) count++;
            for(int j=i+1;j<nums.length;j++) {
                if((nums[j]-nums[i])%k==0) count++;
            }
        }

        return count;

    }
}
