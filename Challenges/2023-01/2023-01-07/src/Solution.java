class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.canCompleteCircuit(new int[]{1,2,3,4,5},new int[]{3,4,5,1,2}));
        System.out.println(s.canCompleteCircuit(new int[]{2,3,4},new int[]{3,4,3}));

    }
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;


        int tank = 0;
        int cur_gas = 0;
        int start = 0;
        for(int i=0;i<n;i++) {
            int net = gas[i] - cost[i];
            tank+=net;
            cur_gas+=net;
            if(cur_gas<0) {
                start = i + 1;
                cur_gas = 0;
            }

        }

        return tank>=0 ? start : -1;

    }
}
