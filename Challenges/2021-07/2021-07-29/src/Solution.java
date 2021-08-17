import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.updateMatrix(new int[][]{{0,0,0},{0,1,0},{1,1,1}});
    }

    /*
        A L G O

            1. USE BFS: maintain a queue of cells to be processed
            2. Begin by adding cells with 0's to the queue
            3. Initial dist for a 0-cell is 0, and initial dist for a 1-cell is INT_MAX
            4. Dequeue cell from queue, and process neighbors.
            5. If new distance for neighbor [i,j] is smaller, add [i,j] to q and update dist[i][j]

    */

    public int[][] updateMatrix(int[][] mat) {

        int m = mat.length,n=mat[0].length;

        Deque<int[]> q = new ArrayDeque<>();
        int[][] dist = new int[m][n];

        for(int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] != 0) dist[i][j] = Integer.MAX_VALUE;
                else {
                    dist[i][j] = 0;
                    q.add(new int[]{i, j});
                }
            }
        }

        int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};

        while(!q.isEmpty()) {
            int[] t = q.pollFirst();

            for( int r = 0; r < 3; r++ ) {
                //get new locations
                int new_row = t[0]+directions[r][0];
                int new_col = t[1]+directions[r][1];
                //check in bounds
                if(new_row>=0 && new_col>=0 && new_row<m && new_col<n) {
                    if(dist[t[0]][t[1]] + 1 < dist[new_row][new_col]) {
                        dist[new_row][new_col] = 1 + dist[t[0]][t[1]];
                        q.offerLast(new int[] {new_row,new_col});
                    }
                }
            }
        }

        return dist;
    }
}
