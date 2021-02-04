class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.rangeBitwiseAndBrute(7,33));
        System.out.println(s.rangeBitwiseAnd(12,15));
        System.out.println(s.rangeBitwiseAndBrute(12,15));

        System.out.println(s.rangeBitwiseAndBrute(2147483646,2147483647));
    }
    public int rangeBitwiseAnd(int m, int n) {
        if(m==0 || n==0) return 0;
        if(m==n) return m;

        String lower = Integer.toBinaryString(m);
        String upper = Integer.toBinaryString(n);

        if(lower.length() < upper.length()) return 0;
        else return rangeBitwiseAndBrute(m,n);
    }

    public int rangeBitwiseAndBrute(int m, int n) {
        int k=m;
        for(int i=m+1; i<=n; i++) {
            k&=i;
            if(n==Integer.MAX_VALUE) break;
        }
        return k;
    }
}
