/**
 * Created by Glamdring on 3/7/2017.
 */
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        String a = "hello   world ";
        String b = "  goodbye ";
        System.out.println("Length last word of \"" + a + "\" is " + s.lengthOfLastWord(a));
        System.out.println("Length last word of \"" + b + "\" is " + s.lengthOfLastWord(b));
        System.out.println("Length last word of \"" + " " + "\" is " + s.lengthOfLastWord(" "));
        System.out.println("Length last word of \"" + "" + "\" is " + s.lengthOfLastWord(""));
        System.out.println("Length last word of \"" + "  " + "\" is " + s.lengthOfLastWord("  "));
        System.out.println("Length last word of \"" + "a " + "\" is " + s.lengthOfLastWord("a "));
        System.out.println("Length last word of \"" + "  a" + "\" is " + s.lengthOfLastWord("  a"));
        System.out.println("Length last word of \"" + "a b " + "\" is " + s.lengthOfLastWord("a b "));
        System.out.println("Length last word of \"" + " a b " + "\" is " + s.lengthOfLastWord(" a b "));
        System.out.println("Length last word of \"" + "  ab " + "\" is " + s.lengthOfLastWord("  ab "));
    }
    /* String s consists of only:
     *      upper case letters
     *      lower case letters
     *      whitespace
     *      */

    public int lengthOfLastWord(String s) {
        char[] c = s.toCharArray();
        int i,p=0;
        while(p<c.length && c[s.length()-1-p]==' ') p++; //absorbed trailing whitespace
        for(i=p;i < s.length();i++) {
            if(c[s.length()-1-i]==' ') return i-p; //detect whitespace preceding the last word
        }
        return i-p; //happens when no whitespace preceding the last word, ie: "hello     "
    }
}
