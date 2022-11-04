import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.findBall(
                new int[][] {   {1,1,1,-1,-1},{1,1,1,-1,-1},
                                {-1,-1,-1,1,1},{1,1,1,1,-1},{-1,-1,-1,-1,-1}
                            })));
        System.out.println(Arrays.toString(s.findBall(
                new int[][] {   {1,1,1,1,1,1},
                                {-1,-1,-1,-1,-1,-1},
                                {1,1,1,1,1,1},
                                {-1,-1,-1,-1,-1,-1}
                            })));
    }
    public int[] findBall(int[][] grid) {
        if(grid==null) return new int[]{};

        int m = grid.length, n = grid[0].length;

        int[] ans = new int[n];
        //iterate over each ball first
        OUTER: for(int j=0; j<n; j++) {
            int c = j, r = 0;
            while(r < m) {

                //ball rolls into left edge
                if(c==0 && grid[r][c]== -1) {
                    ans[j] = -1;
                    continue OUTER;
                }

                //ball rolls into right edge
                if(c==n-1 && grid[r][c]== 1) {
                    ans[j] = -1;
                    continue OUTER;
                }

                //ball rolls into another corner
                if(grid[r][c]==  1 && grid[r][c+1]== -1) {
                    ans[j] = -1;
                    continue OUTER;
                }
                if(grid[r][c]== -1 && grid[r][c-1]==  1) {
                    ans[j] = -1;
                    continue OUTER;
                }

                //ball rolls unimpeded
                if(grid[r][c]== 1) c++;
                else if(grid[r][c]== -1) c--;
                r++;

            }

            ans[j] = c;

        }

        return ans;
    }
}
