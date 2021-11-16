class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.missingNumber(new int[]{3,0,1}));
    }
    public int missingNumber(int[] nums) {
        int mask = nums.length;
        for(int i=0;i<nums.length;i++) {
            mask ^= i ^ nums[i];
        }
        return mask;
    }
}
