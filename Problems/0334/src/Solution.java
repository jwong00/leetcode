class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.increasingTriplet(new int[]{1,2,3,4,5}));
        System.out.println(s.increasingTriplet(new int[]{5,4,3,2,1}));
        System.out.println(s.increasingTriplet(new int[]{2,1,5,0,4,6}));
    }
    public boolean increasingTriplet(int[] nums) {
        int a = Integer.MAX_VALUE;
        int b = Integer.MAX_VALUE;
        for(int n : nums) {
            if(n<=a) a = n;
            else if(n<=b) b = n;
            else return true;
        }
        return false;
    }
}
