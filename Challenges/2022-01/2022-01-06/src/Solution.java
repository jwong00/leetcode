import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
//        System.out.println(s.carPooling(new int[][]{{2,1,5},{3,3,7}},4));
//        System.out.println(s.carPooling(new int[][]{{2,1,5},{3,3,7}},5));
        System.out.println(s.carPooling(new int[][]{{2,2,6},{2,4,7},{8,6,7}},11));
    }
    public boolean carPooling(int[][] trips, int capacity) {
        if(trips==null || trips.length==0) return false;

        //create prio queue with custom comparator
        PriorityQueue<int[]> events = new PriorityQueue<>(2*trips.length, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                //if sz > 2, throw error?
                //else...
                if(a[0]==b[0]) {
                    if(a[1]==b[1]) return 0;
                    else if(a[1]<b[1]) return -1;
                    else return 1;
                }
                else if(a[0] < b[0]) return -1;
                else return 1;
            }
        });

        //sort trips into pq
        for(int[] t : trips) {
            events.add(new int[]{t[1],t[0]});
            events.add(new int[]{t[2],-1*t[0]});
        }

        //process again, if capacity is exceeded, return false
        int p_count = 0;
        while(!events.isEmpty()) {
            int[] e = events.poll();
            System.out.println(Arrays.toString(e));
            p_count += e[1];
            System.out.println(p_count);
            if(p_count>capacity) return false;
        }
        return true;

    }
}
