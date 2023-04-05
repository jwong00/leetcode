import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public int minReorder(int n, int[][] connections) {
        //build an adjacency table representation
        HashMap<Integer,HashSet<Integer>> adj = new HashMap<>();

        //this is for a "reverse adj table"
        HashMap<Integer,HashSet<Integer>> neighborsOf = new HashMap<>();
        for(int[] connection : connections) {
            //a connection is an edge from a->b
            HashSet<Integer> neighbors = adj.getOrDefault(connection[0],new HashSet<>());
            neighbors.add(connection[1]);
            adj.put(connection[0],neighbors);

            //variable re-use safe?
            //this maps b to all the values (a) that point to b
            neighbors = neighborsOf.getOrDefault(connection[1],new HashSet<>());
            neighbors.add(connection[0]);
            neighborsOf.put(connection[1],neighbors);

        }
        //start at node 0
        //find edges that need to be reversed

    }
}
