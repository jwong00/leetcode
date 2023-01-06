import java.util.PriorityQueue;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.findKthLargest(new int[]{3,2,1,5,6,4},2));
    }
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>();

        for(int i=0;i<nums.length;i++) {
            q.offer(nums[i]);
            if(q.size()>k) q.poll();
        }

        return q.poll();
    }
}
