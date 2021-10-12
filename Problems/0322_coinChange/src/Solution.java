class Solution {
    public static void main(String[] args) {

        Solution s = new Solution();
        System.out.println(s.coinChange(new int[]{1,2,5},11));

    }
    public int coinChange(int[] coins, int amount) {
        int[] table = new int[amount+1];
        for(int i=0;i<coins.length;i++) {
            table[coins[i]] = 1;
        }

        return helper(coins,amount,table);

    }

    public int helper(int[] coins, int amount, int[] memo) {
        if(amount < 0) return -1;
        if(memo[amount]!=0) return memo[amount];
        if(amount==0) return 1;

        int min = Integer.MAX_VALUE;
        for(int i=0;i<coins.length;i++) {
            min = Math.min(min,helper(coins,amount-coins[i],memo));
        }

        memo[amount] = min;
        return memo[amount];
    }


}
