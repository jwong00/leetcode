class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.tribonacci(3));
        System.out.println(s.tribonacci(25));
    }
    public int tribonacci(int n) {
        /*
        * T_0 = 0
        * T_1 = 1
        * T_2 = 1
        * T_n = T_(n-3) + T_(n-2) + T_(n-1) for n>=3
        *
        * ex
        * T_3 = T_0 + T_1 + T_2 = 0 + 1 + 1 = 2
        * */
        if(n<0) return -1;
        if(n<=1) return n;
        if(n==2) return 1;

        int[] t = new int[n+1];
        t[0] = 0;
        t[1] = 1;
        t[2] = 1;

        for(int i=3;i<=n;i++) {
            t[i] = t[i-3] + t[i-2] + t[i-1];
        }

        return t[n];
    }
}