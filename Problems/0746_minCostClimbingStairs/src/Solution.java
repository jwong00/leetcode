class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.minCostClimbingStairs(new int[]{10,15,20}));
        System.out.println(s.minCostClimbingStairs(new int[]{1,100,1,1,1,100,1,1,100,1}));
    }
    public int minCostClimbingStairs(int[] cost) {
        if(cost==null || cost.length==0) return -1;

        int n = cost.length;

        for(int i=n-3;i>=0;i--) {
            cost[i] = cost[i] + Math.min(cost[i+1],cost[i+2]);
        }

        return Math.min(cost[0],cost[1]);

    }
}