import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.longestCommonSubsequence("abcde","ace"));
        System.out.println(s.longestCommonSubsequence("pmjghexybyrgzczy","hafcdqbgncrcbihkd"));
        System.out.println(s.longestCommonSubsequence("bsbininm","jmjkbkjkv"));
    }
    public int longestCommonSubsequence(String text1, String text2) {
        return lcs_rmw(text1, text2);
    }

    public int lcs_rmw(String text1,String text2) {
        int[][] memo = new int[text1.length()+1][text2.length()+1];
        for(int i=0;i<text1.length()+1;i++) {
            Arrays.fill(memo[i],-1);
        }
        return lcs_rm(text1,text2,0,0,memo);
    }
    public int lcs_rm(String text1, String text2, int i, int j,int[][] memo) {
        if(i>=text1.length() || j>=text2.length()) return 0;
        else if(memo[i][j] > -1) return memo[i][j];
        //any calls to lcs_rm after this line must be memoized
        //or the previous check would have been true

        int t = 0;
        if(text1.charAt(i)==text2.charAt(j)) {
            t = 1 + lcs_rm(text1,text2,i+1,j+1,memo);
        }
        else {
            t = Math.max(lcs_rm(text1,text2,i+1,j,memo),lcs_rm(text1,text2,i,j+1,memo));
        }

        memo[i][j] = t;
        return memo[i][j];
    }


    public int lcs_rw(String text1,String text2) {
        return lcs_r(text1,text2,0,0);
    }
    public int lcs_r(String text1, String text2, int i, int j) {
        if(i>=text1.length() || j>=text2.length()) return 0;
        else if(text1.charAt(i)==text2.charAt(j)) return 1 + lcs_r(text1,text2,i+1,j+1);
        else return Math.max(lcs_r(text1,text2,i+1,j),lcs_r(text1,text2,i,j+1));
    }
}
