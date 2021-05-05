class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
//        System.out.println(s.jump(new int[] {2,3,1,1,4}));
//        System.out.println(s.jump(new int[] {2,3,0,1,4}));
//        System.out.println(s.jump(new int[] {3,2,1}));
        System.out.println(s.jump(new int[] {9,0,0,1,0,1,1,1,1,3,1,1,1})); //3
    }
    public int jump(int[] nums) {

        int jumps=0;
        for(int i=0;i<nums.length;) {
            int best=Integer.MIN_VALUE;
            int nextIndex=0;
            jumps++;
            if(i+nums[i]>nums.length-1) break;

            //find best within range
            for(int j=i+1;j<nums.length && j<=j+nums[i];j++) {
                if(nums[j]>best) {
                    best = nums[j];
                    nextIndex=j;
                }
            }

            i=nextIndex;

        }

        return jumps;



    }
}
