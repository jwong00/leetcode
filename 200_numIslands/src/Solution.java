import java.util.Arrays;

/**
 * Created by Glamdring on 4/20/2017.
 */
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] map = {
                {1,1,1,3},
                {1,1,0,0},
                {0,0,0,1},
                {1,0,0,0}
        };
        s.numIslands(map);
    }
    public int numIslands(int[][] grid) {
        int cols, rows;
        if(grid.length<1) return 0;
        else {
            rows=grid.length;
            cols=grid[0].length;
        }

        /* iterate over each row left to right
         * then repeat for  each subsequent column */
//        System.out.println(Arrays.toString(grid[0]));
        for(int i=0;i<rows;i++) {
//            System.out.println(Arrays.toString(grid[i]));
            for(int j=0;j<cols;j++) {
                System.out.print(grid[i][j]+" ");
                scan(grid,i,j);
            }
            System.out.println( );
        }

        return 0;
    }

    public boolean scan(int[][] grid, int i,int j) {
        if(grid[i][j]==0) return false;
        else {
            grid[i][j]=0;
            return true;
        }
    }
}
