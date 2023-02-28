import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isAlienSorted(new String[]{"hello","leetcode"},"hlabcdefgijkmnopqrstuvwxyz"));
        System.out.println(s.isAlienSorted(new String[]{"word","world","row"},"worldabcefghijkmnpqstuvxyz"));
        System.out.println(s.isAlienSorted(new String[]{"apple","app"},"abcdefghijklmnopqrstuvwxyz"));
    }
    public boolean isAlienSorted(String[] words, String order) {

        //rank characters by order
        // index : char
        // value : rank

        int[] rank = new int[order.length()];
        for(int i=0;i<order.length();i++) {
            rank[order.charAt(i)-'a']  = i;
        }

        System.out.println(Arrays.toString(rank));

        //compare word i with word i-1
        for(int i=1;i<words.length;i++) {
            for(int j=0;j<Math.min(words[i].length(),words[i-1].length());j++) {
                if(rank[words[i].charAt(j)-'a'] < rank[words[i-1].charAt(j)-'a']) return false;
            }
            if(words[i].length() < words[i-1].length()) return false;
        }

        return true;

    }
}
