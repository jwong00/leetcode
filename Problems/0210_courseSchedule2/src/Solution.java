import java.util.*;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.findOrder(2,new int[][]{{1,0}})));
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //build graph
        HashMap<Integer, List<Integer>> adj = new HashMap<>();
        int[] indegree = new int[numCourses];

        for(int[] course : prerequisites) {
            List<Integer> targets = adj.getOrDefault(course[1],new ArrayList<Integer>());
            targets.add(course[0]);
            adj.put(course[1],targets);
            indegree[course[0]]++;
        }

        //Kahn
        Deque<Integer> queue = new ArrayDeque<>();
        for(int i=0;i<indegree.length;i++) {
            if(indegree[i]==0) queue.offer(i);
        }

        int count = 0;
        int[] ans = new int[numCourses];
        while(!queue.isEmpty()) {
            int n = queue.poll();
            ans[count++] = n;
            if(adj.containsKey(n)) {
                for (Integer target : adj.get(n)) {
                    if (--indegree[target] == 0) queue.offer(target);
                }
            }
        }

        return ans;

    }
}
