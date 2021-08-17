class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.numMatchingSubseq("abcde",new String[]{"a","bb","acd","ace"}));


    }
    public int numMatchingSubseq(String s, String[] words) {
        int count = 0;
        int[] s_freq = new int['z'-'a']; //only lowercase letters, per problem statement


        for(String word : words) {
            if(isSubseq(s,word,s_freq)) count++;
        }

        return count;
    }

    public boolean isSubseq(String s,String w, int[] s_freq) {
        if(w.length()>s.length()) return false;

        int[] w_freq = new int['z'-'a'];

        for(int i=0;i<w.length();i++) {
            if(++w_freq[w.charAt(i)] > s_freq[w.charAt(i)]) return false;
        }



        /*
        int s_ptr = 0,w_ptr=0;

        while(s_ptr<s.length() && w_ptr<w.length()) {
            if(s.charAt(s_ptr) == w.charAt(w_ptr)) {
                s_ptr++;
                w_ptr++;
            }
            else s_ptr++;
        }
        if(w_ptr==w.length()) return true;
        return false;

         */
    }
}
