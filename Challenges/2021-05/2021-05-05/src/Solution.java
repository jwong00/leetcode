class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.jump(new int[] {2,3,1,1,4})); //2
        System.out.println(s.jump(new int[] {2,3,0,1,4})); //2
        System.out.println(s.jump(new int[] {3,2,1})); //1
        System.out.println(s.jump(new int[] {9,0,0,1,0,1,1,1,1,3,1,1,1})); //2
        System.out.println(s.jump(new int[] {3,0,0,1,1,2,1,5,1,3,1,4,1,2})); //6

        System.out.println(s.jump(new int[] {0})); //0
    }
    public int jump(int[] nums) {

        if(nums.length==1) return 0;

        int jumps=0;
        for(int i=0;i<nums.length;) {
            int best=Integer.MIN_VALUE;
            int nextIndex=0;
            jumps++;
            if(i+nums[i]>=nums.length-1) break;
            //find best within range
            for(int j=i+1;j<nums.length && j<i+1+nums[i];j++) {
                if(nums[j]>best) {
                    best = nums[j];
                    nextIndex=j;
                }
//                System.out.println("Searching from "+nums[i]+" "+nums[j]);
            }

//            System.out.println(best+" "+nextIndex);
            i=nextIndex;

        }

        return jumps;



    }
}
