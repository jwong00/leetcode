/*
    Constraints:

        m == obstacleGrid.length
        n == obstacleGrid[i].length
        1 <= m, n <= 100
        obstacleGrid[i][j] is 0 or 1.
* */

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] q = {{0,0,0},{0,1,0},{0,0,0}};
        System.out.println(s.uniquePathsWithObstacles(q));
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid.length==0) return 0;

        int m=obstacleGrid.length, n=obstacleGrid[0].length;
        int[][] t = new int[m][n];

        if(obstacleGrid[0][0]==1) t[0][0]=0;
        else t[0][0]=1;

        for(int i=1;i<m;i++) {
            if(obstacleGrid[i][0]==1) t[i][0]=0;
            else t[i][0]=t[i-1][0];
        }

        for(int j=1;j<n;j++) {
            if(obstacleGrid[0][j]==1) t[0][j]=0;
            else t[0][j]=t[0][j-1];
        }

        for(int i=1;i<m;i++) {
            for(int j=1;j<n;j++) {
                if(obstacleGrid[i][j]==1) t[i][j]=0;
                else t[i][j]=t[i-1][j]+t[i][j-1];
            }
        }

        return t[m-1][n-1];
    }
}
