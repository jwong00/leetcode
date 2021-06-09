class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.minCostClimbingStairs(new int[] {10,15,20}));
        System.out.println(s.minCostClimbingStairs(new int[] {1,100,1,1,1,100,1,1,100,1} ));
    }
    public int minCostClimbingStairs(int[] cost) {
        if(cost==null) return 0;
        if(cost.length==2) return Math.min(cost[0],cost[1]);
        if(cost.length==1) return cost[0];

        int[] minCost = new int[cost.length];
        minCost[cost.length-1] = cost[cost.length-1];
        minCost[cost.length-2] = cost[cost.length-2];

        for(int i=minCost.length-3;i>=0;i--) {
            minCost[i] = cost[i] + Math.min(minCost[i+1],minCost[i+2]);
        }

        return Math.min(minCost[0],minCost[1]);
    }
}
