class Solution {
    public int maxEnvelopes(int[][] envelopes) {

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public static void main(String[] args) {

        Solution s = new Solution();
        s.maxEnvelopes(new int[][] {{5,4},{6,4},{6,7},{2,3}});
    }
    public int maxEnvelopes(int[][] envelopes) {
        Set<int[]> pruningSet = Collections.synchronizedSet(new HashSet<int[]>());

        for(int i=0;i<envelopes.length;i++) {
            System.out.println("ADDING..."+ Arrays.toString(envelopes[i]));
            pruningSet.add(envelopes[i]);
        }

        int c = 1;
        for(int i=0;i<envelopes.length;i++) {
            if(pruningSet.contains(envelopes[i])) {
                for (int j = 0; j < envelopes.length; j++) {
                    if(matryoshka(envelopes[i],envelopes[j]) && pruningSet.remove(envelopes[j]) ) {
                        System.out.println(Arrays.toString(envelopes[j])+" fits into "  +Arrays.toString(envelopes[i] ));
                        c++;
                    }
                }
            }
        }


        System.out.println("Tentative number of env that can be Russian Dolled is "+ c);

        return c;

    }

    public boolean matryoshka(int[] a,  int[] b) {
        return b[0]<a[0] && b[1]<a[1] ? true : false;
    }
}
