public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int l = 1, r = n, m = (l+r)/2;

        while( l <= r ) {

            m = l + (l+r)/2;

            if(guess(m)==0) {
                return m;
            }
            else if(guess(m)<0) {
                r = m - 1;
            }
            else {
                l = m + 1;
            }
        }
        return -1;
    }
}
