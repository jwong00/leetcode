import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.minimumAverageDifference(new int[]{2,5,3,9,5,3}));
        System.out.println(s.minimumAverageDifference(new int[]{0}));
    }
    public int minimumAverageDifference(int[] nums) {
        int n = nums.length;
        long[] sum_lr = new long[n+1], sum_rl = new long[n+1];

        sum_lr[0] = nums[0];
        sum_rl[n-1] = nums[n-1];

        for(int i=1;i<n;i++) {
            sum_lr[i] = nums[i] + sum_lr[i-1];
        }
        for(int i=n-2;i>=0;i--) {
            sum_rl[i] = nums[i] + sum_rl[i+1];
        }
//        System.out.println(Arrays.toString(nums));
//        System.out.println(Arrays.toString(sum_lr));
//        System.out.println(Arrays.toString(sum_rl));

        int min_ind = 0;
        long min_val = Integer.MAX_VALUE;
        for(int i=0;i<n;i++) {
            long cur_min = Math.abs(sum_lr[i]/(i+1)-sum_rl[i+1]/Math.max(1,(n-i-1)));
            if(cur_min < min_val) {
                min_val = cur_min;
                min_ind = i;
            }
        }

        return min_ind;
    }
}
