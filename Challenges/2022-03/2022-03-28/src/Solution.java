class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.search(new int[]{2,5,6,0,0,1,2},0));
        System.out.println(s.search(new int[]{2,5,6,0,0,1,2},3));
        System.out.println(s.search(new int[]{2,5,6,0,0,1,2},6));
    }
    public boolean search(int[] nums, int target) {
        int l=0, r=nums.length-1;
        int m=r/2;

        while(l<=r) {
            if(nums[m]==target) return true;
            else if(nums[m]<=target || target<=nums[r]) {
                l = m-1;
            }
            else if(nums[l]<=target || target<=nums[m]) {
                r = m+1;
            }

            m = l + (r-l)/2;
        }

        return false;
    }
}
