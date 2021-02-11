import java.util.HashMap;
import java.util.Hashtable;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();

        s.isAnagram("this","that");
        s.isAnagram("anagram","nagaram");
        s.isAnagram("aacc","ccac");
    }
    public boolean isAnagram(String s, String t) {
        if(s.length()==0 && t.length()==0) return true;
        if(s.length()!=t.length()) return false;

        Hashtable<Character,Integer> s_hash = new Hashtable<>();
        Hashtable<Character,Integer> t_hash = new Hashtable<>();

        for(char c : s.toCharArray()) {
            if(!s_hash.containsKey(c)) {
                s_hash.put(c,1);
            }
            else s_hash.put(c,s_hash.get(c)+1);
        }

        for(char c : t.toCharArray()) {
            if(!t_hash.containsKey(c)) {
                t_hash.put(c,1);
            }
            else t_hash.put(c,t_hash.get(c)+1);
        }

//        System.out.println(s_hash.toString());
//        System.out.println(t_hash.toString());
//        System.out.println(s_hash.equals(t_hash));
        return s_hash.equals(t_hash);

    }
}