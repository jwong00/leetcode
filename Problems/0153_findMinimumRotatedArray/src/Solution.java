class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.findMin(new int[]{4,5,6,7,0,1,2});
    }
    public int findMin(int[] nums) {
        if(nums==null || nums.length==0) return -1;

        int left = 0, right = nums.length-1;
        int center = (left + right)/2;

        int min = nums[center];

        while(left<=right) {

            min = Math.min(min,nums[center]);

            if(nums[left] > nums[center]) right = center-1;
            else left = center;

            center = left + (right-left)/2;

        }

        System.out.println(nums[center]);


        return center;
    }
}
