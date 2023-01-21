import java.sql.Array;
import java.util.*;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        Boolean[] hasApple = {false,false,true,false,true,true,false};

        System.out.println(s.minTime(7,new int[][]{{0,1},{0,2},{1,4},{1,5},{2,3},{2,6}}, Arrays.asList(hasApple)) );

    }
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {

        //build a reverse adjacency table
        //map child->parent
        HashMap<Integer,Integer> adj = new HashMap<>();
        for(int[] edge : edges) {
            adj.put(edge[1],edge[0]);
        }

        //store apples
        ArrayList<Integer> apples = new ArrayList<>();
        for(int i=0;i<hasApple.size();i++) {
            if(hasApple.get(i)) apples.add(i);
        }
        System.out.println(apples);

        //build a minimum tree that contain all paths from root to an apple
        //store this tree as a collection of edges
        HashSet<List<Integer>> tree = new HashSet<>();
        for(int apple : apples) {
            Integer u = apple, v = adj.get(u);
            while(v!=null) {
                List<Integer> edge = Arrays.asList(u,v);
                if(tree.contains(edge)) break;
                tree.add(edge);
                u = v;
                v = adj.get(u);
            }
        }

//        System.out.println("TREE");
//        for(List<Integer> edge : tree) {
//            System.out.println(edge);
//
//        }
//        System.out.println("END");

        return 2*tree.size();

    }
}
