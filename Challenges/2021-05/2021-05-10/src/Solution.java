class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.countPrimes(7));
        System.out.println(s.countPrimes(3));
        System.out.println(s.countPrimes(2));
        System.out.println(s.countPrimes(1));
        System.out.println(s.countPrimes(99));
    }
    public int countPrimes(int n) {
        if(n<=1) return 0;
        if(n<=3) return n-2;

        /*
        * false --> prime
        *  true --> composite
        * */
        boolean[] sieve = new boolean[n];

        int c = 0;
        for(int i=2;i*i<n;i++) {
            if(!sieve[i]) {
                for(int j=i*i;j<n ;j+=i) {
                    sieve[j] = true;
                }
            }
        }

        for(int k=2; k<n; k++) {
            if(!sieve[k]) c++;
        }
        return c;
    }
}
