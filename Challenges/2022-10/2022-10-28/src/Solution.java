import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}));
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<Long,List<String>> map = new HashMap<>();
        for(String s : strs) {
            long hash_s = str_hash(s);
            map.putIfAbsent(hash_s,new ArrayList<>());
            List<String> bucket = map.get(hash_s);
            bucket.add(s);
        }
        return new ArrayList<>(map.values());
    }

    long str_hash(String s) {
        final int p = 53;
        final int m = 10^9+9;
        long hash = 0;
        long p_pow = 1;
        for(char c : s.toCharArray()) {
            hash = (hash + (c - 'a' + 1) * p_pow) % m ;
//            p_pow = (p_pow*p) % m;
        }
        return hash;
    }
}
