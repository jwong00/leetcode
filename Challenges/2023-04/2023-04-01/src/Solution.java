class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.search(new int[]{-1,0,3,5,9,12},9));
        System.out.println(s.search(new int[]{-1,0,3,5,9,12},2));
    }
    /*
    * Return index of target, if it exists
    * else return -1
    * */
    public int search(int[] nums, int target) {

        int l = 0, r = nums.length-1;

        while(l<=r) {

            int m = l + (r-l)/2;

            if(nums[m]==target) return m;

            if(target<nums[m])  r = m - 1;
            else                l = m + 1;
        }

        return -1;

    }
}
