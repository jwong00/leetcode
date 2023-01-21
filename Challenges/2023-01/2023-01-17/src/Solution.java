class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.minFlipsMonoIncr("00110"));
        System.out.println(s.minFlipsMonoIncr("010110"));
        System.out.println(s.minFlipsMonoIncr("00011000"));
    }
    public int minFlipsMonoIncr(String s) {
        int m = 0;
        for(int i=0;i<s.length();i++) {
            if(s.charAt(i)=='0') m++;
        }

        int ans = m;

        for(int i=0;i<s.length();i++) {
            if(s.charAt(i)=='0') {
                m--;
                ans = Math.min(ans,m);
            }
            else m++;
        }

        return ans;
    }
}
