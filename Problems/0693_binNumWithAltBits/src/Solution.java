class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.hasAlternatingBits(5));
        System.out.println(s.hasAlternatingBits(7));
        System.out.println(s.hasAlternatingBits(11));
    }
    public boolean hasAlternatingBits(int n) {
        int r = -1;
        while(n>0) {
            if(n%2==r) return false;
            else r = n%2;
            n/=2;
        }
        return true;
    }
}
