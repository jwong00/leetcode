import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.dailyTemperatures(new int[]{73,74,75,71,69,72,76,73})));
        System.out.println(Arrays.toString(s.dailyTemperatures(new int[]{30,40,50,60})));

    }
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<int[]> st = new ArrayDeque<>();

        int[] answer = new int[temperatures.length];

        for(int i=0;i<temperatures.length;i++) {
            while(!st.isEmpty() && st.peek()[0]<=temperatures[i]) {
                int[] t = st.pop();

                answer[t[1]] = i-t[1];
            }
            st.push(new int[]{temperatures[i],i});
        }

        return answer;

    }
}
