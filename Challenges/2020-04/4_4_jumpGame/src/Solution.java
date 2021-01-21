class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] q = {2,3,1,1,4};
//        s.canJump(q);
        System.out.println(s.canJump(q));
        int[] w = {3,2,1,0,4};
        System.out.println(s.canJump(w));
    }
    public boolean canJump(int[] nums) {
        if(nums[0]==0) return false;
        boolean[] reachability = new boolean[nums.length];

        for(int i = nums.length-2;i>=0;i--) {
            //check if nums[i] is enough jumps OR if it can jump to any spot with reachability=true
            if(i+nums[i]>=nums.length-1) reachability[i]=true;
            else {
                for(int k=i;k<i+nums[i] && k<nums.length; k++) {
                    if(reachability[k]) reachability[i]=true;
                }
            }
        }
        return reachability[0];
    }

}
