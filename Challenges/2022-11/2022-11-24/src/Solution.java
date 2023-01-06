class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.exist(new char[][]{{'S','E'},{'E','A'}},"SEE"));
    }
    public boolean exist(char[][] board, String word) {
        if(board==null || board.length==0 || board[0].length==0) return false;
        int m = board.length, n = board[0].length;

        boolean[][] visited = new boolean[m][n];
        boolean ans = false;

        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(board[i][j]==word.charAt(0) && dfs(board,word,visited,0,i,m,j,n)) return true;
            }
        }

        return false;
    }

    //for performing a depth-first search for the next character of the word
    public boolean dfs(char[][] board, String word, boolean[][] visited, int index, int i, int m, int j, int n) {
        //bounds check
        if(i >= m || j >= n || i < 0 || j < 0) return false;

        if(visited[i][j]) return false;
        if(board[i][j]!=word.charAt(index)) return false;
        if(index==word.length()-1) return true;
        visited[i][j] = true;

        boolean ans =   dfs(board, word, visited,index+1,i+1,m,j,n) ||
                        dfs(board, word, visited,index+1,i-1,m,j,n) ||
                        dfs(board, word, visited,index+1,i,m,j+1,n) ||
                        dfs(board, word, visited,index+1,i,m,j-1,n);

        //clean up the visited map
        visited[i][j] = false;

        return ans;
    }
}
