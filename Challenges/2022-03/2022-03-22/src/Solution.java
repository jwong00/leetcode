import java.util.Arrays;

class Solution {

    public static boolean DEBUG = false;

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.getSmallestString(3,27));
        System.out.println(s.getSmallestString(5,73));
    }
    public String getSmallestString(int n, int k) {
        int[] value = new int[n];

        for(int i=n-1;i>=0;i--) {
            value[i] = Math.min(k - i, 26) + 'a' - 1;
            k-=(value[i] - 'a' + 1);
        }

        StringBuilder sb = new StringBuilder();

        if(DEBUG) System.out.println(Arrays.toString(value));

        for(int i=0;i<n;i++) {
            sb.append((char)value[i]);
        }

        return sb.toString();
    }
}
