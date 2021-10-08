import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7},3)));
        System.out.println(Arrays.toString(s.maxSlidingWindow(new int[]{1},1)));
        System.out.println(Arrays.toString(s.maxSlidingWindow(new int[]{1,-1},1)));
        System.out.println(Arrays.toString(s.maxSlidingWindow(new int[]{9,11},2)));
        System.out.println(Arrays.toString(s.maxSlidingWindow(new int[]{4,-2},2)));
        System.out.println(Arrays.toString(s.maxSlidingWindow(new int[]{7,2,4},2)));
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums==null || nums.length<k) return new int[]{};

        int[] max = new int[nums.length-k+1];

        Deque<Integer> window = new ArrayDeque<>();

        for(int i=0;i<k;i++) {
            if(window.isEmpty()) window.offer(nums[i]);
            else window.offer(Math.max(window.peekLast(),nums[i]));
        }
        max[0] = window.peekLast();
//        System.out.println(window);

//        System.out.println("HERE");
        for(int i=k;i<nums.length;i++) {
            while(!window.isEmpty() && window.peekFirst()>nums[i]) window.pollFirst();
//            System.out.println(window);
            if(window.isEmpty()) window.offer(nums[i]);
            else while(window.size()<k) window.offer(Math.max(window.peekLast(),nums[i]));
//            System.out.println(window);
            max[i-k+1] = window.peekLast();

        }
        return max;
    }
}
