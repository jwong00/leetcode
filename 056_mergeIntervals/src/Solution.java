import java.lang.reflect.Array;
import java.util.*;

public class Solution {

    public static void main(String args[]) {
        int[][] case1 = {{1,3},{2,6},{8,10},{15,18}};
        int[][] case2 = {{0,2},{5,10},{11,13},{15,16},{6,10}};

        Solution s = new Solution();
        System.out.println(Arrays.deepToString(s.merge(case1)));

        System.out.println(Arrays.deepToString(s.merge(case2)));

    }
    public int[][] merge(int[][] intervals) {
        LinkedList<int[]> merged = new LinkedList<>();

        //sort intervals here:

        //

        int left = 0; //tracks the left-most interval of the set of intervals to return

        System.out.println("Printing array to merge...");
        System.out.println(Arrays.deepToString(intervals));

        System.out.println("Merging...");
        for(int i=0; i<intervals.length;i++) {
            if(merged.isEmpty() || merged.getLast()[1] < intervals[i][0]) {
                merged.add(intervals[i]);
            }
            else {
                merged.set(merged.indexOf(merged.getLast()),merge(merged.getLast(),intervals[i]));
            }
        }
        System.out.println("Done merging...");
        System.out.println(Arrays.deepToString(merged.toArray()));
        int[][] k = new int[merged.size()][2];
        return k;

//        return Arrays.copyOfRange(intervals,left,intervals.length);
    }

    //"low-level" merge for two intervals
    private int[] merge(int[] interval1, int[] interval2) {
        int[] interval = new int[2];
        interval[0] = Math.min(interval1[0],interval2[0]);
        interval[1] = Math.max(interval1[1],interval2[1]);
        return interval;

    }

    public boolean overlap(int[] interval1, int[] interval2) {
        //mutual exclusion
        if(interval1[1] < interval2[0]) return false;
        else if(interval2[1] < interval1[0]) return false;
        //interval 1 within interval 2
        else if(interval1[0] <= interval2[1] && interval1[0] >=interval2[0]) return true;
        else if(interval1[1] <= interval2[1] && interval1[1] >=interval2[0]) return true;
        //interval 2 within interval 1
        else if(interval2[0] <= interval1[1] && interval2[0] >=interval1[0]) return true;
        else if(interval2[1] <= interval1[1] && interval2[1] >=interval1[0]) return true;
        else return false;
    }

}
