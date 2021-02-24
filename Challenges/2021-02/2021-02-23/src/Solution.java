import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] t = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        System.out.println(s.searchMatrix(t,5));

        int[][] r = {{1},{1}};
        System.out.println(s.searchMatrix(r,0));



    }
    public boolean searchMatrix(int[][] matrix, int target) {
        System.out.println("Searching for "+target+" in: ");
        System.out.println(Arrays.deepToString(matrix));
        return search(matrix,0,0,target);
    }


    //initiates a recursive search on location x,y
    public boolean search(int[][] m, int x, int y, int target) {
        System.out.printf("Searching m[%d][%d]==%d for %d\n",x,y,m[x][y],target);

        if(m[x][y]==target) return true;

        //if all immediate neighbors are bigger than target, return false
        if(x+1<m.length && y+1 < m[0].length &&
                m[x+1][y]>target && m[x][y+1]>target && m[x+1][y+1]>target) return false;

//        //edges
//        if(x==m[0].length-1 && y < m.length-1) search(m,x,y+1,target);
//        if(x < m[0].length-1 && y==m.length-1) search(m,x+1,y,target);


        //choose where to search next and store result for later return
        boolean result = false;
        if(x<m.length && y+1<m[0].length && m[x][y+1]<=target) result |= search(m,x,y+1,target);
        if(x+1<m.length && y<m[0].length && !result && m[x+1][y]<=target) result |= search(m,x+1,y,target);

        return result;

    }
}
