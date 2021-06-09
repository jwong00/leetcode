class Solution {
    public static void main(String[] args) {

        Solution s = new Solution();
        int[][] q = {
                {0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}
            };
        System.out.println(s.maxAreaOfIsland(q));
    }

    public int[][] grid;

    public int maxAreaOfIsland(int[][] grid) {
        if(grid==null || grid.length==0) return 0;

        this.grid = grid;

        //loop to find island
        int max = 0;
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[0].length;j++) {
                if(grid[i][j]==1) max = Math.max(max,traverseIsland(i,j));
            }
        }

        return max;
    }


    //returns size of island
    public int traverseIsland(int x, int y) {

        if(x<0 || y<0 || x>grid.length-1 || y>grid[0].length-1 || grid[x][y]==0) return 0;

        //else
        grid[x][y] = 0;
        return  traverseIsland(x-1,y) +
                traverseIsland(x,y-1) +
                traverseIsland(x+1,y) +
                traverseIsland(x,y+1) + 1;

    }
}
