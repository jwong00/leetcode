import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.findKthNumber(3,3,5);
    }
    public int findKthNumber(int m, int n, int k) {
        return findKthNumberNaive(m,n,k);
    }

    //generate a 1d merged table?
    public int findKthNumberNaive(int m, int n, int k) {
        int[][] table_2D = new int[m][n];

        for(int i=0;i<m;i++) table_2D[i][0] = i+1;
        for(int j=1;j<n;j++) table_2D[0][j] = j+1;

        System.out.println(Arrays.deepToString(table_2D));

        for(int i=1;i<m;i++) {
            for(int j=1;j<n;j++) {
                table_2D[i][j] = (i+1)*(j+1);
            }
        }

        System.out.println(Arrays.deepToString(table_2D));

        return -1;
    }
}
