class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.longestValidParentheses("(()"));
        System.out.println(s.longestValidParentheses(")()())(()"));
        System.out.println(s.longestValidParentheses(""));
    }
    public int longestValidParentheses(String s) {
        return helper(s.toCharArray(),0,0);
    }

    public int helper(char[] s, int l, int i) {

    }
}
