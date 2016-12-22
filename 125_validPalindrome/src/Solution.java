/**
 * Created by Glamdring on 11/10/2016.
 */
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.isPalindrome("asodfi");
        s.isPalindrome("aassaa");
        s.isPalindrome("asa");
        s.isPalindrome("race car");
        s.isPalindrome("r,ac,e  ,car,");
        s.isPalindrome(",.,.,/,");
        s.isPalindrome("aA");
        s.isPalindrome("0P");
        s.isPalindrome("0P0");
        //System.out.println(3/2);

    }
    public static final boolean DEBUG = false;
    public boolean isPalindrome(String s) {
        if(s.length()>0) {
            String newString="";
            if(DEBUG) System.out.println(s);
            for(Character c : s.toCharArray()) {
                if(Character.isAlphabetic(c) || Character.isDigit(c)) {
                    newString+=c;
                }
            }
            if(newString.length()==0) {
                System.out.println("Empty string is a palindrome.");
                return true;
            }
            if(DEBUG) System.out.println(newString.length());
            int i=0;
            int j=newString.length()-1;
            while(i<=newString.length()/2) {
                //if(DEBUG) System.out.println(i+" "+newString.charAt(i));
                //if(DEBUG) System.out.println(j+" "+newString.charAt(j));
                if(Character.toLowerCase(newString.charAt(i)) != Character.toLowerCase(newString.charAt(j))) {
                    System.out.println(s + " is not a palindrome.");
                    return false;
                }
                i++;
                j--;
            }
        }
        if(s.length()==0) System.out.println("An empty string is a palindrome.");
        else System.out.println(s + " is a palindrome.");
        return true;
    }
}
