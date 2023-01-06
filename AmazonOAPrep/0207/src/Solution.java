import java.util.*;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.canFinish(2, new int[][]{{1,0}}));
        System.out.println(s.canFinish(2, new int[][]{{1,0},{0,1}}));
        System.out.println(s.canFinish(4, new int[][]{{1,0},{2,1},{3,0}}));
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        HashSet<Integer> visited = new HashSet<Integer>();

        //adj table rep of graph
        HashMap<Integer, List<Integer>> adj = new HashMap<Integer, List<Integer>>();

        for(int[] prerequisite : prerequisites) {
            List<Integer> targets = adj.getOrDefault(prerequisite[1],new ArrayList<Integer>());
            targets.add(prerequisite[0]);
            adj.put(prerequisite[1],targets);
            indegree[prerequisite[0]]++;
        }

        // KAAAHHN
        ArrayDeque<Integer> s = new ArrayDeque<>();
        for(int i=0;i<indegree.length;i++) {
            if(indegree[i]==0) s.offer(i);
        }

        int count = 0;
        while(!s.isEmpty()) {
            List<Integer> targets = adj.getOrDefault(s.poll(),new ArrayList<Integer>());
            count++;
            for(int node : targets) {
                if(--indegree[node]==0) s.offer(node);
            }
        }

        return count==numCourses;
    }
}
