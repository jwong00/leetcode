import java.util.Arrays;
import java.util.Collections;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.reverseWords("  the    sky is so so blue  "));

    }
    public String reverseWords(String s) {
        s = s.trim();
        String[] words = s.split("\\s+");
        System.out.println(Arrays.toString(words));

        StringBuilder sb = new StringBuilder();

        for(int i=words.length-1;i>=0;i--) {
            sb.append(words[i]);
            if(i>0) sb.append(" ");
        }

        return sb.toString();
    }
}
