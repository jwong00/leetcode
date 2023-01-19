import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.maxSubarraySumCircular(new int[]{1,-2,3,-2}));
        System.out.println(s.maxSubarraySumCircular(new int[]{5,-3,5}));
        System.out.println(s.maxSubarraySumCircular(new int[]{-3,-2,-3}));
    }
    public int maxSubarraySumCircular(int[] nums) {

        int n = nums.length;
        int[] prefix = new int[n];
        prefix[0] = nums[0];
        for(int i=1;i<n;i++) {
            prefix[i] = prefix[i-1] + nums[i];
        }
        System.out.println(Arrays.toString(prefix));

        //iterate over pairs of points l and r s.t.
        //the difference r-l is maximized
        //while accounting for circularity

        int max = 0;
        //iterate left
        for(int l=0;l<n;l++) {
            //iterate right using an offset
            for(int k=1;k<n;k++) {
                //keep r within bounds
                int r = (l+k) % n;
                if(l<r) {
                    max = Math.max(max,prefix[r]-prefix[l]);
                    System.out.println(l+" "+r+" "+max);
                }
            }
        }


        return max;
    }
}
