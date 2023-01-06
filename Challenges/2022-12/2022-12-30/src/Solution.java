import java.sql.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.allPathsSourceTarget(new int[][]{{1,2},{3},{3},{}}));
        System.out.println(s.allPathsSourceTarget(new int[][]{{4,3,1},{3,2,4},{3},{4},{}}));
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length;

        List<List<Integer>> paths = new ArrayList<>();

        ArrayList<Integer> path = new ArrayList<>();

        dfs(graph, 0, n, paths, path);

        return paths;

    }

    public void dfs(int[][] graph, int u, int n, List<List<Integer>> paths, List<Integer> path) {
        //end of path
        path.add(u);
        if(u==n-1) paths.add(new ArrayList<Integer>(path));
        for(int v : graph[u]) {
            dfs(graph,v,n,paths,path);
        }
        path.remove(path.size()-1);
    }
}
