import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.deepToString(s.insert(new int[][]{{1, 3}, {6, 9}}, new int[]{2, 5})));

        System.out.println(Arrays.deepToString(s.insert(new int[][]{{1,2},{3,4},{6,7},{8,10},{12,16}}, new int[]{4,8})));


    }
    public boolean intersects(int[] a, int[] b) {
        return (b[0]<=a[0] && a[0]<=b[1]) || (b[0]<=a[1] && a[1]<=b[1]);
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {

        ArrayList<int[]> cache = new ArrayList<>();
        cache.addAll(Arrays.asList(intervals));

        int l=0,r=intervals.length-1,m=(r-l)/2;

        //find leftmost interval that might intersect newInterval
        //if it doesn't intersect, the one after it should
        while(l<r) {

            if(cache.get(m)[0]<newInterval[0]) {
                l = m + 1;
            }
            else if(newInterval[0]<cache.get(m)[0]) {
                r = m - 1;
            }
            else {
                System.out.println("ERROR");
            }

            m = (l+r)/2;
        }

        //attempt merge at m;
        System.out.println("Insert "+ Arrays.toString(newInterval) + " at "+m);
        for(int i=m;i<cache.size();i++) {
            if(intersects(cache.get(i),newInterval)) System.out.println("INTERSECT AT "+i);
            //early ret

        }


        //return ArrayList as Array
        intervals = new int[cache.size()][];
        for(int i=0;i<cache.size();i++) {
            intervals[i] = cache.get(i);
        }

        return intervals;

    }
}
