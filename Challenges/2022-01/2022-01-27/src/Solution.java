class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.findMaximumXOR(new int[]{3,10,5,25,2,8}));
    }
    public int findMaximumXOR(int[] nums) {
        return findMaximumXORnaive(nums);
    }

    public int findMaximumXORnaive(int[] nums) {
        int max = 0;

        for(int i=0;i<nums.length;i++) {
            for(int j=i+1;j<nums.length;j++) {
                System.out.printf("%d %d %d\n", nums[i],nums[j],nums[i]^nums[j]);
                max = Math.max(max,nums[i] ^ nums[j]);
            }
        }

        return max;
    }
}
