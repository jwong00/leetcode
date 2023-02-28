import java.util.*;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.shortestAlternatingPaths(3,new int[][]{{0,1},{1,2}},new int[][]{})));
        System.out.println(Arrays.toString(s.shortestAlternatingPaths(3,new int[][]{{0,1}},new int[][]{{2,1}})));
    }
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        //constants
        int NONE = 0;
        int RED =  1;
        int BLUE = 2;
        int[][] pathColors = new int[n][n];
        HashMap<Integer, ArrayList<Integer>> adj = new HashMap<Integer, ArrayList<Integer>>();

        for(int[] edge : redEdges ) {
            pathColors[edge[0]][edge[1]] = RED;
            ArrayList<Integer> neighbors = adj.getOrDefault(edge[0],new ArrayList<Integer>());
            neighbors.add(edge[1]);
            adj.put(edge[0],neighbors);
        }
        for(int[] edge : blueEdges) {
            pathColors[edge[0]][edge[1]] = BLUE;
            ArrayList<Integer> neighbors = adj.getOrDefault(edge[0],new ArrayList<Integer>());
            neighbors.add(edge[1]);
            adj.put(edge[0],neighbors);
        }

        int[] dist = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[0] = 0;

        HashSet<Integer> visited = new HashSet<>();
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        //enqueue the vertex with the color of the edge leading to that vertex
        //use to compare with next edge
        //reject vertex (do not enqueue) if the colors are the same
        //example: vertex 0 has no predecessor, so offer [0,NONE]
        queue.offer(new int[]{0,NONE});
        while(!queue.isEmpty()) {
            int[] u = queue.poll();
            visited.add(u[0]);
            if(adj.get(u[0])==null) break;
            for(int v : adj.get(u[0])) {
                if(u[1]==pathColors[u[0]][v]) continue;
                if(visited.contains(v)) continue;
                dist[v] = Math.min(dist[v],dist[u[0]] + 1);
                queue.offer(new int[]{v,pathColors[u[0]][v]});
            }
        }

        for(int i=0;i<n;i++) {
            if(!visited.contains(i)) dist[i] = -1;
        }

        return dist;
    }
}
