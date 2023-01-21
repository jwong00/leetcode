import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

class Solution {
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        //build adj table
        HashMap<Integer, List<Integer>> adj = new HashMap<>();
        for(int[] edge : edges) {
            int a = edge[0], b = edge[1];
            adj.computeIfAbsent(a,v->new ArrayList<Integer>()).add(b);
            adj.computeIfAbsent(b,v->new ArrayList<Integer>()).add(a);
        }

        //perform bfs
    }
}
