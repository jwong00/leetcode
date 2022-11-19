import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
    }
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        Deque<int[]> st = new ArrayDeque<>();

        int[] ans = new int[temperatures.length];

        for(int i=0;i<n;i++) {
            while(!st.isEmpty() && temperatures[i] > st.peek()[0]) {
                int[] cache = st.pop();
                ans[cache[1]] = i - cache[1];
            }
            st.push(new int[]{temperatures[i],i});
        }
        return ans;
    }
}
