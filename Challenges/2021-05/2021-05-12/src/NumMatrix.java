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
        if(this.matrix==null) return;

        int h=matrix.length, w=matrix[0].length;
        if(h==0 || w==0) return;


        for(int i=0;i<h;i++) {
            int sum = 0;
            for(int j=0;j<w;j++) {
                matrix[i][j]+=sum;
                sum=matrix[i][j];
            }
        }

        for(int j=0;j<w;j++) {
            int sum = 0;
            for(int i=0;i<h;i++) {
                matrix[i][j]+=sum;
                sum=matrix[i][j];
            }
        }

    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = matrix[row2][col2];

        if(row1>0) sum -= matrix[row1-1][col2];
        if(col1>0) sum -= matrix[row2][col1-1];
        if(row1>0 && col1>0) sum += matrix[row1-1][col1-1];

        return sum;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
