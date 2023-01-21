import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.PriorityQueue;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
//        System.out.println(s.closeStrings("abc","bca"));
        System.out.println(s.closeStrings("uau","ssx"));
//        System.out.println(s.closeStrings("a","aa"));
//        System.out.println(s.closeStrings("cabbba","abbccc"));
    }
    public boolean closeStrings(String word1, String word2) {
        if(word1.length()!=word2.length()) return false;
        int n = word1.length();

        HashMap<Character,Integer> word1_f = new HashMap<>(), word2_f = new HashMap<>();

        for(int i=0;i<n;i++) {
            char c1 = word1.charAt(i);
            char c2 = word2.charAt(i);
            word1_f.put(c1,word1_f.getOrDefault(c1,0)+1);
            word2_f.put(c2,word2_f.getOrDefault(c2,0)+1);
        }

        PriorityQueue<Integer> freq_1 = new PriorityQueue<>();
        for(int f :  word1_f.values()) freq_1.offer(f);

        PriorityQueue<Integer> freq_2 = new PriorityQueue<>();
        for(int f :  word2_f.values()) freq_2.offer(f);

        if(freq_1.size()!=freq_2.size()) return false;

        while(!freq_1.isEmpty() && !freq_2.isEmpty()) {
            if(freq_1.poll()!=freq_2.poll()) return false;
        }

        return true;
    }
}
