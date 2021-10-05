import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        String k = "FGHIJKLMG";
        System.out.println(s.lengthOfLongestSubstring(k));
        String a = "ABCABCBB";
        System.out.println(s.lengthOfLongestSubstring(a));
        String b = "BBBBBB";
        System.out.println(s.lengthOfLongestSubstring(b));
        String c = "PWWKEW";
        System.out.println(s.lengthOfLongestSubstring(c));
        String d = "AU";
        System.out.println(s.lengthOfLongestSubstring(d));
    }


    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if(n <=1) return n;

        HashSet<Character> c = new HashSet<>();

        int right=0;
        int left=0;
        int best = 0;

        while(right< n && left< n) {

            if(c.add(s.charAt(right))) {
                right++;
                best = Math.max( best,right-left );
            }
            else c.remove(s.charAt(left++));
        }

        return best;
    }

    public int lengthOfLongestSubstringOld(String s) {
        if(s.length()<=1) return s.length();

        HashSet<Character> c = new HashSet<>();

        int right=0;
        int left=0;
        int best = 0;

        /**
        * Slide right bound until window contains a repeated character
        * Store length if better
        * Slide left bound until it reaches the repeat character, then slide again
        * */
        while(right<s.length()) {

            /**
             * example string
             * A...FGH...MG
             * 01234
             */
            if(!c.add(s.charAt(right))) { //evaluates to TRUE if attempted to add duplicate
                best = Math.max( best,right-left );
                while(s.charAt(left) != s.charAt(right)) {
                    c.remove(s.charAt(left));
                    left++;
                }
                left++;
                /**
                 * one more time to skip over the character at LEFT, so that the character at LEFT
                 * will not equal the character at RIGHT
                */
            }
                best=Math.max(best,right-left+1);
            right++;
        }

        return best;
    }
}
