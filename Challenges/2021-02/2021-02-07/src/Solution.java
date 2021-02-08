import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        s.shortestToChar("loveleetcode",'e');
    }
    public int[] shortestToChar(String s, char c) {
        char[] string = s.toCharArray();
        int[] characterIndex = new int[string.length];

        /* store indices of each occurrence of c */
        int k = 0;
        for(int i = 0; i<string.length; i++) {
            if(string[i] == c) {
                characterIndex[k] = i;
                k++;
            }
        }

        System.out.println("Locations of char "+c);
        System.out.println(Arrays.toString(characterIndex));

        /* iterate over string again, for each non-c character,
        * find the difference between indices of each occurrence of c
        * and store the difference with the least magnitude
        *
        * optimum solution probably involves only comparing to the
        * nearest values, probably just one or two of them...
        * */
        int[] shortestDistances = new int[string.length];

        for(int i = 0; i<string.length; i++) {
            int currentShortest = Math.abs(i-characterIndex[0]);
            for(int j = 0; j<k; j++) {
                int currentDistance = Math.abs(i - characterIndex[j]);
                if(currentDistance < currentShortest) currentShortest = currentDistance;
            }

            shortestDistances[i] = currentShortest;
        }

        System.out.println(Arrays.toString(shortestDistances));

        return shortestDistances;
    }
}
