class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.singleNumber(new int[]{2,2,1}));
        System.out.println(s.singleNumber(new int[]{4,1,2,1,2}));
        System.out.println(s.singleNumber(new int[]{1}));
    }
    public int singleNumber(int[] nums) {
        int k = nums[0];
        for(int i=1;i<nums.length;i++) {
            k ^= nums[i];
        }

        return k;
    }
}
