class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.exist(new char[][] {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}},"ABCCED"));
        System.out.println(s.exist(new char[][] {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}},"SEE"));
    }
    public boolean exist(char[][] board, String word) {
        if(board==null) return false;

        int m = board.length, n = board[0].length;

        boolean ans = false;

        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                ans |= bfs(board,word,0,i,j,m,n);
            }
        }
//        return bfs(board, word, 0,0,0,m,n);
        return ans;
    }

    public boolean bfs(char[][] board, String word, int index, int row, int col, int h, int w) {
        if(index >= word.length()) return true;

        if(row < 0 || col < 0 || row >= h || col >= w) return false;

        char c = word.charAt(index);

        if(board[row][col] == c) {
            return  bfs(board,word,index+1,row-1,col,h,w) ||
                    bfs(board,word,index+1,row,col-1,h,w) ||
                    bfs(board,word,index+1,row+1,col,h,w) ||
                    bfs(board,word,index+1,row,col+1,h,w);
        }
//        else {
//
//            return  bfs(board,word,index,row-1,col,h,w) ||
//                    bfs(board,word,index,row,col-1,h,w) ||
//                    bfs(board,word,index,row+1,col,h,w) ||
//                    bfs(board,word,index,row,col+1,h,w);
//        }

        return false;

    }
}
