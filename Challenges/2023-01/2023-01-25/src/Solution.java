import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.closestMeetingNode(new int[]{2,2,3,-1},0,1));
        System.out.println(s.closestMeetingNode(new int[]{1,2,-1},0,2));
    }
    public int closestMeetingNode(int[] edges, int node1, int node2) {

        int[] distFromNode1 = new int[edges.length];
        Arrays.fill(distFromNode1,-1);
        int dist = 0, node = node1;
        while(edges[node]!=-1) {
            distFromNode1[node] = dist;
            node = edges[node];
            dist++;
        }
        distFromNode1[node] = dist;

        int[] distFromNode2 = new int[edges.length];
        Arrays.fill(distFromNode2,-1);
        dist = 0; node = node2;
        while(edges[node]!=-1) {
            distFromNode2[node] = dist;
            node = edges[node];
            dist++;
        }
        distFromNode2[node] = dist;

//        System.out.println(Arrays.toString(distFromNode1));
//        System.out.println(Arrays.toString(distFromNode2));

        int min = Integer.MAX_VALUE;
        int ans = -1;
        for(int i=0;i<edges.length;i++) {
            if(distFromNode1[i] >= 0 && distFromNode2[i] >= 0) {
                int newMin = Math.min(min,Math.max(distFromNode1[i],distFromNode2[i]));
                if(newMin<min) {
                    min = newMin;
                    ans = i;
                }
            }
        }

        return ans;
    }
}
