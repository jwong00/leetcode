class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.isAnagram("ab", "a"));
        System.out.println(s.isAnagram("yes", "yse"));
        System.out.println(s.isAnagram("wer","laikdfujhgalifudbhak"));

        System.out.println(s.isAnagram("zz","z"));

        System.out.println(s.isAnagram("z","zz"));
        System.out.println(s.isAnagram("z","z"));

    }
    public boolean isAnagram(String s, String t) {
        if(s==null ^ t==null) return false;
        if(s==null && t==null) return true;
        if(s.length() != t.length()) return false;

        int[] index_s = new int['z'+1];
        int[] index_t = new int['z'+1];

        int q = s.length();
        for(int i=0; i<q; i++) {
            index_s[s.charAt(i)]++;
        }

        q = t.length();
        for(int i=0; i<q; i++) {
            index_t[t.charAt(i)]++;
        }

        for(int i='a'; i<='z'; i++) {
            if(index_s[i] != index_t[i]) return false;
        }

        return true;

    }
}
