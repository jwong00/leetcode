import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.minFlipsMonoIncr("00110");
        s.minFlipsMonoIncr("010110");
        s.minFlipsMonoIncr("00011000");
    }
    public int minFlipsMonoIncr(String s) {
        int n = s.length();
        if(n==0) return 0;

        int[] left = new int[n];
        if(s.charAt(0)=='1') left[0]=1;

        int[] right = new int[n];
        if(s.charAt(n-1)=='0') right[n-1]=1;

        for(int i=1;i<n;i++) {
            if(s.charAt(i)=='1') left[i] = 1 + left[i-1];
            else left[i] = left[i-1];
        }

        for(int j=n-2;j>=0;j--) {
            if(s.charAt(j)=='0') right[j] = 1 + right[j+1];
            else right[j] = right[j+1];
        }

//        System.out.println(s);
//        System.out.println(Arrays.toString(left));
//        System.out.println(Arrays.toString(right));

        int ans = left[0]+right[0]-1;
        for(int k=1;k<n;k++) {
            ans = Math.min(ans,left[k]+right[k]-1);
        }
//        System.out.println("MIN FLIPS: "+ans);

        return ans;

    }
}
