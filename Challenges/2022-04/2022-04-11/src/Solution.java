import java.util.Arrays;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.shiftGrid(new int[][]{{3,8,1,9},{19,7,2,5},{4,6,11,10},{12,0,21,13}},1));

    }
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        if(grid==null || grid.length==0 || grid[0].length==0) return null;

        int m = grid.length,n=grid[0].length;

        int r_shift = k / n;
        int c_shift = k % n;

        System.out.println(m-1-r_shift);
        System.out.println(n-1-c_shift);


        System.out.println(grid[m-1-r_shift][n-1-c_shift]);

        for(int i=m-r_shift;i<m;i++) {
            for(int j=c_shift;j<n;j++) {
                System.out.println(grid[i][j]);
            }
        }





        return null;
    }
}
