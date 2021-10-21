class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.numSquares(12));
        System.out.println(s.numSquares(13));
        System.out.println(s.numSquares(9));
        System.out.println(s.numSquares(25));
        System.out.println(s.numSquares(100));
    }
    public int numSquares(int n) {
        if(n<=3) return n;
        int[] memo = new int[n+1];
        for(int i=0;i<4;i++) memo[i] = i;
        for(int i=1;i*i<=n;i++) {
            memo[i*i] = 1;
        }
        return helper(n,memo);
    }

    private int helper(int n, int[] memo) {
        if(memo[n] > 0) return memo[n];

        //max number of perfect squares is just n 1's
        int ans = n;
        for(int i=1;i*i<=n;i++) {
            ans = Math.min(ans,1+numSquares(n - i*i));
        }
        return ans;
    }
}
