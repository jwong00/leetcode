class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.climbStairs(2));
        System.out.println(s.climbStairs(3));
        System.out.println(s.climbStairs(4));
        System.out.println(s.climbStairs(5));
        System.out.println(s.climbStairs(6));
    }
    public int climbStairs(int n) {
        int[] memo = new int[n];
        return climb(0,n,memo);
    }

    public int climb(int i, int n,int[] memo) {
        if(i>n) return 0;
        if(i==n) return 1;
        if(memo[i]>0) return memo[i];

        memo[i] = climb(i+1,n,memo) + climb(i+2,n,memo);
        return memo[i];
    }
}
