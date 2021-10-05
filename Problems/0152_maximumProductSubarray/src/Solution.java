class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] k = {2,3,-2,4};
        System.out.println(s.maxProduct(k));
        int[] q = {-2,0,-1};

        System.out.println(s.maxProduct(q));

        int[] j = {-2,-4,1,4,0,-2,4,2,8,2,-32,-3,1};

        System.out.println(s.maxProduct(j));
    }
    public int maxProduct(int[] nums) {
        int len = nums.length;
        int max=nums[0];

        for(int i=0;i<len;i++) {
            int acc = 1;
            for(int j=i;j<len;j++) {
                acc *= nums[j];
                max = Math.max(max,acc);
            }
        }

        return  max;
    }
}
