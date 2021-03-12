import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] r = {186,419,83,408};
        System.out.println(s.coinChange(r,6249));
    }
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);

        System.out.println(Arrays.toString(coins));
        int count=0;
        for(int i=coins.length-1;i>=0;i--) {
            while(amount>=coins[i]) {
                count++;
                amount-=coins[i];
            }
        }

        System.out.println(count);
        System.out.println(amount);

        return amount==0 ? count : -1;
    }
}
