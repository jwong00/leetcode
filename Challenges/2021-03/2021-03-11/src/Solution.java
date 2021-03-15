import java.util.Arrays;

class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] t = new int[amount+1];
        Arrays.fill(t,amount+1);
        t[0]=0;

        for(int i=1;i<=amount;i++) {
            for(int j=0;j<coins.length;j++) {
                if(i<=coins[j]) Math.min(t[i],t[i-coins[j]]+1);
            }
        }


    }
}
