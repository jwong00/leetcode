class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isIsomorphic("egg","add"));
        System.out.println(s.isIsomorphic("foo","bar"));
    }
    public boolean isIsomorphic(String s, String t) {

        if(s.length()!=t.length()) return false;

        int n = s.length();

        int[] s_freq = new int[128];
        int[] t_freq = new int[128];

        int[] s_counts = new int[s.length()+1];
        int[] t_counts = new int[t.length()+1];

        //count of each char
        for(int i=0;i<n;i++) {
            s_freq[s.charAt(i)]++;
            t_freq[t.charAt(i)]++;
        }

        //count of char with _freq occurrences
        for(int j=0;j<128;j++) {
            s_counts[s_freq[j]]++;
            t_counts[t_freq[j]]++;
        }

        //strings are isomorphic if...
        for(int k=1;k<n+1;k++) {
            if(s_counts[k]!=t_counts[k]) return false;
        }

        return true;
    }
}
