import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();

        int[] g = {1,7,4,9,2,5};

        System.out.println(s.wiggleMaxLength(g));

        int[] r = {1,17,5,10,13,15,10,5,16,8};
        System.out.println(s.wiggleMaxLength(r));

        int[] a = {1,2,3,4,5,6,7,8,9};
        System.out.println(s.wiggleMaxLength(a));
    }
    public int wiggleMaxLength(int[] nums) {
        if(nums==null) return 0;
        if(nums.length<2) return 1;

        int pos = 1, neg = 1;

        for(int i = 1;i<nums.length;i++) {
            if(nums[i]-nums[i-1]>0) pos = neg + 1;
            else if(nums[i]-nums[i-1]<0)  neg = pos + 1;
        }

        return Math.max(pos,neg);

    }
}
