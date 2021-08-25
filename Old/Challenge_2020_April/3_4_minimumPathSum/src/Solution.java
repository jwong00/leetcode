import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] k = {
                {1,3,1},
                {1,5,1},
                {4,2,1}
        };
        System.out.println(s.minPathSum(k));
    }

    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] t = new int[n][m];

        t[0][0]=grid[0][0];

        for(int i=1; i<m; i++) {
            t[0][i]=grid[0][i]+t[0][i-1];

        }
        for(int i=1; i<n; i++) {
            t[i][0]=grid[i][0]+t[i-1][0];
        }

        for(int j=1; j<n; j++) {
            for(int k=1; k<m; k++) {
                t[j][k]= Math.min(t[j-1][k],t[j][k-1])+grid[j][k];
            }
        }
        return t[n-1][m-1];
    }
}
