import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.constructArray(6,3);
        s.constructArray(7,5);
    }
    public int[] constructArray(int n, int k) {
        if(k>=n) return null;

        int[] result = new int[n];

        int s=1;
        int t=n-k-1;
        for(int i=0,c=n;i<n;i++) {
            if(k>=0) {
                result[i] = c;
                c -= k * s;
                k -= 1;
                s *= -1;
            }
            else result[i]=t--;
        }

        System.out.println(Arrays.toString(result));
        return result;
    }
}
