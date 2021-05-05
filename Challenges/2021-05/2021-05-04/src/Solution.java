class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.checkPossibility(new int[] {4,2,3})); //t
        System.out.println(s.checkPossibility(new int[] {4,2,1,1})); //f
        System.out.println(s.checkPossibility(new int[] {0,8,8,8,8,4,7})); //f
        System.out.println(s.checkPossibility(new int[] {0,8,8,8,8,4,8})); //t
        System.out.println(s.checkPossibility(new int[] {0,9,4,8,8,9})); //t

    }
    public boolean checkPossibility(int[] nums) {

        int nd = 0;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++) {
            max = Math.max(max,nums[i]);
            if(nums[i]<max) ++nd;
        }

        int ni = 0;
        int min = Integer.MAX_VALUE;
        for(int i=nums.length-1;i>=0;i--) {
            min = Math.min(min,nums[i]);
            if(nums[i]>min)  ++ni;
        }

        return Math.min(nd,ni)<=1;

    }
}
