/*
You have n dice and each die has k faces numbered from 1 to k.

Given three integers n, k, and target, return the number of possible ways (out of the k^n total ways)
to roll the dice so the sum of the face-up numbers equals target. Since the answer may be too large,
return it modulo 10^9 + 7.
* */

class Solution {
    final int M = 1_000_000_007;

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.numRollsToTarget(1,6,3));
        System.out.println(s.numRollsToTarget(2,6,7));
        System.out.println(s.numRollsToTarget(30,30,500));
    }

    public int numRollsToTarget(int n, int k, int target) {
        //The states are how many dice are remaining, and what sum total you have rolled so far.

        return helper(0,n, k, 0, target, new Integer[n+1][target+1]);
    }

    int helper(int i, int n, int k, int cur, int target, Integer[][] memo) {
        //termination condition
        if(i==n) return cur==target ? 1 : 0 ;

        //check memo
        if(memo[i][cur]!=null) return memo[i][cur];

        //recurse
        int count = 0;

        for(int j=1;j<=Math.min(k,target-cur);j++) {
            count = (count + helper(i+1,n,k,cur+j,target,memo)) % M ;
        }

        return memo[i][cur] = count;

    }
}
