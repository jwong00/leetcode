import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.deepToString(s.merge(new int[][]{{2,6},{1,3},{8,10},{15,18}})));
    }
    public int[][] merge(int[][] intervals) {
//        Arrays.sort(intervals);
        Arrays.sort( intervals, (a,b)->Integer.compare(a[0],b[0]) );
        LinkedList<int[]> merged = new LinkedList<>();

        for(int[] interval : intervals) {
            if(merged.isEmpty() || merged.getLast()[1] < interval[0]) merged.add(interval);
            else merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
        }

        return merged.toArray(new int[merged.size()][]);

    }
}
