import java.util.ArrayDeque;
import java.util.ArrayList;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.findMinArrowShots(new int[][]{{10,16},{2,8},{1,6},{7,12}}));
        System.out.println(s.findMinArrowShots(new int[][]{{1,2},{3,4},{5,6},{7,8}}));
        System.out.println(s.findMinArrowShots(new int[][]{{1,2},{2,3},{3,4},{4,5}}));
    }
    public int findMinArrowShots(int[][] points) {
        //store all points in resizable structure
        ArrayDeque<int[]> intervals = new ArrayDeque<>();
        for(int[] interval : points) {
            intervals.offer(interval);
        }

        //dequeue a point and process it:
        //compare to rest of queue
        //find intersections
        //update intersections during loop

        int ans = 0;

        while(!intervals.isEmpty()) {
            int[] a = intervals.poll();
            for(int i=0;i<intervals.size();i++) {
                int[] b = intervals.poll();
                int[] c = intersect(a,b);
                if(c!=null) a=c;
                else intervals.offer(b); //put it back so it can be shot later

            }
            ans++;
        }

        return ans;
    }

    //finds the intersection of both points
    public int[] intersect(int[] a, int[] b) {
        if(b[1] < a[0] || a[1] < b[0]) return null; //there is no intersection
        return new int[]{Math.max(a[0],b[0]),Math.min(a[1],b[1])};
    }
}