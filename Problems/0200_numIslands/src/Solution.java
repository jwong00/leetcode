import java.util.Arrays;

/**
 * Created by Glamdring on 4/20/2017.
 */
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        char[][] map = {
                {'1','1','1','0'},
                {'1','1','0','0'},
                {'0','0','0','0'},
                {'0','0','0','0'}
        };
        System.out.println(s.numIslands(map));
    }

    public int numIslands(char[][] grid) {
        int cols, rows, islands=0;
        if(grid.length<1) return 0;
        else {
            rows=grid.length;
            cols=grid[0].length; //assume all rows of equal length
        }

        /* iterate over each row left to right
         * then repeat for  each subsequent column */
        for(int i=0;i<rows;i++) {
            for(int j=0;j<cols;j++) {
                if(scan(grid,i,j)) islands++;
            }
        }

        return islands;
    }

    public boolean scan(char[][] grid, int i,int j) {
        /* Check if at a 0, or out-of-bounds. */
        if(     i<0 ||
                j<0 ||
                i>grid.length-1 ||
                j>grid[0].length-1) //assume all rows of equal length
            return false;

        /* If out-of-bounds, treat it as a 0 and just return false. */
        if(grid[i][j]=='0') return false;
        /* Else, must be a 1, which is  part of the island. */
        else {
            grid[i][j]='0';
            scan(grid,i-1,j); //above
            scan(grid,i+1,j); //below
            scan(grid,i,j-1); //left
            scan(grid,i,j+1); //right
            return true;
        }
    }
}
