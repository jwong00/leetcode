import java.util.*;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.findAnagrams("cbaebabacd","abc"));
        System.out.println(s.findAnagrams("abab","ab"));
    }
    public List<Integer> findAnagrams(String s, String p) {

        //hash p
        HashMap<Character,Integer> hash_p = new HashMap<>();

        for(char c : p.toCharArray()) {
            hash_p.put(c,hash_p.getOrDefault(c,0)+1);
        }

        //sliding window to check each subsequence of s whose length == p.length

        HashMap<Character,Integer> hash_s = new HashMap<>();
        int k = p.length();
        List<Integer> ans = new ArrayList<>();

        for(int i=0;i<s.length();i++) {
            hash_s.put(s.charAt(i),hash_s.getOrDefault(s.charAt(i),0)+1);
            if(i> k-1) {
                hash_s.put(s.charAt(i-k),hash_s.get(s.charAt(i-k))-1);
            }

            //since the sz of window == p.length at all times,
            //we can check for anagram by checking for each char in hash_p
            //against the current window

            boolean flag = true;

            for(Map.Entry<Character,Integer> e : hash_p.entrySet()) {
                if(!Objects.equals(e.getValue(), hash_s.get(e.getKey()))) {
                    flag = false;
                    break;
                }
            }

            if(flag) ans.add(i-k+1);
        }

        return ans;

    }
}
