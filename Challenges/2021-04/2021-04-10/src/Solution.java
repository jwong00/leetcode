import java.util.ArrayList;
import java.util.LinkedHashSet;

class Solution {

    public int longestIncreasingPath(int[][] matrix) {
        if(matrix.length==0) return 0;
        int m = matrix.length, n = matrix[0].length;

        int[][] memo = new int[m][n];

        int best = 1;

        for(int i=0;i<matrix.length;i++) {
            for(int j=0;j<matrix[0].length;j++) {
                //initiate a search on this index
                best = Math.max(search(i,j,m,n,matrix,memo,Integer.MIN_VALUE),best);
            }
        }
        return best;
    }

    private int search(int i, int j, int m, int n, int[][] matrix, int[][] memo,int last) {

        if(i < 0 || j < 0 || i>=m || j>=n || matrix[i][j]<=last) return 0;

        if(memo[i][j]!=0) return memo[i][j];

        int best = 1;

        best = Math.max(1+search(i-1,j,m,n,matrix,memo,matrix[i][j]),best);
        best = Math.max(1+search(i,j-1,m,n,matrix,memo,matrix[i][j]),best);
        best = Math.max(1+search(i+1,j,m,n,matrix,memo,matrix[i][j]),best);
        best = Math.max(1+search(i,j+1,m,n,matrix,memo,matrix[i][j]),best);

        memo[i][j] = best;

        return best;

    }
}
