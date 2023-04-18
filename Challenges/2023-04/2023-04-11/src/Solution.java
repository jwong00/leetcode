import java.util.ArrayDeque;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.removeStars("leet**cod*e"));
        System.out.println(s.removeStars("erase*****"));

    }
    public String removeStars(String s) {
        ArrayDeque<Character> st = new ArrayDeque<>();
        for(char c : s.toCharArray()) {
            if(c!='*') st.push(c);
            else if(st.size()>0) st.pop();
        }

        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()) {
            sb.append(st.pollLast());
        }

        return sb.toString();

    }
}
