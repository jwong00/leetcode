import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public int minScore(int n, int[][] roads) {
        //build adjacency list representation of graph
        HashMap<Integer,HashSet<Integer>> adj = new HashMap<Integer, HashSet<Integer>>();

        //hash of all roads as edges
        //  (a,b)
        HashMap<int[],Integer> roadmap = new HashMap<>();

        //add all roads
        for(int[] road : roads) {
            //road:
            //  {a,b,dist}
            //  {0,1,   2}
            HashSet<Integer> neighbors_a = adj.getOrDefault(road[0],new HashSet<Integer>());
            neighbors_a.add(road[1]);
            adj.put(road[0],neighbors_a);
            HashSet<Integer> neighbors_b = adj.getOrDefault(road[1],new HashSet<Integer>());
            neighbors_b.add(road[0]);
            adj.put(road[0],neighbors_a);

            roadmap.put(new int[]{road[0],road[1]},road[2]);
            if(road[0]!=road[1]) roadmap.put(new int[]{road[1],road[0]},road[2]);
        }

        //find the minimum edge weight, it is any edge connected to our starting node
        //via any path, as per problem constraint

        int w_min = Integer.MAX_VALUE;

        //starting with 1, since all keys from 1..n are possible
        //enqueue the neighbors of each node
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.offer(1);

        //track visited edges:
        HashSet<int[]> visited = new HashSet<>();

        while(!queue.isEmpty()){
            //deq node

            //queue neighbors of every node currently in the queue
            for(int i=queue.size();!queue.isEmpty() && i>0;i--) {
                int node = queue.poll();

                for(int neighbor : adj.get(node)) {
                    //check if the edge is already visited before enqueueing it for
                    //future processing
                    if(!visited.contains(new int[]{node,neighbor}) &&
                            !visited.contains(new int[]{neighbor,node})) {
                        //check for a new minimum edge
                        w_min = Math.min(w_min,roadmap.get(new int[]{node,neighbor}));
                        queue.offer(neighbor);
                        visited.add(new int[]{node,neighbor});
                    }
                }
            }
        }

        return w_min;
    }
}
