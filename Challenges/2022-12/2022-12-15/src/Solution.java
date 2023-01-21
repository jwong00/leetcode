class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.longestCommonSubsequence("abcde","ace"));
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] memo = new int[m][n];
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                memo[i][j] = -1;
            }
        }

        //call recursive
        return lcs(text1,text2,0,0,memo,m,n);
    }

    public int lcs(String t1, String t2, int i, int j, int[][] memo, int m, int n) {
        if(i>=m || j>=n) return 0;
        else if(memo[i][j]>0) return memo[i][j];

        int t = 0;
        if(t1.charAt(i)==t2.charAt(j)) {
            t = 1 + lcs(t1,t2,i+1,j+1,memo,m,n);
        }
        else {
            t = Math.max(lcs(t1,t2,i+1,j,memo,m,n),lcs(t1,t2,i,j+1,memo,m,n));
        }
        memo[i][j] = t;
        return t;
    }
}
