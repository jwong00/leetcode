import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] k = {{}};
        s.rotate(k);
        int[][] r = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        s.rotate(r);
        System.out.println(Arrays.deepToString(r));
        int[][] y = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
        };
        s.rotate(y);
        System.out.println(Arrays.deepToString(y));
        int[][] q = { {1} };
//        s.rotate(q);
    }

    public void rotate(int [][] matrix) {
        if(matrix.length==0) return;
        else for(int i=0; i<matrix.length; i++) {
            if(matrix[i].length==0) return;
        }

        int buffer;

        for(int i = 0,ringLength=matrix.length; i<matrix.length/2; i++,ringLength-=2) {
            /*
            * nw=[i][i+k]
            * sw=[i+ringLength-1-k][i]
            * se=[i+ringLength-1][i+ringLength-1-k]
            * ne=[i+k][i+ringLength-1]
            * */
            System.out.printf("RING NUMBER %d\n",i);
            for(int k=0; k<ringLength-1; k++) {
//                System.out.println(k);
                buffer=matrix[i][i+k];
//                System.out.println(buffer);
//                System.out.printf("%d %d %d %d\n",matrix[i][i+k], matrix[i+ringLength-1-k][i], matrix[i+ringLength-1][i+ringLength-1-k], matrix[i+k][i+ringLength-1]);
                matrix[i][i+k]=matrix[i+ringLength-1-k][i]; //NW=SW
                matrix[i+ringLength-1-k][i]=matrix[i+ringLength-1][i+ringLength-1-k]; //SW=SE
                matrix[i+ringLength-1][i+ringLength-1-k]=matrix[i+k][i+ringLength-1]; //SE=NE
                matrix[i+k][i+ringLength-1]=buffer; //NE=NW (from buffer)

            }
        }
    }

    public void mirror(int[][] matrix) {
        if(matrix.length==0) return;
        else for(int i=0; i<matrix.length;i++) {
            if(matrix[i].length==0) return;
        }

        int buffer;
        for(int i = 0; i<matrix.length;i++ ) {
            for(int j = 0; j<i; j++) {
                if(i==j) break;
                buffer = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i]=buffer;
            }
        }
    }
}
