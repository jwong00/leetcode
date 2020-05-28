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
        int left = 0;
        int right = 1;
        int max = nums[0]*nums[1];
        int acc = nums[0];
        while(right<nums.length) {
            acc *= nums[right];
            if(acc >= max) {
                max = acc;
                while(acc>max) {
                    left++;

                }
            }

            System.out.println(acc+":"+max);
            right++;
        }



        return  max;
    }
}
