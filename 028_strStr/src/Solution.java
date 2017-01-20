/**
 * Created by Glamdring on 1/20/2017.
 */
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.strStr("abcdefg", "ef"));
        System.out.println(s.strStr("bbkrrjlik", "jli"));
        System.out.println(s.strStr("krjrjrrjlik", "rjl"));
        System.out.println(s.strStr("abcd", "abcd"));
        System.out.println(s.strStr("x", "x"));
    }
    public int strStr(String haystack, String needle) {
        if(needle.length()>haystack.length()) return -1;
        if(needle.length()==0 && haystack.length()==0) return 0;
        int i;
        int j;
        int k=0;
        for(i=0;i<=haystack.length()-needle.length();i++) { //iterate through
            //try to match first char of needle with a char in haystack,
            // then try to match subsequent characters
            j=i;
            while(k<needle.length() && needle.charAt(k)==haystack.charAt(j)) {
                k++; j++;
            }
            if(k==needle.length()) return i;
            k=0;
        }
        return -1;
    }
}
