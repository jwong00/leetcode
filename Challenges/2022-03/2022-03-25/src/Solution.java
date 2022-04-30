import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
//        System.out.println(s.twoCitySchedCost(new int[][]{{10,20},{30,200},{400,50},{30,20}}));
        System.out.println(s.twoCitySchedCost(new int[][]{{259,770},{448,54},{926,667},{184,139},{840,118},{577,469}}));
    }

    public int twoCitySchedCost(int[][] costs) {
        PriorityQueue<Integer>  loss = new PriorityQueue<>((a,b)->
                Math.abs(costs[b][0]-costs[b][1])-Math.abs(costs[a][0]-costs[a][1]));

        for(int i=0;i<costs.length;i++) loss.add(i);

        int A=0,B=0,cost=0,n=costs.length/2;
        while(! loss.isEmpty()) {
            int i =  loss.poll();
            System.out.println(Arrays.toString(costs[i]) + " " + Math.abs(costs[i][0]-costs[i][1]));
            if(A < n && B < n) {
                if(costs[i][0] < costs[i][1]) {
                    A++;
                    cost+=costs[i][0];
                }
                else {
                    B++;
                    cost+=costs[i][1];
                }
            }
            else if(A < n) {
                cost+=costs[i][0];
                A++;
            }
            else if(B < n){
                cost+=costs[i][1];
                B++;
            }
            else System.out.println("You should not be here.");

        }

        return cost;

    }
}
