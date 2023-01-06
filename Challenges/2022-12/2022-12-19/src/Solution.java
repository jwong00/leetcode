import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.validPath(3,new int[][]{{0,1},{1,2},{2,0}},0,2));
    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Deque<Integer> q = new ArrayDeque<>();

        HashMap<Integer, HashSet<Integer>> adj = new HashMap<Integer, HashSet<Integer>>();
        for(int[] edge : edges) {
            HashSet<Integer> nodes = adj.getOrDefault(edge[0],new HashSet<>());
            nodes.add(edge[1]);
            adj.put(edge[0],nodes);
            nodes = adj.getOrDefault(edge[1],new HashSet<>());
            nodes.add(edge[0]);
            adj.put(edge[1],nodes);
        }

        boolean[] visited = new boolean[n];
        q.offer(source);
        visited[source] = true;

        while(!q.isEmpty()) {
            if(q.peek()==destination) return true;
            HashSet<Integer> neighbors = adj.get(q.poll());
            for(int neighbor : neighbors) {
                if(!visited[neighbor]) {
                    q.offer(neighbor);
                    visited[neighbor] = true;
                }
            }
        }
        return false;
    }
}