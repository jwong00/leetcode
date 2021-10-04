import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.deepToString(s.kClosest(new int[][] {{1,3},{-2,2}},1)));
        System.out.println(Arrays.deepToString(s.kClosest(new int[][] {{3,3},{5,-1},{-2,4}},2)));
    }

    class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x=x;
            this.y=y;
        }

        public int distFromOrigin() {
            return (x*x) + (y*y);
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Point> minHeap= new PriorityQueue<>(
                (p1,p2) -> p1.distFromOrigin() - p2.distFromOrigin());

        for(int i=0;i<points.length;i++) {
            minHeap.add(new Point(points[i][0],points[i][1]));
        }

        int[][] closest = new int[k][2];

        for(int j=0;j<k;j++) {
            Point p = minHeap.poll();
            closest[j][0] = p.x;
            closest[j][1] = p.y;
        }

        return closest;
    }
}
