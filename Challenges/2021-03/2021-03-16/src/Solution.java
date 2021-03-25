
//At the end of the i-th day, we maintain cash, the maximum profit we could have if we did not have a share of stock, and hold, the maximum profit we could have if we owned a share of stock.

//        To transition from the i-th day to the i+1-th day, we either sell our stock cash = max(cash, hold + prices[i] - fee) or buy a stock hold = max(hold, cash - prices[i]). At the end, we want to return cash. We can transform cash first without using temporary variables because selling and buying on the same day can't be better than just continuing to hold the stock.


class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] p = {1,3,2,8,4,9};
        s.maxProfit(p, 2);

    }
    public int maxProfit(int[] prices, int fee) {
        int cash = 0;
        int hold = -prices[0];

        for(int i=0;i<prices.length;i++) {
            cash = Math.max(cash, hold+prices[i]-fee);
            hold = Math.max(hold,cash-prices[i]);
            System.out.println("Stock price for day "+i+" is "+prices[i]);
            System.out.println("CASH: "+cash);
            System.out.println("HOLD: "+hold);
        }

        return cash;

    }
}
