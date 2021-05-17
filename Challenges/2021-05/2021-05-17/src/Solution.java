import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.longestStrChain(new String[]  {"abc","abcd","ab","b","a"}));
        System.out.println(s.longestStrChain(new String[]  {"a","b","ba","bca","bda","bdca"}));
        System.out.println(s.longestStrChain(new String[]  {"xbc","pcxbcf","xb","cxbc","pcxbc"}));

    }
    public int longestStrChain(String[] words) {
        Arrays.sort(words, Comparator.comparing(String::length));
        HashMap<String,Integer> chain = new HashMap<>();

        int maxLength = 1;

        for(int i=0; i<words.length; i++) {
            String t = words[i];
            StringBuilder sb;

            if(t.length()==1) chain.put(t,1);
            else  {
                int c = 1;
                for(int j=0;j<t.length();j++) {
                    sb = new StringBuilder(t);
                    String p = sb.deleteCharAt(j).toString();

                    if(chain.containsKey(p)) c = Math.max(chain.get(p)+1,c);
                }

                chain.put(t,c);

                maxLength = Math.max(maxLength,c);
                System.out.println();
            }
        }
        return maxLength;
    }
}
