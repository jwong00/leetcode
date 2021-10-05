class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isIsomorphic("ah","zz"));
    }
    public boolean isIsomorphic(String s, String t) {
        if(s==null && t==null) return true;
        if(s==null ^ t==null) return false;
        if(s.length() != t.length()) return false;

        char[] s_map = new char[128];
        char[] t_map = new char[128];

        int curChar_s;
        int curChar_t;
        for(int i=0; i<s.length(); i++) {
            curChar_s = s.charAt(i);
            curChar_t = t.charAt(i);

            if(s_map[curChar_s]=='\0') s_map[curChar_s] = t.charAt(i);
            if(t_map[curChar_t]=='\0') t_map[curChar_t] = s.charAt(i);
            if( s_map[curChar_s] != t.charAt(i) ||
                t_map[curChar_t] != s.charAt(i)) return false;
        }

        return true;
    }

}
