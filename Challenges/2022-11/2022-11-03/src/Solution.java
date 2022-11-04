import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
//        System.out.println(s.longestPalindrome(new String[]{"lc","cl","gg"}));
//        System.out.println(s.longestPalindrome(new String[]{"ab","ty","yt","lc","cl","ab"}));
//        System.out.println(s.longestPalindrome(new String[]{"cc","ll","xx"}));
        System.out.println(s.longestPalindrome(new String[]{"qo","fo","fq","qf","fo","ff","qq","qf","of","of","oo","of","of","qf","qf","of"}));

    }
    public int longestPalindrome(String[] words) {
        HashMap<String,Integer> word_freq = new HashMap<>();
        int length = 0;
        for(String word : words) {
            String reverse = reverse(word);
            if(word_freq.containsKey(reverse) && word_freq.get(reverse)>0) {
                word_freq.put(reverse,word_freq.get(reverse)-1);
                length+=4;
            }
            else {
                word_freq.put(word,word_freq.getOrDefault(word,0)+1);
            }
        }

        for(String word : word_freq.keySet()) {
            if(word_freq.get(word) > 0 && word.equals(reverse(word))) {
                length+=2;
                break;
            }
        }
        return length;
    }

    public String reverse(String s) {
        return ""+s.charAt(1)+s.charAt(0);
    }
}
