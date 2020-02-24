import java.lang.reflect.Array;
import java.util.*;

public class Solution {
    Boolean DEBUG = true;

    public static void main(String args[]) {
        int[][] case1 = {{1,3},{2,6},{8,10},{15,18}};
        int[][] case2 = {{0,2},{5,10},{77,78},{15,16},{6,12}};

        Solution s = new Solution();
        System.out.println(Arrays.deepToString(s.merge(case1)));

        System.out.println(Arrays.deepToString(s.merge(case2)));

    }
    public int[][] merge(int[][] intervals) {
        if(intervals==null) return null;
        if(intervals.length <= 1) return intervals;



        if(DEBUG) {
            System.out.println("START");
            System.out.println("Printing array to merge (unsorted)...");
            System.out.println(Arrays.deepToString(intervals));
        }

        //sort intervals here:
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        //

        int left = 0; //tracks the left-most interval of the set of intervals to return

        if(DEBUG) {
            System.out.println("Printing array to merge (sorted)...");
            System.out.println(Arrays.deepToString(intervals));
            System.out.println("Merging...");
        }

        LinkedList<int[]> merged = new LinkedList<>();
        merged.add(intervals[0]);
        for(int i=1; i<intervals.length;i++) {
            if(merged.getLast()[1] < intervals[i][0]) {
                merged.add(intervals[i]);
            }
            else {
                merged.set(merged.indexOf(merged.getLast()),merge(merged.getLast(),intervals[i]));
            }
        }

        //copy to return array...
        int[][] mergedOut = new int[merged.size()][];
        merged.toArray(mergedOut);
        //

        if(DEBUG) {
            System.out.println("Done merging...");
            System.out.println(Arrays.deepToString(merged.toArray()));
        }
        int[][] k = new int[merged.size()][2];
        if(DEBUG) {
            System.out.println("END.");
        }
        return mergedOut;

//        return Arrays.copyOfRange(intervals,left,intervals.length);
    }

    //"low-level" merge for two intervals
    private int[] merge(int[] interval1, int[] interval2) {
        int[] interval = new int[2];
        interval[0] = Math.min(interval1[0],interval2[0]);
        interval[1] = Math.max(interval1[1],interval2[1]);
        return interval;

    }
}
