class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.findUnsortedSubarray(new int[]{2,6,4,8,10,9,15}));
        System.out.println(s.findUnsortedSubarray(new int[]{1}));
    }
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int l = 0, r = n - 1;
        int min = nums[r], max = nums[l];

        for(int i = l; i < n; i++) {
            if(nums[i] < max) l = i;
            max = Math.max(max,nums[i]);
        }

        for(int j = r; j >= 0; j--) {
            if(nums[j] > min) r = j;
            min = Math.min(min,nums[j]);
        }

        if(l==0 && r==n-1) return 0;
        else return l-r+1;
    }
}
