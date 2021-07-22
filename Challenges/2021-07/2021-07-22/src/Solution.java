import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.partitionDisjoint(new int[]{5,0,3,8,6}));
        System.out.println(s.partitionDisjoint(new int[]{1,1,1,0,6,12}));
        System.out.println(s.partitionDisjoint(new int[]{1,1,2,1,1,5,4}));
        System.out.println(s.partitionDisjoint(new int[]{0,1})); //1
        System.out.println(s.partitionDisjoint(new int[]{1,1})); //1
        System.out.println(s.partitionDisjoint(new int[]{1,0,1})); //2

    }
    public int partitionDisjoint(int[] nums) {

        int n = nums.length;

        int[] max = new int[n];
        max[0] = nums[0];

        //max of left partition
        for(int i=1;i<nums.length;i++) {
            max[i] = Math.max(max[i-1],nums[i]);
        }

        int[] min = new int[n];
        min[n-1] = nums[n-1];

        //for min of right partition
        for(int i=n-2;i>=0;i--) {
            min[i] = Math.min(min[i+1],nums[i]);
        }

        //determine index of partition
        //s.t. max of left partition < min of right

        for(int i=1;i<n;i++) {
            if(max[i-1]<=min[i]) return i;
        }

        return -1;

    }
}
