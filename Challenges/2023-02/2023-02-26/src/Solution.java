class Solution {
    public int minDistance(String word1, String word2) {
        //min dist for prefix of 0 to 0?
        //same as min dist for prefix of any k to k where each char is equal
        //0->k takes k insertion
        //same as k->0, which is k removal

        //aabaa->obo is 4
        //

        //table representing min steps to transform word1->word2
        int m = word1.length(), n = word2.length();
        int[][] transform = new int[m][n];

        //steps to transform 0-length prefix of word1 into
        //i-length prefix of word2
        for(int i=0;i<n;i++) {
            transform[0][i] = i; //i "insertions"
        }

        //steps to transform j-length prefix of word1 into
        //0-length prefix of word2
        for(int j=0;j<m;j++) {
            transform[j][0] = j; //j "deletions"
        }

        

    }
}
