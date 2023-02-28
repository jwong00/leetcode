class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.searchInsert(new int[]{1,3,5,6},5));
        System.out.println(s.searchInsert(new int[]{1,3,5,6},2));
        System.out.println(s.searchInsert(new int[]{1,3,5,6},99));
        System.out.println(s.searchInsert(new int[]{1,3,5,6},0));
    }
    public int searchInsert(int[] nums, int target) {
        int l = 0, r = nums.length-1;
        int m = (r+l)/2;

        while(l<r) {
            if(nums[m]==target) return m;
            if(target < nums[m]) r = m - 1;
            else l = m + 1;
            m = (l+r)/2;
        }

        return target<nums[m] ? m : m+1;
    }
}
