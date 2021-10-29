import java.util.ArrayDeque;
import java.util.Deque;

class Solution {

    static final int EMPTY = 0;
    static final int FRESH = 1;
    static final int ROTTEN = 2;
    static final int VISITED = 3; //implies ROTTEN and already PROCESSED
    static final int[][] directions = {{-1,0},{0,-1},{1,0},{0,1}};

    public int orangesRotting(int[][] grid) {
        if(grid==null || grid.length==0 || grid[0].length==0) return 0;

        int m = grid.length, n = grid[0].length;

        int count_fresh=0,count_rotten=0,count_rotten_old=0;

        //store "coordinate" of rotten fruits
        Deque<int[]> rotten_idx = new ArrayDeque<>();

        //count fresh/rotten fruits, and init cache of rotten fruit indices
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(grid[i][j]==ROTTEN) {
                    if(grid[i][j]==ROTTEN) rotten_idx.offer(new int[]{i,j});
//                    count_rotten++;
                }
                else if(grid[i][j]==FRESH) count_fresh++;
            }
        }

        int time = 0;
//        count_rotten = rotten_idx.size();

        //one iteration represents one minute
        while(count_fresh > 0) {

            //store current size of cache, this is how many rotten fruits
            //are present at the current minute
            int counter = rotten_idx.size();

            //search rotten fruit to find adjacent fresh fruits
            while(!rotten_idx.isEmpty() && counter > 0) {

                //count_rotten-count_rotten_old should never be 0, if so,
                //we never make it to the next line anyway:

                //get a ROTTEN fruit
                int[] cur_fruit = rotten_idx.poll();
                counter--;

                //count it
                count_rotten++;

                //process four-directionally from the current (ROTTEN) fruit
                for(int[] direction : directions) {
                    int x = cur_fruit[0]+direction[0];
                    int y = cur_fruit[1]+direction[1];

                    //bounds check
                    if(x<0 || x>=m) continue;
                    if(y<0 || y>=n) continue;

                    //ROT if FRESH then enqueue newly ROTTEN fruit
                    if(grid[x][y]==FRESH) {
                        grid[x][y] = ROTTEN;
                        rotten_idx.offer(new int[]{x,y});
                    }
                }

            }

            //terminate early if number of rotten fruits isn't changing after the minute
            if(count_rotten==count_rotten_old) return time;

            //if not, current number becomes old for next iteration
            //and we increment the number of minutes successfully elapsed
            count_rotten_old = count_rotten;
            time++;
        }

        return time;
    }
}
