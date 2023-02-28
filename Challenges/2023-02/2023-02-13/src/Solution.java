class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.countOdds(2,5)); //2
        System.out.println(s.countOdds(3,7)); //3
        System.out.println(s.countOdds(8,10)); //1
        System.out.println(s.countOdds(2,6)); //2
        System.out.println(s.countOdds(21,22)); //1
    }
    public int countOdds(int low, int high) {
        if(high%2==0 && low%2==0) return (high-low)/2;
        return (high-low)/2 + 1;
    }
}
