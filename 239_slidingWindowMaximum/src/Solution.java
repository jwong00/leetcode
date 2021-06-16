import java.util.*;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.maxSlidingWindow(new int[] {1,3,-1,-3,5,3,6,7},3)));
        System.out.println(Arrays.toString(s.maxSlidingWindow(new int[] {-7,-8,7,5,7,1,6,0},4)));
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> windowValues = new PriorityQueue<>(Collections.reverseOrder());
        HashMap<Integer,Integer> windowKeys = new HashMap<>();

        int[] maxima = new int[nums.length-k+1];

        //init first window
        for(int i=0;i<k;i++) {
            windowValues.add(nums[i]);
            windowKeys.put(i,nums[i]);
        }

        maxima[0] = windowValues.peek();

        for(int i=k;i<nums.length;i++) {

            //remove left elem from window
            windowValues.remove(windowKeys.get(i-k));
            windowKeys.remove(i-k);

            //add new right elem to window
            windowValues.add(nums[i]);
            windowKeys.put(i,nums[i]);

            //store maximum of current window
            maxima[i-k+1] = windowValues.peek();
        }

        return maxima;
    }
}
