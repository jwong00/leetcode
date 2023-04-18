import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

class Solution {

    boolean[] visited;
//    HashMap<Integer,HashSet<Integer>> adj;
    ArrayList<Integer>[] adj;
    int max;
    HashMap<Character,Integer> freq;
    String colors;

    public int largestPathValue(String colors, int[][] edges) {

        this.colors = colors;
        int n = colors.length();
        max = Integer.MIN_VALUE;

        //count the colors!
        freq = new HashMap<>();

        for(int i=0;i<n;i++) {

            char color = colors.charAt(i);

            if(!freq.containsKey(color))
                freq.put(color,0);

        }

        //build adj table:
        adj = new ArrayList[n];

        //for each edge (u,v) in edges
        for(int[] edge : edges) {

            if(adj[edge[0]]==null) {
                adj[edge[0]] = new ArrayList<Integer>();
            }

            //blindly assuming no dupe edges
            adj[edge[0]].add(edge[1]);

        }

        //init visited
        visited = new boolean[colors.length()];

        //visit every unvisited node
        for(int i=0;i<n;i++) {

            //otherwise will return -1 here
            if(!visited[i]) dfs(i);


        }

    }

    //begin a recursive dfs traversal from node with provided key
    private int dfs(int key) {
        if(visited[key]) return -1;

        visited[key] = true;

        //incr freq of cur key's color
        char color = colors.charAt(key);
        freq.put(color,freq.getOrDefault(color,0)+1);

        //test for new max? maybe can save for end of a path, e.g. no neighbors?
        max = Math.max(max,freq.get(color));

        //traverse each neighbor
        for(int neighbor : adj[key]) {
            dfs(neighbor);
        }

        //decr freq of cur key's color
        freq.put(color,freq.getOrDefault(color,0)-1);

        visited[key] = false;
    }
}
