import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.countBits(5)));

    }
    public int[] countBits(int n) {
        int[] ans = new int[n+1];

        for(int i=0;i<=n;i++) {
            int k = i;
            int count = 0;
            while (k > 0) {
                if ((k & 1) == 1) count++;
                k = k >> 1;
            }

            ans[i] = count;
        }

        return ans;
    }
}
