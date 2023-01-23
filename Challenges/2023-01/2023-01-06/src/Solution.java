import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.maxIceCream(new int[]{1,3,2,4,1},7));
        System.out.println(s.maxIceCream(new int[]{10,6,8,7,7,8},5));
        System.out.println(s.maxIceCream(new int[]{1,6,3,1,2,5},20));
    }
    public int maxIceCream(int[] costs, int coins) {
        if(costs.length==0) return 0;
        int n = costs.length;

        Arrays.sort(costs);

        int ans = 0;
        for(int i=0;i<n && coins>0;i++) {
            if(coins>=costs[i]) {
                coins-=costs[i];
                ans++;
            }
            else break;
        }

        return ans;
    }
}
