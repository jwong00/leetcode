class Solution {
    public static void main(String[] args) {
        int[][] g = {{0,0,0},{1,1,0}};
        Solution s = new Solution();
        s.shortestPathBinaryMatrix(g);

    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        System.out.println(grid.length);
        System.out.println(grid[0].length);

        search(grid,0,0);

        return 0;
    }

    public int search(int [][] grid, int x, int y, int callerWeight) {
        if( x<0 || y < 0 ) return 1; //"failure" value
        if(callerWeight-1 < grid[x][y]) grid[x][y] = callerWeight-1;

        //call search
    }
}
