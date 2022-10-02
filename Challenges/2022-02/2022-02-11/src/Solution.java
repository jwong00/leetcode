import java.util.HashMap;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.checkInclusion("ab","eidbaooo"));
        System.out.println(s.checkInclusion("ab","eidboaoo"));
    }

    //return TRUE iff s1 in s2
    //return FALSE if s1 not in s2

    public boolean checkInclusion(String s1, String s2) {

        //validation
        if(s1.length() > s2.length()) return false;

        //hash
//        HashMap<Character,Integer> s1_hash = new HashMap<>();
//        HashMap<Character,Integer> s2_hash = new HashMap<>();
        int[] s1_hash = new int[26];
        int[] s2_hash = new int[26];

        for(int i=0; i<s1.length();i++) {
//            s1_hash.put(s1.charAt(i),s1_hash.getOrDefault(s1.charAt(i),0)+1);
//            s2_hash.put(s2.charAt(i),s2_hash.getOrDefault(s2.charAt(i),0)+1);
            s1_hash[s1.charAt(i)-'a']++;
            s2_hash[s2.charAt(i)-'a']++;

        }

        for(int i=s1.length();i<s2.length();i++) {
            if(match(s1_hash,s2_hash)) return true;
            s2_hash[s2.charAt(i-s1.length())-'a']--;
            s2_hash[s2.charAt(i)-'a']++;
        }

        return match(s1_hash,s2_hash);


    }

    public boolean match(int[] h1, int[] h2) {
        for(int i=0;i<26;i++) {
            if(h1[i]!=h2[i]) return false;
        }
        return true;
    }
}
