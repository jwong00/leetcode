class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        for(int i=0;i<UPPER_BOUND;i++) {
            System.out.println(s.tribonacci(i));
        }
    }

    int[] memo;
    static final int UPPER_BOUND = 38;

    public Solution() {
        memo = new int[UPPER_BOUND];
        memo[0]=0;
        memo[1]=1;
        memo[2]=1;
    }

    public int tribonacci(int n) {
        if(n >=UPPER_BOUND) return -1; //should never be called by LC tester
        if(n > 2 && memo[n]==0) {
            memo[n] = tribonacci(n-1) + tribonacci(n-2) + tribonacci(n-3);
        }
        return memo[n];
    }
}
