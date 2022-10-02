class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.calculateMinimumHP(new int[][]{{-2,-3,3},{-5,-10,1},{10,30,-5}}));


        //down
    }
    public int calculateMinimumHP(int[][] dungeon) {
        if(dungeon==null || dungeon.length==0 || dungeon[0].length==0) return 1;

        int m = dungeon.length,n=dungeon[0].length;

        return helper(dungeon,0,0,0,m,n);


    }

    public int helper(int[][] dungeon, int hp_net, int i, int j, int m, int n) {
//        if(i>=m || j>=n) return hp_net;

        //only return if at the last correct location

        //filter illegal moves BEFORE making them since:
        //if(i>=m || j>=n) return hp_net;
        //would be treated as valid subproblem results

        if(i==m-1 && j==n-1) return hp_net;

        int left = Integer.MAX_VALUE;
        int down = Integer.MAX_VALUE;
        if(j+1<n) left = helper(dungeon,hp_net+dungeon[i][j],i,j+1,m,n);
        if(i+1<m) down = helper(dungeon,hp_net+dungeon[i][j],i+1,j,m,n);

        return Math.min(left,down);
    }
}
