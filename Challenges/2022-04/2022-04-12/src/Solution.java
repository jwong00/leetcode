import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] board = {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        System.out.println(Arrays.deepToString(board));
        s.gameOfLife(board);
        System.out.println(Arrays.deepToString(board));
    }
    public void gameOfLife(int[][] board) {
        if(board==null || board.length==0 || board[0].length==0) return;

        int m = board.length, n = board[0].length;

        int[][] next = new int[m][n];

        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                next[i][j] = next(board,m,n,i,j);
            }
        }

        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                board[i][j] = next[i][j];
            }
        }


    }

    private int next(int[][] board, int m, int n, int i, int j) {
        int n_dead = 0;
        int n_live = 0;

        for(int a=-1;a<=1;a++) {
            for(int b=-1;b<=1;b++) {
                if(0 <= i + a && i + a < m && 0 <= j + b && j + b < n && (a!=0 ^ b!=0)) {

                    System.out.println(i+a+","+(j+b));
                    if(board[i+a][j+b]==0) n_dead++;
                    if(board[i+a][j+b]==1) n_live++;
                }
            }
        }

        System.out.println("FOR "+board[i][j]+" "+i+" "+j);
        System.out.println(n_live);
        if(board[i][j]==1) {

            if(n_live<2) return 0;
            else if(n_live==2 || n_live==3) return 1;
            else  if(n_live>3) return 0;

        }
        else if(board[i][j]==0) {
            if(n_live==3) return 1;
        }
        return board[i][j];

    }
}
