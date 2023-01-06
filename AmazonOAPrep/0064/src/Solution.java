class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.minPathSum(new int[][]{{1,3,1},{1,5,1},{4,2,1}}));
        System.out.println(s.minPathSum(new int[][]{{1,3,1}}));
        System.out.println(s.minPathSum(new int[][]{{1,2,3},{4,5,6}}));
    }
    public int minPathSum(int[][] grid) {
        if(grid==null) return 0;
        int m = grid.length, n = grid[0].length;

        //re-use input array as memo
        //init bottom row and right col to min path sums

        for(int k=n-2;k>=0;k--) {
            grid[m-1][k]+=grid[m-1][k+1];
        }

        for(int k=m-2;k>=0;k--) {
            grid[k][n-1]+=grid[k+1][n-1];
        }

        for(int i=m-2;i>=0;i--) {
            for(int j=n-2;j>=0;j--) {
                grid[i][j]+=Math.min(grid[i+1][j],grid[i][j+1]);
            }
        }

        return grid[0][0];
    }
}
