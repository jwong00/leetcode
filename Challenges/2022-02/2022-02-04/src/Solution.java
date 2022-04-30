import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.findMaxLength(new int[]{0,1});
    }
    public int findMaxLength(int[] nums) {
        if(nums==null || nums.length==0) return 0;

        int[] zero = new int[nums.length];
        int[] one = new int[nums.length];

        if(nums[0]==0) zero[0] = 1;
        else one[0] = 1;

        for(int i=1;i<nums.length;i++) {
            zero[i] += zero[i-1];
            one[i] +=  one[i-1];


            if(nums[i]==0) zero[i]++;
            else one[i]++;

        }

        System.out.println(Arrays.toString(zero));
        System.out.println(Arrays.toString(one));

        return -1;
    }
}
