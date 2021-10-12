class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println(s.maxProfit(new int[]{7,6,4,3,1}));
    }
    public int maxProfit(int[] prices) {
        if(prices==null || prices.length==0) return 0;

        int min = prices[0], max = 0;

        for(int i=1;i<prices.length;i++) {
            max = Math.max(max,prices[i]-min);
            min = Math.min(min,prices[i]);
        }

        return max;
    }
}
