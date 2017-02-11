import java.util.ArrayList;
import java.util.List;

/**
 * Created by Glamdring on 2/9/2017.
 */
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        ArrayList h = new ArrayList<Interval>();
        h.add(new Interval(0,2));
        h.add(new Interval(7,9));
        h.add(new Interval(8,11));
        h.add(new Interval(1,3));
        h.add(new Interval(3,6));
//        h.add(new Interval());+
        System.out.println(s.merge(h));

    }
    public List<Interval> merge(List<Interval> intervals) {
//        List<Interval> intervalList = new ArrayList<Interval>();
        if(intervals.size()<2) return intervals;

        Interval pre = intervals.get(0);
        Interval cur;

        /* Cases
         * 1. ending of either interval overlaps start of another interval
         * 2. one interval contains second interval
         * 3. intervals are disjoint (no merging)
         * */

        int i=0,j=0;
        while(i <= intervals.size()-1) {
            pre = intervals.get(i);
            j=i+1;
            while(j<=intervals.size()-1) {
                cur = intervals.get(j);
                if (pre.end >= cur.start && cur.end >= pre.start) {
                    pre.start = Math.min(pre.start, cur.start);
                    pre.end = Math.max(pre.end, cur.end);
                    intervals.remove(j);
                } else j++; //increment only if not removed
            }
            i++;
        }

        return intervals;
    }
}
