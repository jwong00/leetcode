import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.wordPattern("abba","dog dog dog dog"));
        System.out.println(s.wordPattern("abba","dog cat cat dog"));
        System.out.println(s.wordPattern("abba","dog cat cat fish"));
        System.out.println(s.wordPattern("aaa","dog dog dog dog"));
        System.out.println(s.wordPattern("aaaa","dog dog dog"));
    }
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split("\\s");
        if(words.length!=pattern.length()) return false;
        HashMap<Character,String> ch_to_str = new HashMap<>();
        HashMap<String,Character> str_to_ch = new HashMap<>();
        for(int i=0;i<words.length;i++) {

            char cur_ch = pattern.charAt(i);
            String cur_str = words[i];
            //check to see if there's a mapping
            //if so, compare to current "mapping"

            if(ch_to_str.containsKey(cur_ch) && !ch_to_str.get(cur_ch).equals(cur_str)) return false;
            if(str_to_ch.containsKey(cur_str) && !str_to_ch.get(cur_str).equals(cur_ch)) return false;

            ch_to_str.put(cur_ch,cur_str);
            str_to_ch.put(cur_str,cur_ch);
        }
        return true;
    }
}
