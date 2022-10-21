import java.util.*;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.findMinHeightTrees(4, new int[][]{{1,0},{1,2},{1,3}}));
    }
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        int[] outdegrees = new int[n];

        for(int[] edge : edges) {
            outdegrees[edge[0]]++;
            outdegrees[edge[1]]++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> outdegrees[b]-outdegrees[a]);

        for(int i=0; i<n; i++) {
            pq.offer(i);
        }

        System.out.println(pq);


//        System.out.println(Arrays.toString(outdegrees));

        return new ArrayList<>();
    }
}
