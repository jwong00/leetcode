class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.rangeBitwiseAnd(5,7));
        System.out.println(s.rangeBitwiseAnd(1,7));
    }
    public int rangeBitwiseAnd(int left, int right) {
        int ans = left;

        for(int i=ans+1;i<=right;i++) {
            ans &= i;
        }
        return ans;

    }
}
