import java.util.*;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.validPath(3,new int[][]{{0,1},{1,2},{2,0}},0,2));
    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        //build adjacency table
        Map<Integer, HashSet<Integer>> adj = new HashMap<>();

        for(int[] edge : edges) {
            HashSet<Integer> nodes = adj.getOrDefault(edge[0],new HashSet<Integer>());
            nodes.add(edge[1]);

            nodes = adj.getOrDefault(edge[1],new HashSet<Integer>());
            nodes.add(edge[0]);

        }

        //bfs
        Deque<Integer> q = new ArrayDeque<>();
        q.add(source);

        HashSet<Integer> visited = new HashSet<>();

        while(!q.isEmpty()) {
            int u = q.poll();
            visited.add(u);
            HashSet<Integer> nodes = adj.getOrDefault(u,new HashSet<>());
            for(int node : nodes) {
                if(node==destination) return true;
                if(visited.contains(node)) continue;
                q.offer(node);
            }
        }

        return false;
    }
}
