class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.numIslands(new char[][]{{'1','1','1'},{'0','0','0'},{'1','0','1'}}));
    }
    public int numIslands(char[][] grid) {
        int m = grid.length,n = grid[0].length;
        int count = 0;
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(grid[i][j]=='1') {
                    count++;
                    dfs(grid,i,j,m,n);
                }
            }
        }
        return count;
    }

    public void dfs(char[][] grid, int x, int y, int m, int n) {

        if( x<0 || x>=m || y<0 || y>=n ) return;
        if(grid[x][y]=='0') return;

        grid[x][y]='0';
        dfs(grid,x-1,y,m,n);
        dfs(grid,x+1,y,m,n);
        dfs(grid,x,y-1,m,n);
        dfs(grid,x,y+1,m,n);

    }
}
