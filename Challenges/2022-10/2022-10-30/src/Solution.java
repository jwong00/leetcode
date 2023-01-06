class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isToeplitzMatrix(new int[][]{{1,2,3,4},{5,1,2,3},{9,5,1,2}}));
        System.out.println(s.isToeplitzMatrix(new int[][]{{1,2},{2,2}}));
    }
    public boolean isToeplitzMatrix(int[][] matrix) {
        if(matrix==null) return false;
        int m = matrix.length, n = matrix[0].length;

        for(int i=1;i<m;i++) {
            for(int j=1;j<n;j++) {
                if(matrix[i-1][j-1]!=matrix[i][j]) return false;
            }
        }
        return true;
    }
}
