import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.maxOperations(new int[]{1,2,3,4},5));
        System.out.println(s.maxOperations(new int[]{3,1,3,4,3},6));
    }
    public int maxOperations(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer,Integer> freq = new HashMap<>();
        Deque<Integer> st = new ArrayDeque<>(k/2);

        for(int i=0;i<n;i++) {
            if(!freq.containsKey(nums[i]) && nums[i] < (double) k / 2) st.offer(nums[i]);
            freq.put(nums[i],freq.getOrDefault(nums[i],0)+1);
        }

        //iterate over the frequencies of all nums t s.t. t < k/2
        //use the hash to determine the lesser count of frequencies of
        //the smaller number t and its complement k-t
        int ops = 0;
        while(!st.isEmpty()) {
            int t = st.poll();
            ops += Math.min(freq.get(t),freq.getOrDefault(k-t,0));
        }

        //the special case of t==k/2 is the only one where t
        //is its own complement, i.e.
        //t==k-t
        if(k%2==0) ops += freq.getOrDefault(k/2,0)/2;

        return ops;
    }
}
