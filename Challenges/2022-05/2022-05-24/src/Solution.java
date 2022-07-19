import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.longestValidParentheses("(()"));
        System.out.println(s.longestValidParentheses(")()())"));
        System.out.println(s.longestValidParentheses(""));
        System.out.println(s.longestValidParentheses("()(()"));
    }
    public int longestValidParentheses(String s) {

        Deque<Integer> st = new ArrayDeque<>();

        int count = 0;
        st.push(-1);

        for(int i=0;i<s.length();i++) {
            if(s.charAt(i)=='(') st.push(i);
            else {
                st.pop();
                if(st.isEmpty()) st.push(i);
                else count = Math.max(count,i-st.peek());
            }

        }

        return count;
    }
}
