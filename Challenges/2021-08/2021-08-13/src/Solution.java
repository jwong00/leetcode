import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.setZeroes(new int[][] {{1,1,1},{1,0,1},{1,1,1}});
        s.setZeroes(new int[][] {{0,1,2,0},{3,4,5,2},{1,3,1,5}});
    }
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;

        //first row
        boolean firstRow = false;
        for(int j=0;j<n;j++) {
            if(matrix[0][j]==0) {
                firstRow = true;
                break;
            }
        }

        //first col
        boolean firstCol = false;
        for(int i=0;i<m;i++) {
            if(matrix[i][0]==0) {
                firstCol = true;
                break;
            }
        }

        //the rest
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(matrix[i][j]==0) {
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }

        for(int i=1;i<m;i++) {
            for(int j=1;j<n;j++) {
                if(matrix[i][0]==0 || matrix[0][j]==0) matrix[i][j]=0;
            }
        }

        if(firstRow) for(int j=0;j<n;j++) matrix[0][j]=0;

        if(firstCol) for(int i=0;i<m;i++) matrix[i][0]=0;

        System.out.println(Arrays.deepToString(matrix));
    }
}
