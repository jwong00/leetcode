/**
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is lower than the guess number
 *			      1 if num is higher than the guess number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int l = 0, m = n/2, r = n;

        while(l<=r ) {
           if(guess(m)==0) return m;
           else if(guess(m)<0) {
               r = m - 1;
           }
           else l = m + 1;

           m = l + (r-l)/2;
        }

        return 0;


    }

}
