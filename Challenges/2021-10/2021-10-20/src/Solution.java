import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.reverseWords("the sky is blue "));
        System.out.println(s.reverseWords("   hello    world  "));

    }
    public String reverseWords(String s) {
        StringBuilder cache = new StringBuilder();
        Deque<String> words = new ArrayDeque<>();

        int l=0, r=s.length()-1;

        while(s.charAt(l)==' ') l++;
        while(s.charAt(r)==' ') r--;

        while(l<=r) {
           char c = s.charAt(l);

           if(cache.length()!=0 && c==' ')  {
               words.push(cache.toString());
               cache.setLength(0);
           }
           else if(c!=' ') cache.append(c);

           l++;
        }
        words.push(cache.toString());

        return String.join(" ",words);
    }
}
