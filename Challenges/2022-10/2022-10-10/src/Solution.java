import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.breakPalindrome("abccba"));
        System.out.println(s.breakPalindrome("a"));
        System.out.println(s.breakPalindrome("aaaaa"));
        System.out.println(s.breakPalindrome("aba"));
    }
    public String breakPalindrome(String palindrome) {
        if(palindrome.length()<=1) return "";

        //replace leftmost non-'a' char with 'a'
        char[] p_char = palindrome.toCharArray();

        for(int i=0;i<p_char.length/2;i++) {
            if(p_char[i]!='a') {
                p_char[i]='a';
                return String.valueOf(p_char);
            }
        }

        p_char[p_char.length-1] = 'b';

//        for(int i=0;i<p_char.length;i++) {
//            if(p_char[i]!='a') {
//                p_char[i]='a';
//                break;
//            }
//            else if(i==p_char.length-1 && p_char[i]=='a') {
//                p_char[i]='b';
//            }
//        }

        return String.valueOf(p_char);
    }
}
