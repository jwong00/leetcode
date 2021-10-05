import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by Glamdring on 1/5/2017.
 */
public class Solution {
    //hashset to see if a char has been seen before
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(s.lengthOfLongestSubstring("kdablmajkr"));
        System.out.println(s.lengthOfLongestSubstring("aab"));
        System.out.println(s.lengthOfLongestSubstring("c"));
        System.out.println(s.lengthOfLongestSubstring("abd"));
        System.out.println(s.lengthOfLongestSubstring("ggububgvfk"));

    }

    //begin search from arbitrary char c, until a dupe is found
    //start new search from just after first instance of dupe.
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> charSet = new HashMap<>();
        int longestSubStrLength=0;
        int curSubStrLength=0;
        Integer k;
        for(int i=0;i<s.length();i++) {
            k = charSet.get(s.charAt(i));
            if(k==null) {
                charSet.put(s.charAt(i),i); //character is new; add to hash
                curSubStrLength++;

//                System.out.println("Adding " + s.charAt(i) + " "+i+" "+curSubStrLength);

            }
            else { //character has been seen before. go back?
//                System.out.println(s.charAt(i) + " is a dupe at " + i);
//                System.out.println("Resetting");
                i=k;
//                System.out.println(i);
                charSet = new HashMap<>();
                if(curSubStrLength >= longestSubStrLength) {
                    longestSubStrLength = curSubStrLength;
                }

                curSubStrLength = 0;
            }
        }
        if(curSubStrLength >= longestSubStrLength) longestSubStrLength = curSubStrLength;

        return longestSubStrLength;
    }
}
