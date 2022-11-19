import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.removeDuplicates("abbaca"));
        System.out.println(s.removeDuplicates("azxxzy"));
        System.out.println(s.removeDuplicates("aaaaaaaa"));
        System.out.println(s.removeDuplicates("aababaab"));
    }
    public String removeDuplicates(String s) {
        Deque<Character> st = new ArrayDeque<>();

        int n = s.length();
        for(int i=0;i<n;i++) {
            while(!st.isEmpty() && i<n && s.charAt(i)==st.peek()) {
                st.pop();
                i++;
            }
            if(i<n) st.push(s.charAt(i));
        }

        StringBuilder sb = new StringBuilder();

        while(!st.isEmpty()) sb.append(st.pollLast());

        return sb.toString();

    }
}
