import java.util.Arrays;

/**
 * Created by Glamdring on 4/27/2017.
 */
public class Solution {


    public static void main(String[] args) {
        Solution s = new Solution();
//       /**/ System.out.println(s.countPrimes(1)); //
//        System.out.println(s.countPrimes(2)); //
//        System.out.println(s.countPrimes(3)); //2
        System.out.println(s.countPrimes(4)); //2,3
        System.out.println(s.countPrimes(499978));

//        System.out.println(s.countPrimes(15)); //2,3,5,7,11,13
//        System.out.println(s.countPrimes(16));
//        System.out.println(s.countPrimes(17));
        System.out.println(s.countPrimes(18));
//        System.out.println(s.countPrimes(19)); //2,3,5,7,11,13,17
//        System.out.println(s.countPrimes(20));
//        System.out.println(s.countPrimes(19));
//        System.out.println(s.countPrimes(16));
        System.out.println(s.countPrimes(6)); //

    }

    public int countPrimes(int n) {
        if(n<=2) return 0;
        else if(n<=4) return n-2;

        /* for n >= 4*/
        boolean[] sieve = new boolean[n+1];
        Arrays.fill(sieve,true);
        sieve[0]=false;
        sieve[1]=false;

        int countPrimes=0;
//        int decCountPrimes=n/2-2;

        for(int i=4;i <= n; i+=2) {
            sieve[i]=false;
//            decCountPrimes--;
        }

        for(int i=3;i*i<n;i+=2) {
            if(sieve[i]==true) {
                for (int j = i*i; j < n+1; j += i) {
                    sieve[j] = false;
//                    decCountPrimes--;
                }
            }
        }
        for(int i=2;i<n;i++) if(sieve[i]==true) countPrimes++;
//        System.out.println("Dec count=="+decCountPrimes);
        return countPrimes;
    }

}

