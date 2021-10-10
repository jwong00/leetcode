public class Solution {
    public static void main(String args[]) {
        Solution s = new Solution();
        System.out.println(s.climbStairs(3));
        System.out.println(s.climbStairs(6));
    }

    public int[] table = new int[1000];

    public int climbStairs(int n) {
        if(n<=2) return n;
        else if(table[n]==0) table[n]=climbStairs(n-1)+climbStairs(n-2);
        return table[n];
    }
}
