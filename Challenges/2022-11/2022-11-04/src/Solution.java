import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.reverseVowels(".,"));
        System.out.println(s.reverseVowels("hello"));
        System.out.println(s.reverseVowels("leetcode"));
    }
    public String reverseVowels(String s) {
        if(s==null || s.length()<=1) return s;

        int l = 0, r = s.length()-1;

        char[] w = s.toCharArray();
        while(l<r) {
            while(l<s.length() && !isVowel(w[l])) l++;
            while(r>=0 && !isVowel(w[r])) r--;

            if(l>=r) break;

            //swap
            char c = w[l];
            w[l] = w[r];
            w[r] = c;

            //
            l++;
            r--;

        }

        return String.valueOf(w);
    }

    public boolean isVowel(char c) {
        return  c=='a' || c=='e' || c=='i' || c=='o' || c=='u' ||
                c=='A' || c=='E' || c=='I' || c=='O' || c=='U';
    }
}
