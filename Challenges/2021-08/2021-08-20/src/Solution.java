import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.isValidSudoku(null);
    }
    public boolean isValidSudoku(char[][] board) {


        //pre-process for convenience
        //probably costs 1ms runtime on the LC grader
        int[][] sudoku = new int[9][9];

        for(int i=0;i<9;i++) {
            for(int j=0;j<9;j++) {
                if(board[i][j]=='.') sudoku[i][j] = -1;
                else sudoku[i][j] = board[i][j]-'0';
            }
        }

        //validate by row
        for(int i=0;i<9;i++) {
            boolean[] row = new boolean[10];
            for(int j=0;j<9;j++) {
                if(sudoku[i][j]>0) {
                    if(row[sudoku[i][j]]) return false;
                    else row[sudoku[i][j]] = true;
                }
            }
        }

        //validate by col
        for(int j=0;j<9;j++) {
            boolean[] col = new boolean[10];
            for(int i=0;i<9;i++) {
                if(sudoku[i][j]>0) {
                    if(col[sudoku[i][j]]) return false;
                    else col[sudoku[i][j]] = true;
                }
            }
        }


        //validate by subsection (3x3 square)
        for(int i=0;i<3;i++) {
            for(int j=0;j<3;j++) {

                boolean[] sub = new boolean[10];

                for(int m = 3*i;m<3*i+3;m++) {
                    for(int n = 3*j;n<3*j+3;n++) {
                        if(sudoku[m][n]>0) {
                            if(sub[sudoku[m][n]]) return false;
                            else sub[sudoku[m][n]] = true;
                        }
                    }
                }
            }
        }

        return true;
    }
}
