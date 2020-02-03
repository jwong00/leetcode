public class Solution {
    int primesCount = 2;
    int lookupTableSize = 1000;
    int[] primeCountTable = new int[lookupTableSize];
    boolean[] primalityTable = new boolean[lookupTableSize];

    public Solution() {
        primeCountTable[0] = 0;
        primeCountTable[1] = 0;
        primeCountTable[2] = 0;
        primalityTable[0] = false;
        primalityTable[1] = false;
        primalityTable[2] = true;
    }

    public int countPrimes(int n) {
        if(n<=2) return 0;
        else if(n<=4) return n-2;
        else if(n<=primesCount) return primeCountTable[n];

        /* for n >= 4*/
        boolean[] sieve = new boolean[n+1];
        int countPrimes=0;
        for(int i=2;i*i<n;i++) {
            if(sieve[i]==false) {
                for (int j = i*i; j < n+1; j += i) {
                    sieve[j] = true;
                }
            }
        }
        for(int i=2;i<n;i++) if(sieve[i]==false) countPrimes++;

        //start from primeCountTable[primesCount], find primeCountTable[primesCount+1...n]
        return countPrimes;
    }
}

