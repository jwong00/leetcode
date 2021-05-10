import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.minDistance("sea","eat"));         //2
//        System.out.println(s.minDistance("leetcode","etco"));   //4
//        System.out.println(s.minDistance("grimoire","grim"));   //4
//        System.out.println(s.minDistance("codex","code"));   //1
//        System.out.println(s.minDistance("commonplace","placid"));   //9?
//        System.out.println(s.minDistance("angel","angle"));   //2
        System.out.println(s.minDistance("sentkient","nkti"));   //7
        System.out.println(s.minDistance("dinitrophenylhydrazine","acetylphenylhydrazine"));   //11
    }
    public int minDistance(String word1, String word2) {

        int l1=word1.length(), l2=word2.length();

        int[][] memo = new int[l1+1][l2+1];
        for(int i=0;i<memo.length;i++) {
            Arrays.fill(memo[i], -1);
        }

        if(l1==0 && l2==0) return 0;
        if(l1==0) return l2;
        if(l2==0) return l1;

        return dfs(word1.toCharArray(),0,word2.toCharArray(),0,memo);

    }

    public int dfs(char[] word1, int p1, char[] word2, int p2, int[][] memo) {
        if(memo[p1][p2] != -1) return memo[p1][p2];

        if(p1 == word1.length) return memo[p1][p2] = word2.length-p2;
        if(p2 == word2.length) return memo[p1][p2] = word1.length-p1;

        if(word1[p1]==word2[p2]) return memo[p1][p2] = dfs(word1,p1+1,word2, p2+1,memo);

        return memo[p1][p2] = 1 + Math.min(dfs(word1,p1+1,word2,p2,memo),dfs(word1,p1,word2,p2+1,memo));

    }
}
