import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Glamdring on 1/30/2017.
 */

/* Inverse of problem: robot moves from m-1, n-1 towards 0,0
 * and can only move up or left.
 *
 * */

public class Solution {
    int[][] paths;
    int M = 100, N=100;

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.uniquePaths(2, 2));
        System.out.println(s.uniquePaths(3, 2));
        System.out.println(s.uniquePaths(2, 3));
        System.out.println(s.uniquePaths(1, 1));
        System.out.println(s.uniquePaths(4, 4));
        s.printPaths();
    }

    public Solution() {
        paths = new int[M][N];
    }
    public int uniquePaths(int m, int n) {
        if(m<1||n<1) return 0;
        else return pathsAt(m-1,n-1);
    }
    public int pathsAt(int m, int n) { //return paths from loc m,n
        if(m==0||n==0) return paths[m][n]=1; //robot can't go there
        else if (paths[m][n]!=0) return paths[m][n]; //if soln, return it
        else if (paths[n][m]!=0) return paths[m][n]=paths[n][m];
        else return paths[m][n] = pathsAt(m-1,n) + pathsAt(m,n-1);
    }
    public void printPaths() {
        for(int i=0;i<M;i++) {
            for (int j = 0; j < N; j++) {
                System.out.printf("%03d ",paths[i][j]);
            }
            System.out.println("");
        }
    }
}
