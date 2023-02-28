import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.bestTeamScore(new int[]{1,3,5,10,15},new int[]{1,2,3,4,5}));
        System.out.println(s.bestTeamScore(new int[]{4,5,6,5},new int[]{2,1,2,1}));
        System.out.println(s.bestTeamScore(new int[]{1,2,3,5},new int[]{8,9,10,1}));
    }
    public int bestTeamScore(int[] scores, int[] ages) {

        int n = scores.length;

        //store and sort players first by age then score
        int[][] players = new int[n][2];

        for(int i=0;i<n;i++) {
            players[i][0] = ages[i];
            players[i][1] = scores[i];
        }

        Arrays.sort(players,(a,b)-> a[0]==b[0] ? a[1]-b[1] : a[0]-b[0]);
        System.out.println(Arrays.deepToString(players));

        //start dfs with -1,0

        return dfs(new Integer[n][n], players,-1,0);
    }

    public int dfs(Integer[][] dp, int[][] players, int prev, int index) {

        if(index>=players.length) return 0;

        if(dp[prev+1][index]!=null) return dp[prev+1][index];

        if(prev== -1 || players[index][1] >= players[prev][1]) {
            return dp[prev+1][index] = Math.max(dfs(dp,players,prev,index+1),
                    players[index][1]+dfs(dp,players,index,index+1));
        }

        //call next dfs without adding player at index, do not update prev
        return dp[prev+1][index] = dfs(dp,players,prev,index+1);

    }
}