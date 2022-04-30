import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.removeKdigits("1432219",3));
        System.out.println(s.removeKdigits("10200",1));
        System.out.println(s.removeKdigits("10",2));
    }
    public String removeKdigits(String num, int k) {

        Deque<Character> st = new ArrayDeque<>();

        for(char digit : num.toCharArray()) {
            while(!st.isEmpty() && k > 0 && st.peekLast() > digit ) {
                st.removeLast();
                k--;
            }
            st.addLast(digit);
        }

        while(k>0) {
            st.removeLast();
            k--;
        }

        while(!st.isEmpty() && st.peekFirst()=='0') {
            st.pop();
        }

        if(st.size()==0) return "0";

        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()) {
            sb.append(st.removeFirst());
        }

        return sb.toString();

    }
}
