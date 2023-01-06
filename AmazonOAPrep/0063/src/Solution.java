import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.uniquePathsWithObstacles(new int[][]{{0,1},{0,0}}));
        System.out.println(s.uniquePathsWithObstacles(new int[][]{{0,0,0},{0,1,0},{0,0,0}}));
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        //validation

        if(obstacleGrid==null) return 0;
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        if(obstacleGrid[m-1][n-1]==1) return 0;
        if(m<1 || n>100) return 0;

        int[][] memo = new int[m][n];
        memo[m-1][n-1] = 1;

        //fill from bottom right to top left
        //row by row
        for(int i = m-1; i>=0; i--) {

            for(int j = n-1; j>=0; j--) {

                if(i==m-1 && j==n-1) continue;
                if(i==m-1) { //on last row, only add from right
                    memo[i][j] = obstacleGrid[i][j]==1 ? 0 : memo[i][j+1];
                } else if (j == n-1) { //on last col, only add from below
                    memo[i][j] = obstacleGrid[i][j]==1 ? 0 : memo[i+1][j];
                }
                else {
                    memo[i][j] = obstacleGrid[i][j]==1 ? 0 : memo[i+1][j] + memo[i][j+1];
                }
            }
        }

        return memo[0][0];
    }
}
