import java.util.HashMap;

public class Solution {

    /* Input: S = "ADOBECODEBANC", T = "ABC"
    Output: "BANC" */

    public String minWindow(String s, String t) {
        HashMap<Character,Integer> windowContents = new HashMap<>(t.length());
        for(Character c : t.toCharArray()) {
            windowContents.put(c,0);
        }
        for(int i=0,j=t.length()-1;j<s.length()-1;) {

        }
        return "RETURN";
    }
}
