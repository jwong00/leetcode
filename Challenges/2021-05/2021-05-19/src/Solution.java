import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
//        System.out.println(5%2);
        System.out.println(s.minMoves2(new int[] {1,10,2,9})); //16
        System.out.println(s.minMoves2(new int[] {1,11,2,9})); //17
        System.out.println(s.minMoves2(new int[] {1,15,2,9})); //21

        System.out.println(s.minMoves2(new int[] {1,0,0,8,6})); //14
        System.out.println(s.minMoves2(new int[] {1,0,8,6})); //14


    }
    public int minMoves2(int[] nums) {
        if(nums.length==0) return 0;

        Arrays.sort(nums);

        int median = 0;
        if(nums.length % 2 !=0 ) median=nums[nums.length/2];
        else {
            median = (nums[nums.length/2]+nums[(nums.length/2)-1])/2;
        }

        int min = 0;

        for(int i=0;i<nums.length;i++) {
            min+=Math.abs(nums[i]-median);
        }
        return min;
    }
}
