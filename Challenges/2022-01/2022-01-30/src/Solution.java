class Solution {
    public int maximumWealth(int[][] accounts) {
        if(accounts==null || accounts.length==0) return 0;

        int wealth_max = 0;
        for(int i=0;i<accounts.length;i++) {
            int wealth_cur = 0;
            for(int j=0;j<accounts[i].length;j++) {
                wealth_cur += accounts[i][j];
            }

            wealth_max = Math.max(wealth_max,wealth_cur);
        }

        return wealth_max;

    }
}
