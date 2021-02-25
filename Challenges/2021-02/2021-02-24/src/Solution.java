import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] r = {3,4,-1,1};
        System.out.println(s.firstMissingPositive(r));
    }
    public int firstMissingPositive(int[] nums) {
        if(nums==null || nums.length<1 || nums.length>300 ) return 1;

        boolean[] filter = new boolean[300];

        for(int i=0; i<nums.length;i++) {
            if(nums[i]>0 && nums[i]<300) filter[nums[i]]=true;
        }

        for(int i=1; i<filter.length;i++) {
            if(!filter[i]) return i;
        }

        return -1;
    }
}
