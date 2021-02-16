/*
 *  Constraints:
 *
 *  m == mat.length
 *  n == mat[i].length
 *  2 <= n, m <= 100
 *  1 <= k <= m
 *  matrix[i][j] is either 0 or 1.
 */

import java.util.*;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] g = {   {1,1,0,0,0},
                        {1,1,1,1,0},
                        {1,0,0,0,0},
                        {1,1,0,0,0},
                        {1,1,1,1,1}
                    };

        s.kWeakestRows(g,3);
    }
    public int[] kWeakestRows(int[][] mat, int k) {
        Hashtable<Integer,Integer> soldierCount = new Hashtable<>();

        for(int i=0;i<mat.length;i++) {
            for(int j=0;j<=mat[i].length;j++) {
                if(j==mat[i].length || mat[i][j]==0) {
                    soldierCount.put(i,j);
                    break;
                }
            }
        }


        //Transfer as List and sort it
        ArrayList<Map.Entry<?, Integer>> l = new ArrayList(soldierCount.entrySet());
        Collections.sort(l, new Comparator<Map.Entry<?, Integer>>(){

            public int compare(Map.Entry<?, Integer> o1, Map.Entry<?, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }});

        System.out.println(soldierCount.entrySet().toString());

        int[] weakest = new int[k];
        for(int i=0;i<k;i++) {
            weakest[i]= (int) l.get(i).getKey();
        }
        System.out.println(l.toString());
        System.out.println(Arrays.toString(weakest));
        return weakest;
    }
}
