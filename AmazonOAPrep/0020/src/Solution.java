import java.util.ArrayDeque;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
//        System.out.println(s.isValid("()()()"));
//        System.out.println(s.isValid("()))"));
//        System.out.println(s.isValid("(((((((((()))"));
//        System.out.println(s.isValid("(()())()()"));
//        System.out.println(s.isValid("{[()]]"));
//        System.out.println(s.isValid("{[()]}"));
//        System.out.println(s.isValid("{[(]}"));
        System.out.println(s.isValid("(])"));
    }
    public boolean isValid(String s) {
        ArrayDeque<Character> st = new ArrayDeque<>();

        for(char c : s.toCharArray()) {
            if(isOpen(c)) st.push(c);
            else if(st.isEmpty()) return false;
            else if(isMatch(st.peek(),c)) st.pop();
        }

        return st.isEmpty();
    }

    private boolean isOpen(char c) {
        return c=='(' || c=='[' || c=='{';
    }
    private boolean isClose(char c) {
        return c==')' || c==']' || c=='}';
    }
    private boolean isMatch(char a,char b) {
        return  ( a=='(' && b==')' ) ||
                ( a=='[' && b==']' ) ||
                ( a=='{' && b=='}' );
    }
}
