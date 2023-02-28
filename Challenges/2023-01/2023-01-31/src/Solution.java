import java.util.HashSet;
import java.util.PriorityQueue;

class Solution {
    public int bestTeamScore(int[] scores, int[] ages) {
        PriorityQueue<Integer> test = new PriorityQueue<>()
        return -1;
//        return dfs(scores,ages,new PriorityQueue<>((a,b)->ages[a]-ages[b]),0,0,scores.length);
    }

    public int dfs(int[] scores, int[] ages, /*HashSet<Integer> selection,*/ PriorityQueue<Integer> order, int i, int s, int n) {
//        if(selection.size()==n) return s;
        if(i>=n) return s;

        //if ith player is valid choice
        //try a team both with and without the player
        if(order.isEmpty() || order.peek() < i) {
            int without = dfs(scores,ages,order,i+1,s,n);
            order.offer(i);
            int with = dfs(scores,ages,order,i+1,s+scores[i],n);
            return Math.max(with,without);
        }

        return -1;

        //if invalid, build a team without the player and move on


    }
}