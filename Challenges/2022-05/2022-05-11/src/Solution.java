class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.countVowelStrings(1));
        System.out.println(s.countVowelStrings(2));
        System.out.println(s.countVowelStrings(33));
    }
    public static final int VOWEL_CNT = 5; //a e i o u

    public int countVowelStrings(int n) {
        return helper(n,0);
    }

    private int helper(int n, int i) {
        if(n==0) return 1;

        int ans = 0;
        for(int j=i;j<VOWEL_CNT;j++) {
            ans+=helper(n-1,j);
        }
        return ans;
    }
}
