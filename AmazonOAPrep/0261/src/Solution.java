import java.util.*;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.validTree(5,new int[][]{{0,1},{0,2},{0,3},{1,4}}));
    }
    public boolean validTree(int n, int[][] edges) {
//        List<Integer> adj = new ArrayList<>();
        HashMap<Integer,List<Integer>> adj = new HashMap<>();
        int[] indegrees = new int[n];

        for(int[] edge : edges) {
            int u = edge[0], v = edge[1];
//            adj.put(u,adj.getOrDefault(u,new ArrayList<>()));
            if(!adj.containsKey(u)) adj.put(u,new ArrayList<>());
            adj.get(u).add(v);
            indegrees[v]++;
        }

        Deque<Integer> q = new ArrayDeque<>();
        for(int i=0;i<n;i++) {
            if(indegrees[i]==0) q.offer(i);
        }


        int count = 0;
        while(!q.isEmpty()) {
            //remove each edge from each queued node
            List<Integer> targets = adj.get(q.peek());
            for(int target : targets) {
                indegrees[target]--;
                count++;
                if(indegrees[target]==0) q.offer(target);
            }
            q.poll();
        }

        return count==n;

    }
}