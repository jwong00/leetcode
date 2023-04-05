import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.minimizeArrayValue(new int[]{3,7,1,6}));
    }
    public int minimizeArrayValue(int[] nums) {
        //ordering of indices sorted by the ascending order of
        //the values they index
        PriorityQueue<Integer> order = new PriorityQueue<>((a,b)->nums[b]-nums[a]);

        for(int i=0;i<nums.length;i++) {
            order.offer(i);
        }

        System.out.println(order);

        return -1;
    }
}
