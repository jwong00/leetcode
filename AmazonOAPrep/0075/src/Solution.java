import java.util.HashMap;

/*
* LC 459 :: Repeated Substring Pattern
* */
 class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.repeatedSubstringPattern("patternpattern"));
        System.out.println(s.repeatedSubstringPattern("pattern1pattern2"));
        System.out.println(s.repeatedSubstringPattern("abcabcabc"));
        System.out.println(s.repeatedSubstringPattern("bcabcabc"));
    }



    public boolean repeatedSubstringPattern(String s) {
        return (s+s).substring(1,s.length()*2-1).contains(s);
    }
}
