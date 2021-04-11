import java.util.HashMap;
import java.util.Map;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.isAlienSorted(new String[] {"hello","leetcode"},"hlabcdefgijkmnopqrstuvwxyz"));
        System.out.println(s.isAlienSorted(new String[] {"word","world"},"worldabcefghijkmnpqstuvxyz"));
        System.out.println(s.isAlienSorted(new String[] {"apple","app"},"abcdefghijklmnopqrstuvwxyz"));
    }
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character,Integer> orderMap  = new HashMap<>();
        for(int k=0;k<order.length();k++) {
            orderMap.put(order.charAt(k),k);
        }
//        System.out.println(orderMap.get('d'));

//        System.out.println(orderMap.get('l'));
        for(int i=0;i<words.length-1;i++) {
            //compare i with i+1
            //if i>i+1 return false;
            int cache = compare(words[i],words[i+1],orderMap);
//            System.out.println(cache);
            if(cache>0) return false;
        }
        return true;
    }

    public int compare(String word1, String word2, Map<Character,Integer> order) {
//        System.out.println("Comparing..."+word1+" "+word2);
        int minLength = Math.min(word1.length(),word2.length());

        for(int i=0;i<minLength;i++) {
//            System.out.println("Comp char "+word1.charAt(i)+" "+order.get(word1.charAt(i))+" "+word2.charAt(i)+" "+order.get(word2.charAt(i)));
            if(order.get(word1.charAt(i)) < order.get(word2.charAt(i))) return -1;
            else if(order.get(word1.charAt(i))  > order.get(word2.charAt(i))) return 1;
        }
        if(word1.length()==word2.length()) return 0;
        else if(word1.length()<word2.length()) return -1;
        else return 1;
    }
}
