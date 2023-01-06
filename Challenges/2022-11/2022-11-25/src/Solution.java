import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.sumSubarrayMins(new int[]{3,1,2,4}));
        System.out.println(s.sumSubarrayMins(new int[]{11,81,94,43,3}));
    }
    public int sumSubarrayMins(int[] arr) {
        return sumSubarrayMinsStack(arr);
    }


    //implementation using monotonic stacks
    private int sumSubarrayMinsStack(int[] arr) {
        Deque<int[]> st;
        int min = 0;
        //iterate over every contiguous subarray
        for(int i=0;i<arr.length;i++) {
            st = new ArrayDeque<>();
            for(int j=i;j<arr.length;j++) {
                int new_min = st.isEmpty() ? arr[j] : Math.min(arr[j],st.peek()[1]);
                st.push(new int[]{arr[j],new_min});
                min+=(new_min%100_000_007);
            }
        }

        return min;
    }

}
