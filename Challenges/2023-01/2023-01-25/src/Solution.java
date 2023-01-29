import java.util.ArrayDeque;
import java.util.Arrays;

class Solution {
    public int bfs(int startNode, int[] edges, int[] dist) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[edges.length];

        Arrays.fill(visited,false);

        queue.offer(startNode);
        dist[startNode] = 0;

        while(!queue.isEmpty()) {
            int node = queue.poll();
            if(!visited[node]) {
                visited[node] = true;
                int neighbor = edges[node];
                if(neighbor > -1 && !visited[neighbor]) {
                    dist[neighbor] = 1 + dist[node];
                    queue.offer(neighbor);
                }
            }
        }
    }
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        int[] dist1 = new int[n];
        int[] dist2 = new int[n];

        Arrays.fill(dist1,Integer.MAX_VALUE);
        Arrays.fill(dist2,Integer.MAX_VALUE);

        int minDist = -1, minDistTilNow = Integer.MAX_VALUE;

        for(int i=0;i<n;i++) {

        }
    }
//    public int closestMeetingNode(int[] edges, int node1, int node2) {
//
//        int[] distFromNode1 = new int[edges.length];
//        Arrays.fill(distFromNode1,-1);
//        int dist = 0, node = node1;
//        while(edges[node]!=-1) {
//            distFromNode1[node] = dist;
//            node = edges[node];
//            dist++;
//        }
//        distFromNode1[node] = dist;
//
//        int[] distFromNode2 = new int[edges.length];
//        Arrays.fill(distFromNode2,-1);
//        dist = 0; node = node2;
//        while(edges[node]!=-1) {
//            distFromNode2[node] = dist;
//            node = edges[node];
//            dist++;
//        }
//        distFromNode2[node] = dist;
//
////        System.out.println(Arrays.toString(distFromNode1));
////        System.out.println(Arrays.toString(distFromNode2));
//
//        int min = Integer.MAX_VALUE;
//        int ans = -1;
//        for(int i=0;i<edges.length;i++) {
//            if(distFromNode1[i] >= 0 && distFromNode2[i] >= 0) {
//                int newMin = Math.min(min,Math.max(distFromNode1[i],distFromNode2[i]));
//                if(newMin<min) {
//                    min = newMin;
//                    ans = i;
//                }
//            }
//        }
//
//        return ans;
//    }

}
