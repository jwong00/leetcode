import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.",new String[]{"hit"}));
        System.out.println(s.mostCommonWord("a",new String[]{}));
    }
    public String mostCommonWord(String paragraph, String[] banned) {

        HashSet<String> banned_set = new HashSet<>(Arrays.asList(banned));

        HashMap<String,Integer> freq = new HashMap<>();

        String[] words = paragraph.split("\\W+");
        for(String word : words) {
            String wordLower = word.toLowerCase();
            if(!banned_set.contains(wordLower))
                freq.put(wordLower,freq.getOrDefault(wordLower,0)+1);
        }

        int length = -1;
        String mcw = "";
        for(String key : freq.keySet()) {
            if(freq.get(key)>length) {
                length = freq.get(key);
                mcw=key;
            }
        }

        return mcw;
    }
}
