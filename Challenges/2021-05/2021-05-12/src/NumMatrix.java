class NumMatrix {
    public static void main(String[] args) {
        int[][] n = {   {3, 0, 1, 4, 2},
                        {5, 6, 3, 2, 1},
                        {1, 2, 0, 1, 5},
                        {4, 1, 0, 1, 7},
                        {1, 0, 3, 0, 5}     };


        NumMatrix nm = new NumMatrix(n);
        System.out.println(nm.sumRegion(2,1,4,3));
        System.out.println(nm.sumRegion(1,1,2,2));
        System.out.println(nm.sumRegion(1,2,2,4));
    }
    int[][] matrix;

    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;

        for(int i=row1;i<=row2;i++) {
            for(int j=col1;j<=col2;j++) {
                sum+=matrix[i][j];
            }
        }

        return sum;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
