public class Solution {
    public static final int FLAG = -100000;

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][]        case1 = {{1,1,1,0},{1,0,1,1},{0,1,1,1},{1,1,1,1}};
        int[][] case2 = {{1,1,1},{1,0,1},{1,1,1}};
        s.setZeroes(case2);
    }

    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        //setting flags
        Boolean containsZeroRow = false;
        for(int j = 0; j< m; j++) {
            if(matrix[0][j]==0) {
                containsZeroRow=true;
                break;
            }
        }

        Boolean containsZeroCol = false;
        for(int i = 0; i < n; i++) {
            if(matrix[i][0]==0) {
                containsZeroCol=true;
                break;
            }
        }

        /*
        performing the following search for 0's and terminating when detecting the
        first one for each row and each column may result in performance savings on large tables.
         */
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(matrix[i][j]==0) {
                    matrix[i][0] = FLAG;
                    matrix[0][j] = FLAG;
                    break;
                }
            }
        }
        for(int j=0;j<m;j++) {
            for(int i=0;i<n;i++) {
                if(matrix[i][j]==0) {
                    matrix[i][0] = FLAG;
                    matrix[0][j] = FLAG;
                    break;
                }
            }
        }

        //process row-by-row
        for(int i = 1; i< n; i++) {
            if(matrix[i][0]== FLAG) {
                for(int j=1;j<m;j++) {
                    matrix[i][j]=0;
                }
            }
        }

        //process col-by-col
        for(int j = 1; j< m; j++) {
            if(matrix[0][j]== FLAG) {
                for(int i = 0; i< n; i++) {
                    matrix[i][j]=0;
                }
            }
        }
        for(int j=0;j<m;j++) {
            if(containsZeroRow) matrix[0][j]=0;
            else if(matrix[0][j]==FLAG) matrix[0][j]=0;
        }
        for(int i=0;i<n;i++) {
            if(containsZeroCol) matrix[i][0]=0;
            else if(matrix[i][0]==FLAG) matrix[i][0]=0;
        }
    }
}
