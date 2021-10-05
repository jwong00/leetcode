class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.islandPerimeter(new int[][]{{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}}));
    }

    int m, n;
    public int islandPerimeter(int[][] grid) {
        if(grid==null) return 0;
        m = grid.length;
        n = grid[0].length;
        if(m==0 ||  n==0) return 0;

        //linear search to find land
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(grid[i][j]>0) {
                    return bfs(i,j,0,grid);
                }
            }
        }
        return 0;
    }

    public int bfs(int i, int j, int perimeter, int[][] grid) {

        if(i < 0 || j < 0 || i >= m || j >= n) return 1;
        if(grid[i][j]==0) return 1;
        if(grid[i][j]== -1) return 0;
        if(grid[i][j]== +1) {
            grid[i][j] = -1; //so we don't get stuck in a cycle
            return perimeter + bfs(i-1,j,perimeter,grid) + bfs(i,j-1,perimeter,grid)
                    + bfs(i+1,j,perimeter,grid) + bfs(i,j+1,perimeter,grid);
        }
        return -1;
    }
}
