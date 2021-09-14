import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.reverseOnlyLetters("ab-cd"));
        System.out.println(s.reverseOnlyLetters("a-bC-dEf-ghIj"));
        System.out.println(s.reverseOnlyLetters("Test1ng-Leet=code-Q!"));
    }
    public String reverseOnlyLetters(String s) {
        if(s==null || s.length()==0) return s;

        int m=0,n=s.length()-1;

        char[] ans = new char[s.length()];

        while(m<=n) {
            if( Character.isAlphabetic(s.charAt(m)) &&
                Character.isAlphabetic(s.charAt(n))     ) {
                ans[m]=s.charAt(n);
                ans[n]=s.charAt(m);
                m++;
                n--;
            }
            else if(!Character.isAlphabetic(s.charAt(m))) {
                System.out.println(s.charAt(m));
                ans[m]=s.charAt(m);
                m++;
            }
            else if(!Character.isAlphabetic(s.charAt(n))) {
                System.out.println(s.charAt(n));
                ans[n]=s.charAt(n);
                n--;
            }

        }

        return new String(ans);
    }
}
