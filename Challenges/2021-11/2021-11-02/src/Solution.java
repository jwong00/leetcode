class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.uniquePathsIII(new int[][]{{1,0,0,0},{0,0,0,0},{0,0,2,-1}}));
    }
    int m,n;

    public int uniquePathsIII(int[][] grid) {
        if(grid==null || grid.length==0 || grid[0].length==0) return 0;
        m = grid.length;
        n = grid[0].length;

        int x= -1, y= -1;
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(grid[i][j]==1) {
                    x=i;
                    y=j;
                }
            }
        }

        return dfs(grid,x,y);
    }

    public int dfs(int[][] grid, int x, int y) {
        //check if in range
        if(x<0 || y<0 || x>=m || y>=n) return 0;

        //short circuit
        if(grid[x][y]== -1) return 0;
        if(grid[x][y]==2) return 1;

        //mark current as obstacle so we don't touch it again during the current walk
        grid[x][y] = -1;

        //call on adjacent squares
        int ans = dfs(grid,x-1,y) + dfs(grid, x,y-1) + dfs(grid,x+1,y) + dfs(grid,x,y+1);

        //unmark
        grid[x][y] = 0;
        return ans;

    }
}