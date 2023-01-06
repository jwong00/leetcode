import java.util.HashSet;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isValidSudoku(new char[][] {{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}}));
        System.out.println(s.isValidSudoku(new char[][]
                {       {'.','.','.','.','.','.','.','.','.'},
                        {'4','.','.','.','.','.','.','.','.'},
                        {'.','.','.','.','.','.','6','.','.'},
                        {'.','.','.','3','8','.','.','.','.'},
                        {'.','5','.','.','.','6','.','.','1'},
                        {'8','.','.','.','.','.','.','6','.'},
                        {'.','.','.','.','.','.','.','.','.'},
                        {'.','.','7','.','9','.','.','.','.'},
                        {'.','.','.','6','.','.','.','.','.'}}));
    }
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character> set;
        for(int r=0;r<9;r++) {
            set = new HashSet<>();
            for(int c=0;c<9;c++) {
                if(Character.isDigit(board[r][c])) {
                    if(set.contains(board[r][c])) {
                        return false;
                    }
                    else set.add(board[r][c]);
                }
            }
        }
        for(int c=0;c<9;c++) {
            set = new HashSet<>();
            for(int r=0;r<9;r++) {
                if(Character.isDigit(board[r][c])) {
                    if (set.contains(board[r][c])) {
                        return false;
                    }
                    else set.add(board[r][c]);
                }
            }
        }
        //iterate over top left corners of 3x3 subsections
        for(int i=0;i<9;i+=3) {
            for(int j=0;j<9;j+=3) {
                set = new HashSet<>();
                for(int r=0;r<3;r++) {
                    for(int c=0;c<3;c++) {
                        if(Character.isDigit(board[i+r][j+c])) {
                            if (set.contains(board[i+r][j+c])) {
                                System.out.println(board[i+r][j+c]);
                                return false;
                            }
                            else set.add(board[i+r][j+c]);
                        }
                    }
                }
            }
        }
        return true;
    }
}
