import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.maxCount(3,3,
                new int[][] {{2,2},{3,3},{3,3},{3,3},{2,2},{3,3},{3,3},{3,3},{2,2},{3,3},{3,3},{3,3}}));

        System.out.println(s.maxCount(3,3,new int[][] {{2,3},{3,1}}));

    }
    public int maxCount(int m, int n, int[][] ops) {
//        int min_x = m, min_y = n;
        for(int i=0;i<ops.length;i++) {
            m = Math.min(m,ops[i][0]);
            n = Math.min(n,ops[i][1]);
        }

        return m*n;

//        int[][] count = new int[m+1][n+1];



//        for(int i=0;i<ops.length;i++) {
//            count[ops[i][0]][ops[i][1]]++;
//        }
//
//        System.out.println(Arrays.deepToString(count));
//
//        int topmost = m;
//
//        topmost_search:
//        for(int u=0;u<m+1;u++) {
//            for(int v=0;v<n+1;v++) {
//                if(count[u][v]>0) {
//                    topmost=u;
//                    break topmost_search;
//                }
//            }
//        }
//
//        int leftmost = n;
//        leftmost_search:
//        for(int v=0;v<n+1;v++) {
//            for(int u=0;u<m+1;u++) {
//                if(count[u][v]>0) {
//                    leftmost=v;
//                    break leftmost_search;
//                }
//            }
//        }
//
//        return topmost*leftmost;

    }
}
