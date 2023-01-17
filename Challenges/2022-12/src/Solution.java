import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.halvesAreAlike("book"));
        System.out.println(s.halvesAreAlike("textbook"));
        System.out.println(s.halvesAreAlike("AbCdEfGh"));
    }

    HashSet<Character> vowels;

    public Solution() {
        vowels = new HashSet<>();
        Collections.addAll(vowels,'a','e','i','o','u','A','E','I','O','U');
    }

    public boolean halvesAreAlike(String s) {
        int l=0,r=s.length()-1;
        int vowels_l=0,vowels_r=0;
        while(l<r) {
            if(vowels.contains(s.charAt(l++))) vowels_l++;
            if(vowels.contains(s.charAt(r--))) vowels_r++;
        }
        return vowels_l==vowels_r;
    }

}
