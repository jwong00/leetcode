class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] q = {2,6,4,8,10,9,15};
        int[] t = {1};

        System.out.println(s.findUnsortedSubarray(q));
        System.out.println(s.findUnsortedSubarray(t));
    }
    public int findUnsortedSubarray(int[] nums) {
        if(nums==null || nums.length==0) return 0;
        int left = 0;
        int right = nums.length-1;

        while(left+1<nums.length && nums[left]<nums[left+1]) {
            left++;
        }

        while(right-1>0 && nums[right]>nums[right-1]) {
            right--;
        }

        System.out.println("LEFT: "+left+" RIGHT: "+right);

        if(left<right) return right-left+1;
        else return 0;

    }
}
