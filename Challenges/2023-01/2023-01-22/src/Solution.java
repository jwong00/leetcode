import java.util.List;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isPalindrome("abaa",0,3));
    }

    public List<List<String>> partition(String s) {


        return null;
    }

    public void p_helper(String s, int start, List<String> cache) {
        //iterate over all substrings starting at ind i

        //IS THIS OUTER LOOP NECESSARY?
        for(;start<s.length();start++) {
            for(int end=start;end<s.length();end++) {
                if(isPalindrome(s,start,end)) {
                    cache.add(s.substring(start,end+1));
                    p_helper(s,start+1, cache);
                }
            }
        }
    }

    //check if substring defined by the interval (a,b) is a palindrome
    public boolean isPalindrome(String s, int a, int b) {
        while(a<b) {
            if(s.charAt(a)!=s.charAt(b)) return false;
            a++;
            b--;
        }

        return true;
    }
}
