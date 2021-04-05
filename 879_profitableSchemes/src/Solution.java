class Solution {
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {

    }

    public int commit(int n, int minProfit, int[] group, int[] profit, int i) {
        int sum;
        if(n<group[i] && minProfit>profit[i])

            //choose to commit crime_i

            if(n<group[i] && minProfit>profit[i]) commit(n-group[i],minProfit-profit[i])
            //choose not to
    }
}
