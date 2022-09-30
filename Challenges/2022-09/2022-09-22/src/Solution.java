import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.reverseWords("This is an example sentence"));
    }
    public String reverseWords(String s) {
        String[] words = s.split("\\s+");

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<words.length;i++) {
            char[] word = words[i].toCharArray();
            for(int j=word.length-1;j>=0;j--) {
                sb.append(word[j]);
            }
            if(i<words.length-1) sb.append(' ');
        }

        return "\""+sb.toString()+"\"";
    }
}
