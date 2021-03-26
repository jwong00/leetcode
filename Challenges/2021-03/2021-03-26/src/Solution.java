import java.util.*;

class Solution {
    public static void main(String[] args) {
//        if('a'<'b') System.out.println("a<b!");

        Solution s = new Solution();
//        s.wordSubsets(new String[] {"warrior","wrecker","omnipotence"},new String[] {"wrr"});


        s.wordSubsets(new String[] {"amazon","apple","facebook","google","leetcode"},new String[] {"e","o"});

//        s.wordSubsets(new String[] {"apple"},new String[] {"e","o"});
    }
    public List<String> wordSubsets(String[] A, String[] B) {

        char[][] B_sorted = new char[B.length][];
        List<String> result = new ArrayList(A.length);

        int[][] charCount = new int[B.length]['z' - 'a' + 1];

        //count all chars in B
        char[] t;
        for(int i=0;i<B.length;i++) {
            t = B[i].toCharArray();
            for(char c : t) {
                charCount[i][c-'a']++;
            }
        }


        for(String s : A) {


        }
        System.out.println("List of UNIVERSAL strings: "+result.toString());

        return result;
    }

    @SuppressWarnings("IfStatementWithIdenticalBranches")
    public boolean subset(char[] sorted, char[] B) {
        System.out.println("Testing subsetness of "+Arrays.toString(B)+" against the sorted word \""+Arrays.toString(sorted)+"\"");

        if(B.length > sorted.length) return false;

        int[] cache = new int['z'-'a'+1];

        int k = 'z'-'a';

        for(char c : B) {
            cache[c-'a']++;
        }

        for(char c : sorted) {
            cache[c-'a']--;
        }

        for(int i=0;i<cache.length;i++) {
            if(cache[i]>0) return false;
        }

        return true;
    }


}
